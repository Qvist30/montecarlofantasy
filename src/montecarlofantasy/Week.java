package montecarlofantasy;

import java.util.Arrays;
import java.util.List;

public class Week {
	private List<Matchup> matchups; 
	public Week(Matchup... matchup) {
		setMatchups(Arrays.asList(matchup));
	}
	public List<Matchup> getMatchups() {
		return matchups;
	}
	public void setMatchups(List<Matchup> matchups) {
		this.matchups = matchups;
	}

}
