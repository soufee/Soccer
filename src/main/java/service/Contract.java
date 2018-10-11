package service;

import model.dao.KapperInfo;
import model.dao.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import service.db.HibernateSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shoma on 29.09.2018.
 */
public class Contract implements IContract {
	private Session session;

	public Session getSession() {
		return session;
	}

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
		Users user = session.load(Users.class, user_id);
		KapperInfo kapper = null;
		if (user == null) {
			System.out.println("Пользователь с идентификатором " + user_id + " не найден в системе");
			return null;
		} else if (!user.hasRole(3)) {
			System.out.println("У пользователя с иденитфикатором " + user_id + " нет роли Каппера. Его инициализация невозможна. ");
			return null;
		} else {
			session.beginTransaction();

			try {
				kapper = session.bySimpleNaturalId(KapperInfo.class).load(user_id);
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			if (kapper != null) {
				System.out.println("Каппер с таким идентификатором уже прошел инициализацию");
			} else {
				kapper = new KapperInfo();
				kapper.setUser(user);
				kapper.setTokens(500d);
				session.saveOrUpdate(kapper);
				session.getTransaction().commit();
			}
		}
		return kapper;
	}

	@Override
	public KapperInfo getKapperInfo(int userId) {
		return session.bySimpleNaturalId(KapperInfo.class).load(userId);
	}


	@Override
	public void blockTokens(int userId, double amount) {
		KapperInfo from = session.bySimpleNaturalId(KapperInfo.class).load(userId);
		double fromBalance = from.getTokens();
		if (fromBalance >= amount) {
			session.beginTransaction();
			from.setBlockedTokens(from.getBlockedTokens() + amount);
			session.saveOrUpdate(from);
			session.getTransaction().commit();
		} else {
			throw new IllegalArgumentException("Недостаточно средств на счете для блокировки");
		}
	}


	@Override
	public void unblockAmount(int userId, double amount) {
		KapperInfo from = session.bySimpleNaturalId(KapperInfo.class).load(userId);
		double blockedTokens = from.getBlockedTokens();
		if (blockedTokens >= amount) {
			session.beginTransaction();
			from.setBlockedTokens(blockedTokens - amount);
			session.saveOrUpdate(from);
			session.getTransaction().commit();
		} else {
			throw new IllegalArgumentException("Недостаточно средств на счете для блокировки");
		}
	}

	@Override
	public Map<Users, Double> getBalance() {
		Map<Users, Double> map = new HashMap<>();
		Map<Users, KapperInfo> all = getAllInfo();
		for (Map.Entry<Users, KapperInfo> e : all.entrySet()) {
			map.put(e.getKey(), e.getValue().getTokens());
		}
		return map;
	}

	//TODO реализовать получение баланса одного каппера
	@Override
	public Map<Users, KapperInfo> getAllInfo() {
		Map<Users, KapperInfo> map = new HashMap<>();
		String hql = "FROM Users where role_id = '3'";
		Query query = session.createQuery(hql);
		List results = query.list();
		KapperInfo kapper;
		for (Object o : results) {
			hql = "FROM KapperInfo where u_id = " + ((Users) o).getUserId();
			query = session.createQuery(hql);
			List kaps = query.list();
			if (kaps.size() > 0) {
				kapper = (KapperInfo) kaps.get(0);
				map.put((Users) o, kapper);
			}
		}
		return map;
	}

	public void deleteKapper(int userId) {
		KapperInfo kapper = session.bySimpleNaturalId(KapperInfo.class).load(userId);
		if (kapper != null) {
			session.beginTransaction();
			session.delete(kapper);
			session.getTransaction().commit();
		}
	}

}
