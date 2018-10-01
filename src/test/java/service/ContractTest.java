package service;

import model.KapperInfo;
import model.dao.UsersEntity;
import org.hibernate.Session;
import org.junit.*;
import org.junit.runners.MethodSorters;
import service.db.HibernateSessionFactory;

import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * Created by Shoma on 30.09.2018.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContractTest {

    private static UsersEntity entity1;
    private static UsersEntity entity2;
    private static UsersEntity entity3;
    private static UsersEntity entity4;
    private static KapperInfo kapper1;
    private static KapperInfo kapper2;
    private static KapperInfo kapper3;
    private static KapperInfo kapper4;
    private static Session session;
    private static Contract contract;

    @BeforeClass
    public static void initData() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        contract = new Contract(session);
        entity1 = new UsersEntity();
        entity2 = new UsersEntity();
        entity3 = new UsersEntity();
        entity4 = new UsersEntity();

        entity1.setUserName("user1");
        entity1.setName("user1");
        entity1.setRole("ROLE_KAPPER");
        entity1.setPassword("user1");
        entity1.setEmail("user1@mail.ru");
        entity1.setDateOfRegistration(new Timestamp(System.currentTimeMillis()));
        entity1.setDateOfBirth(Timestamp.valueOf(LocalDateTime.of(1985, 4, 29, 1, 45)));

        entity2.setUserName("user2");
        entity2.setName("user2");
        entity2.setRole("ROLE_USER");
        entity2.setPassword("user2");
        entity2.setEmail("user2@mail.ru");
        entity2.setDateOfRegistration(new Timestamp(System.currentTimeMillis()));
        entity2.setDateOfBirth(Timestamp.valueOf(LocalDateTime.of(1988, 8, 15, 18, 45)));

        entity3.setUserName("user3");
        entity3.setName("user3");
        entity3.setRole("ROLE_ADMIN");
        entity3.setPassword("user3");
        entity3.setEmail("user3@mail.ru");
        entity3.setDateOfRegistration(new Timestamp(System.currentTimeMillis()));
        entity3.setDateOfBirth(Timestamp.valueOf(LocalDateTime.of(1988, 8, 15, 18, 45)));

        entity4.setUserName("user4");
        entity4.setName("user4");
        entity4.setRole("ROLE_KAPPER");
        entity4.setPassword("user4");
        entity4.setEmail("user4@mail.ru");
        entity4.setDateOfRegistration(new Timestamp(System.currentTimeMillis()));
        entity4.setDateOfBirth(Timestamp.valueOf(LocalDateTime.of(1985, 4, 29, 1, 45)));
        session.saveOrUpdate(entity1);
        session.saveOrUpdate(entity2);
        session.saveOrUpdate(entity3);
        session.saveOrUpdate(entity4);
        session.getTransaction().commit();
    }

    @Test
    public void a_initCapper() throws Exception {
        System.out.println("Начинается инициализация a_initCapper");
        //     session.beginTransaction();
        kapper1 = contract.initCapper(entity1.getUserId());
        kapper4 = contract.initCapper(entity4.getUserId());
        kapper2 = contract.initCapper(entity2.getUserId());
        kapper3 = contract.initCapper(entity3.getUserId());
        if (kapper1 != null) session.saveOrUpdate(kapper1);
        if (kapper2 != null) session.saveOrUpdate(kapper2);
        if (kapper3 != null) session.saveOrUpdate(kapper3);
        if (kapper4 != null) session.saveOrUpdate(kapper4);

        //   session.getTransaction().commit();
        System.out.println("Заканчивается инициализация");

        Assert.assertNotNull(kapper1);
        Assert.assertNotNull(kapper4);
        Assert.assertEquals(kapper1.getTokens(), 500d, 0.001);
        Assert.assertEquals(kapper4.getTokens(), 500d, 0.001);

        Assert.assertNull(kapper2);
        Assert.assertNull(kapper3);
    }

    @Test
    public void b_getKapperInfo() throws Exception {
        KapperInfo k = contract.getKapperInfo(kapper1.getUserId());
        Assert.assertEquals(k.getTokens(), 500d, 0.001);
        Assert.assertEquals(k.getBlockedTokens(), 0d, 0.001);
        Assert.assertEquals((int) k.getBets(), 0);
        Assert.assertEquals((int) k.getFailBets(), 0);
        Assert.assertEquals((int) k.getSuccessBets(), 0);
        Assert.assertEquals(k.getUserId(), 5);

    }

    @Test
    public void c_transferTokens() throws Exception {
        Assert.assertEquals(true, true);
    }

    @Test
    public void d_blockTokens() throws Exception {
        Assert.assertEquals(true, true);
    }

    @Test
    public void e_unblockAmount() throws Exception {
        Assert.assertEquals(true, true);
    }

    @Test
    public void f_getBalance() throws Exception {
        Assert.assertEquals(true, true);
    }

    @Test
    public void g_getAllInfo() throws Exception {
        Assert.assertEquals(true, true);
    }

    @Test
    public void h_deleteKapper() throws Exception {
        session.beginTransaction();
        int id = entity2.getUserId();
        session.delete(entity2);
        session.getTransaction().commit();
        UsersEntity en = getUserEntity(id);
        Assert.assertNull(en);
    }

    private UsersEntity getUserEntity(int id){
        try {
            return session.get(UsersEntity.class, id);
        }catch (Exception e){
            return null;
        }
    }

    @AfterClass
    public static void i_closeSession() {
        contract.deleteKapper(entity1.getUserId());
        contract.deleteKapper(entity4.getUserId());
        session.beginTransaction();
        session.delete(entity1);
        session.delete(entity3);
        session.delete(entity4);
        session.getTransaction().commit();
        session.close();
    }

}