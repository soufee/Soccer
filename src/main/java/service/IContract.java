package service;

import model.BetEvent;
import model.EventResult;
import model.KapperInfo;
import model.dao.UsersEntity;

import java.util.Map;

/**
 * Created by Shoma on 29.09.2018.
 */
public interface IContract {
    KapperInfo initCapper(int userId);
    KapperInfo getKapperInfo(int userId);
    void transferTokens (int fromUserId, int toUserId, double amount);
    void blockTokens (int userId, double amount);
    Map<UsersEntity, Double> getBalance ();
    Map<UsersEntity, KapperInfo> getAllInfo();

}
