package service;

import model.BetEvent;
import model.EventResult;
import model.KapperInfo;
import model.dao.UsersEntity;
import org.hibernate.Session;
import service.db.HibernateSessionFactory;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created by Shoma on 29.09.2018.
 */
public class Contract implements IContract {
    private Session session;

    public Contract() {
        if (session == null) {
            session = HibernateSessionFactory.getSessionFactory().openSession();
        }
    }

    public Contract(Session session) {
        this.session = session;
    }

    @Override
    public KapperInfo initCapper(int user_id) {
        UsersEntity user = session.load(UsersEntity.class, user_id);
        KapperInfo kapper = null;
        if (user==null){
            System.out.println("Пользователь с идентификатором "+user_id + " не найден в системе");
            return null;
        } else if (user != null && !user.hasRole("ROLE_KAPPER")){
            System.out.println("У пользователя с иденитфикатором "+user_id + " нет роли Каппера. Его инициализация невозможна. ");
            return null;
        } else {
            session.beginTransaction();

            try {
                kapper = session.bySimpleNaturalId(KapperInfo.class).load(user_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (kapper != null) {
                System.out.println("Каппер с таким идентификатором уже прошел инициализацию");
            } else {
                kapper = new KapperInfo();
                kapper.setUserId(user_id);
                kapper.setTokens(new BigInteger("500"));
                session.saveOrUpdate(kapper);
                session.getTransaction().commit();
            }
        }
        return kapper;
    }

    @Override
    public void betReputation(BetEvent event, int tokens) {

    }

    @Override
    public KapperInfo getKapperInfo(int user_id) {
        return null;
    }

    @Override
    public EventResult getBettingResult(BetEvent event) {
        return null;
    }

    @Override
    public Map<UsersEntity, Double> getBalance() {
        return null;
    }

    @Override
    public Map<UsersEntity, KapperInfo> getRaiting() {
        return null;
    }
}
