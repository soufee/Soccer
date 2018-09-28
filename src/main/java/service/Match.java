package service;

import util.GameResults;

public interface Match {
	GameResults play(Team hostTeam, Team guestTeam);
}
