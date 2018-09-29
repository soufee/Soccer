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
            UsersEntity ashamaz = session.bySimpleNaturalId(UsersEntity.class).load("ashamaz");
            UsersEntity ula = session.bySimpleNaturalId(UsersEntity.class).load("ulaula");
            contract.initCapper(ashamaz.getUserId());

            KapperInfo ashamazInfo = session.bySimpleNaturalId(KapperInfo.class).load(ashamaz.getUserId());
            System.out.println(ashamazInfo==null?" пользователь не проинициализирован": ashamazInfo.getTokens());
            System.out.println("--------------");
            contract.initCapper(ula.getUserId());
            KapperInfo ulaInfo = session.bySimpleNaturalId(KapperInfo.class).load(ula.getUserId());

            System.out.println(ulaInfo==null?" пользователь не проинициализирован": ulaInfo.getTokens());

        } finally {
            System.exit(0);
        }
    }
}
