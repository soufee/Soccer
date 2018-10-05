package ru.javastudy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView kapper(@ModelAttribute("userJSP")  String s) {
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
    public ModelAndView admin(@ModelAttribute("userJSP")  String s) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("userJSP", "Это страница администратора");
        return modelAndView;
    }
}
