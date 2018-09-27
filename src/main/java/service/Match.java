package service;

import model.Team;
import util.GameResults;

public interface Match {
	GameResults play(Team hostTeam, Team guestTeam);
}
