import model.Player;
import model.Positions;
import model.Team;
import model.dao.LeagueEntity;
import model.dao.TeamEntity;
import org.hibernate.Session;
import service.DataBase;
import service.Match;
import service.db.HibernateSessionFactory;
import util.GameResults;
import util.TeamFactory;

import java.util.List;

public class Game {
    public static void main(String[] args) {
//        Team real = new Team("Real");
//        Team barsa = new Team("Barselona");
//
//        barsa.addPlayer(new Player("Rakitic", Positions.MC));
//        barsa.addPlayer(new Player("Suares", Positions.ST));
//        barsa.addPlayer(new Player("Vidal", Positions.MC));
//        barsa.addPlayer(new Player("Jerar Pique", Positions.DC));
//        barsa.addPlayer(new Player("Samuel Umtiti", Positions.DC));
//        barsa.addPlayer(new Player("Jordi Alba", Positions.DL));
//        barsa.addPlayer(new Player("Sergi Roberto", Positions.DR));
//        barsa.addPlayer(new Player("Busquets", Positions.DMC));
//        barsa.addPlayer(new Player("Messi", Positions.AMR));
//        barsa.addPlayer(new Player("Filippe Coutinho", Positions.AML));
//        barsa.addPlayer(new Player("Mark Andre Ter Stegen", Positions.GK));
//
//        real.addPlayer(new Player("Assensio", Positions.AML));
//        real.addPlayer(new Player("Benzema", Positions.ST));
//        real.addPlayer(new Player("Modric", Positions.MC));
//        real.addPlayer(new Player("Sergio Ramos", Positions.DC));
//        real.addPlayer(new Player("Varane", Positions.DC));
//        real.addPlayer(new Player("Marselo", Positions.DL));
//        real.addPlayer(new Player("Carvajal", Positions.DR));
//        real.addPlayer(new Player("Casemiro", Positions.DMC));
//        real.addPlayer(new Player("Gareth Bale", Positions.AMR));
//        real.addPlayer(new Player("Tony Kroos", Positions.MC));
//        real.addPlayer(new Player("Kalor Navas", Positions.GK));
//
//        DataBase.allPlayers.forEach(System.out::println);
//        System.out.println("-----------");
//        DataBase.allTeams.forEach(System.out::println);
//        System.out.println("-----------");
//        Match match = new Match() {
//            @Override
//            public GameResults play(Team hostTeam, Team guestTeam) {
//                GameResults gameResults = new GameResults(hostTeam, guestTeam);
//                List<Player> hosts = hostTeam.getTeamList();
//                List<Player> guests = guestTeam.getTeamList();
//                int hostCount = 0;
//                int guestCount = 0;
//                for (int i = 0; i < 11; i++) {
//                    if (hosts.get(i).compareTo(guests.get(i))==1) hostCount++;
//                    else if (hosts.get(i).compareTo(guests.get(i))==-1) guestCount++;
//                }
//                gameResults.setCount(hostCount + ":"+guestCount);
//                gameResults.setWinner(hostCount>guestCount?hostTeam:(guestCount>hostCount?guestTeam:null));
//                System.out.println("Игра окончена. Счет "+gameResults.getCount());
//                return gameResults;
//            }
//        };
//        match.play(real, barsa);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        LeagueEntity leagueEntity = new LeagueEntity();
        leagueEntity.setCountryId(2);
        leagueEntity.setTeamCapacity(20);
        leagueEntity.setNameOfLeague("Prime league");
        session.saveOrUpdate(leagueEntity);
        int leagueId = leagueEntity.getId();
        session.saveOrUpdate(TeamFactory.getTeamInstance("Chelsea", "London", "England", leagueId));
        session.saveOrUpdate(TeamFactory.getTeamInstance("Liverpool FC", "Liverpool", "England", leagueId));
        session.saveOrUpdate(TeamFactory.getTeamInstance("Tothenham", "London", "England", leagueId));
        session.saveOrUpdate(TeamFactory.getTeamInstance("Arsenal", "London", "England", leagueId));
        session.saveOrUpdate(TeamFactory.getTeamInstance("Manchester United", "Manchester", "England", leagueId));
        session.saveOrUpdate(TeamFactory.getTeamInstance("Manchester city", "Manchester", "England", leagueId));

        session.getTransaction().commit();
        session.close();
    }
}
