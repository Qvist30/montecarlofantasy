package montecarlofantasy;

import java.util.Comparator;

public class PPRTeamComparator implements Comparator<Team> {

	@Override
	public int compare(Team teamA, Team teamB) {
		if (teamB.getTotalWins() > teamA.getTotalWins()) {
			return 1;
		} else if (teamA.getTotalWins() > teamB.getTotalWins()) {
			return -1;
		} else if(teamB.getProjectedPoints() > teamA.getProjectedPoints()){
			return 1;
		} else {
			return -1;
		}
	}

}
