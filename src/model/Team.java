package model;

import service.DataBase;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private List<Player> teamList = new ArrayList<>();
	private String name;

	public Team(String name) {
		this.name = name;
		DataBase.allTeams.add(this);
	}

	public List<Player> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Player> teamList) {
		this.teamList = teamList;
	}

	public void addPlayer (Player player){
		teamList.add(player);
	}

	public void dismissPlayer(Player player){
		if (teamList.contains(player))
			teamList.remove(player);
		else {
			System.out.println("Игрок "+player +" не входит в команду");
		}
	}

	public void destroyTeam(){
		DataBase.allTeams.remove(this);
	}

	public synchronized void transfer(Player player, Team to){
		teamList.remove(player);
		to.addPlayer(player);
	}

	@Override
	public String toString() {
		return "Team name " + name +
			   "; teamList=" + teamList +
			   '}';
	}
}
