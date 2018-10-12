import lombok.extern.log4j.Log4j;
import model.dao.*;
import org.hibernate.Session;
import service.Contract;
import service.db.HibernateSessionFactory;

import java.util.Map;
import java.util.TreeSet;

@Log4j
public class Game {


	public static void main(String[] args) {
		TreeSet<KapperInfo> set = new TreeSet<>();
		try (Session session = HibernateSessionFactory.getSession()) {
			Contract contract = new Contract(session);
			Map<Users, KapperInfo> allInfo = contract.getAllInfo();
			for (Map.Entry<Users, KapperInfo> entity : allInfo.entrySet()) {
				set.add(entity.getValue());
			}
			for (KapperInfo i:set) {
				System.out.println(i.getUser().getName() + " "+i.getTokens());
			}
//            Users user =  Users.builder().roleId(Objects.requireNonNull(Roles.of(Roles.RoleTypes.KAPPER)).getRoleId())
//                    .userName("qqqqqqq")
//                    .email("q@q")
//                    .password("111111")
//                    .currency("RUB")
//                    .lang("RUSSIAN").name("Ereerere").build();
//
//            KapperInfo k = KapperInfo.builder().tokens(500d).bets(0).blockedTokens(0d).successBets(0).failBets(0).user(user).build();
//            PersonalInfo info = PersonalInfo.builder().photo("Пока так2").about("smth3").user(user).build();
//
//            Stat stat = Stat.builder().issueType(IssueType.LOSS).content("Сделана ставка и просрана").user(user).build();
//            History hist = History.builder().user(user).changes("Запись создана").build();
//            session.beginTransaction();
//            session.saveOrUpdate(k);
//            session.saveOrUpdate(info);
//            session.saveOrUpdate(stat);
//            session.saveOrUpdate(hist);
//            session.getTransaction().commit();
//            System.out.println("Все отработало");
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
       }
        finally{
				System.exit(0);
			}
		}
	}
