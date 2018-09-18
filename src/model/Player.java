package model;

import service.DataBase;

import java.util.Random;

public class Player {
	String name;
	String position;
	int attackQuality;
	int midQuality;
	int defQuality;

	public Player(String name, String position) {
		this.name = name;
		this.position = position;
		getRandomQuality(this);
		DataBase.allPlayers.add(this);
	}

	public String getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAttackQuality() {
		return attackQuality;
	}

	public void setAttackQuality(int attackQuality) {
		this.attackQuality = attackQuality;
	}

	public int getMidQuality() {
		return midQuality;
	}

	public void setMidQuality(int midQuality) {
		this.midQuality = midQuality;
	}

	public int getDefQuality() {
		return defQuality;
	}

	public void setDefQuality(int defQuality) {
		this.defQuality = defQuality;
	}

	@Override
	public String toString() {
		return "Player{" +
			   "name='" + name + '\'' +
			   ", position='" + position + '\'' +
			   ", attackQuality=" + attackQuality +
			   ", midQuality=" + midQuality +
			   ", defQuality=" + defQuality +
			   '}';
	}

	private static void getRandomQuality(Player player) {
		switch (player.getPosition()) {
			case "ST":
				player.attackQuality = (int) ((Math.random() * 25) + 40);
				player.midQuality = (int) ((Math.random() * 20) + 35);
				player.defQuality = (int) ((Math.random() * 15) + 30);
				break;
			case "MC":
				player.attackQuality = (int) ((Math.random() * 20) + 35);
				player.midQuality = (int) ((Math.random() * 20) + 40);
				player.defQuality = (int) ((Math.random() * 20) + 30);
				break;
			case "DC":
				player.attackQuality = (int) ((Math.random() * 15) + 30);
				player.midQuality = (int) ((Math.random() * 20) + 35);
				player.defQuality = (int) ((Math.random() * 25) + 40);
				break;
			case "GK":
				player.attackQuality = (int) ((Math.random() * 10) + 35);
				player.midQuality = (int) ((Math.random() * 10) + 35);
				player.defQuality = (int) ((Math.random() * 30) + 40);
				break;
		}

	}
}
