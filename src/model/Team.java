package model;

import service.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public void addPlayer(Player player) {
		teamList.add(player);
	}

	public void dismissPlayer(Player player) {
		if (teamList.contains(player)) {
			teamList.remove(player);
		} else {
			System.out.println("Игрок " + player + " не входит в команду");
		}
	}

	public void destroyTeam() {
		DataBase.allTeams.remove(this);
	}

	public synchronized void transfer(Player player, Team to) {
		teamList.remove(player);
		to.addPlayer(player);
	}

	private List<Player> playersOnPosition(Positions position) {
		return teamList.stream().filter(p -> (p.getPosition().equals(position))).collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Team " + name + "\n");
		for (Positions pos : Positions.values()) {
			for (Player p : playersOnPosition(pos)) {
				sb.append(" " + p.getPositionName() + " " + p.getName() + "\n");
			}
		}
		return sb.toString();
	}
}
