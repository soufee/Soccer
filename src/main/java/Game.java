import model.KapperInfo;
import model.dao.UsersEntity;
import org.hibernate.Session;
import service.Contract;
import service.db.HibernateSessionFactory;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class Game {
    public static void main(String[] args) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Contract contract = new Contract(session);
            Map<UsersEntity, Double> balance = contract.getBalance();
            for (Map.Entry<UsersEntity, Double> e : balance.entrySet()) {
                System.out.println(e.getKey().getUserId() + " " + e.getKey().getName() + " : Баланс = " + e.getValue());
            }
            Map<UsersEntity, KapperInfo> allInfo = contract.getAllInfo();
            for (Map.Entry<UsersEntity, KapperInfo> e : allInfo.entrySet()) {
                System.out.println(e.getKey().getUserId() + " " + e.getKey().getName() + " : Баланс = " + e.getValue().getTokens() + ". Из них заблокировано " + e.getValue().getBlockedTokens());
            }
            contract.transferTokens(4, 3, 25d);
            contract.blockTokens(4, 100);
            contract.blockTokens(3, 16);
            balance = contract.getBalance();
            for (Map.Entry<UsersEntity, Double> e : balance.entrySet()) {
                System.out.println(e.getKey().getUserId() + " " + e.getKey().getName() + " : Баланс = " + e.getValue());
            }

            allInfo = contract.getAllInfo();
            for (Map.Entry<UsersEntity, KapperInfo> e : allInfo.entrySet()) {
                System.out.println(e.getKey().getUserId() + " " + e.getKey().getName() + " : Баланс = " + e.getValue().getTokens() + ". Из них заблокировано " + e.getValue().getBlockedTokens());
            }
        } finally {
            System.exit(0);
        }
    }
}
