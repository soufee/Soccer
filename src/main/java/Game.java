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
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            TeamEntity entity = session.byNaturalId(TeamEntity.class).using("name", "Liverpool FC").load();
            //       session.getTransaction().commit();
            System.out.println(entity.getCountry() + " " + entity.getCity() + " from league " + session.load(LeagueEntity.class, entity.getLeagueId()).getNameOfLeague());
        }
        System.exit(0);
    }
}
