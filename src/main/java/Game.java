import model.dao.KapperInfo;
import org.hibernate.Session;
import service.Contract;
import service.db.HibernateSessionFactory;

import java.util.Map;

public class Game {
    public static void main(String[] args) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Contract contract = new Contract(session);

        } finally {
            System.exit(0);
        }
    }
}
