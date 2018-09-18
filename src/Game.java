import model.Player;
import model.Team;
import service.DataBase;

public class Game {
	public static void main(String[] args) {
		Player cr = new Player("Ronaldo", "ST");
		Player benzema = new Player("Benzema", "ST");
		Player modric = new Player("Modric", "MC");
		Player ramos = new Player("Sergio Ramos", "DC");
		Team real = new Team("Real");
		real.addPlayer(benzema);
		real.addPlayer(modric);
		real.addPlayer(cr);
		real.addPlayer(ramos);

		DataBase.allPlayers.forEach(System.out::println);
		System.out.println("-----------");
		DataBase.allTeams.forEach(System.out::println);
		System.out.println("-----------");

	}
}
