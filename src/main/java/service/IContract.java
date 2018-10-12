package service;

import model.dao.KapperInfo;
import model.dao.Users;

import java.util.Map;

/**
 * Created by Shoma on 29.09.2018.
 */
public interface IContract {
    KapperInfo initCapper(Users user);
    KapperInfo getKapperInfo(Users user);
    void blockTokens (Users user, double amount);
    Map<Users, Double> getBalance ();
    Map<Users, KapperInfo> getAllInfo();
    void unblockAmount (Users user, double amount);
}
