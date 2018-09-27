import model.Player;
import model.Positions;
import model.Team;
import service.DataBase;

public class Game {
	public static void main(String[] args) {
		Team real = new Team("Real");
		Team barsa = new Team("Barselona");

		barsa.addPlayer(new Player("Rakitic", Positions.MC));
		barsa.addPlayer(new Player("Suares", Positions.ST));
		barsa.addPlayer(new Player("Vidal", Positions.MC));
		barsa.addPlayer(new Player("Jerar Pique", Positions.DC));
		barsa.addPlayer(new Player("Samuel Umtiti", Positions.DC));
		barsa.addPlayer(new Player("Jordi Alba", Positions.DL));
		barsa.addPlayer(new Player("Sergi Roberto", Positions.DR));
		barsa.addPlayer(new Player("Busquets", Positions.DMC));
		barsa.addPlayer(new Player("Messi", Positions.AMR));
		barsa.addPlayer(new Player("Filippe Coutinho", Positions.AML));
		barsa.addPlayer(new Player("Mark Andre Ter Stegen", Positions.GK));

		real.addPlayer(new Player("Assensio", Positions.AML));
		real.addPlayer(new Player("Benzema", Positions.ST));
		real.addPlayer(new Player("Modric", Positions.MC));
		real.addPlayer(new Player("Sergio Ramos", Positions.DC));
		real.addPlayer(new Player("Varane", Positions.DC));
		real.addPlayer(new Player("Marselo", Positions.DL));
		real.addPlayer(new Player("Carvajal", Positions.DR));
		real.addPlayer(new Player("Casemiro", Positions.DMC));
		real.addPlayer(new Player("Gareth Bale", Positions.AMR));
		real.addPlayer(new Player("Tony Kroos", Positions.MC));
		real.addPlayer(new Player("Kalor Navas", Positions.GK));

		DataBase.allPlayers.forEach(System.out::println);
		System.out.println("-----------");
		DataBase.allTeams.forEach(System.out::println);
		System.out.println("-----------");

	}
}
