package ru.logic.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

//@Log4j
@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userJSP", "Это страница для всех");
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "/kapper")
	public ModelAndView kapper(@ModelAttribute("userJSP") String s) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("kapper");
		modelAndView.addObject("userJSP", "Это страница каппера");
		return modelAndView;
	}

	@RequestMapping(value = "/userpage")
	public ModelAndView userpage(@ModelAttribute("userJSP") String s) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userpage");
		modelAndView.addObject("userJSP", "Это страница пользователя");
		return modelAndView;
	}

	@RequestMapping(value = "/admin")
	public ModelAndView admin(@ModelAttribute("userJSP") String s) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin");
		modelAndView.addObject("userJSP", "Это страница администратора");
		return modelAndView;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about(@ModelAttribute("userJSP") String s) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about");
		modelAndView.addObject("userJSP", "О проекте");
		return modelAndView;
	}

	@RequestMapping(value = "/contacts")
	public ModelAndView contacts(@ModelAttribute("userJSP") String s) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contacts");
		modelAndView.addObject("userJSP", "Контактная информация");
		String contactList = "";
		contactList = getSource("contacts.html");
		modelAndView.addObject("contacts", contactList);

		return modelAndView;
	}

	private String getSource(String s) throws IOException {
		File dir = new File(".");
        String[] files = dir.list();
        if (dir.isDirectory() && files != null) {
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        }

		File file = new File(s);
		FileInputStream stream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		StringBuilder sb = new StringBuilder();
		String strLine = "";
		try{
		while ((strLine = br.readLine()) != null) {
			sb.append(strLine);
		}
		}catch (IOException e){
			//TODO реализовать свои ошибки
			throw e;
		} finally {
			stream.close();
			br.close();
		}
		return sb.toString();
	}



	@RequestMapping(value = "/privatepage")
	public ModelAndView privatepage(@ModelAttribute("userJSP") String s) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("privatepage");
		modelAndView.addObject("userJSP", "Личный кабинет");
		return modelAndView;
	}
}
