package montecarlofantasy;

import java.util.Random;

public class Matchup {
	private static final Random RANDOM = new Random();

	private Team teamA;
	private Team teamB;
	public Matchup(Team teamA, Team teamB) {
		super();
		this.teamA = teamA;
		this.teamB = teamB;
	}
	public Team getTeamA() {
		return teamA;
	}
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	public Team getTeamB() {
		return teamB;
	}
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
	
	public double getTeamAPoints() {
		return (RANDOM.nextGaussian() * teamA.getStdev()) + teamA.getAveragePoints();
	}
	
	public double getTeamBPoints() {
		return (RANDOM.nextGaussian() * teamB.getStdev()) + teamB.getAveragePoints();
	}
	
}
