package service;

import model.dao.KapperInfo;
import model.dao.Users;

import java.util.Map;

/**
 * Created by Shoma on 29.09.2018.
 */
public interface IContract {
    KapperInfo initCapper(int userId);
    KapperInfo getKapperInfo(int userId);
    void blockTokens (int userId, double amount);
    Map<Users, Double> getBalance ();
    Map<Users, KapperInfo> getAllInfo();
    void unblockAmount (int userId, double amount);
}
