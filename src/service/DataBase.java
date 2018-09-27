package service;

import model.Player;
import model.Team;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	public static List<Player> allPlayers = new ArrayList<>();
	public static List<Team> allTeams = new ArrayList<>();

	public static Team getTeam(String name){
		return allTeams.stream().filter(s ->s.getName().equals(name)).findFirst().get();
	}
}
