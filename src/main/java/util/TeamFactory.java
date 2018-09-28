package util;

import model.dao.TeamEntity;

/**
 * Created by Shoma on 28.09.2018.
 */
public class TeamFactory {
    public static TeamEntity getTeamInstance(String name, String city, String country, int leagueId){
        TeamEntity team = new TeamEntity();
        team.setName(name);
        team.setCity(city);
        team.setCountry(country);
        team.setLeagueId(leagueId);
        return team;
    }
}
