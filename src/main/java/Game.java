import model.KapperInfo;
import model.dao.UsersEntity;
import org.hibernate.Session;
import service.Contract;
import service.db.HibernateSessionFactory;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Game {
    public static void main(String[] args) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            Contract contract = new Contract(session);
            contract.getAllInfo();
        } finally {
            System.exit(0);
        }
    }
}
