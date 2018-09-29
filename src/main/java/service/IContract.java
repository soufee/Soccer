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
    KapperInfo initCapper(int user_id);
    void betReputation(BetEvent event, int tokens);
    KapperInfo getKapperInfo(int user_id);
    EventResult getBettingResult(BetEvent event);
    Map<UsersEntity, Double> getBalance ();
    Map<UsersEntity, KapperInfo> getRaiting();

}
