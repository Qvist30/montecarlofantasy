package montecarlofantasy;

import java.util.Random;

public class Matchup {
	private static final Random RANDOM = new Random();

	private Team teamA;
	private Team teamB;

	private double projectedAPoints;

	private double projectedBPoints;

	private double actualPointsA;

	private double actualPointsB;
	public Matchup(Team teamA, Team teamB) {
		super();
		this.teamA = teamA;
		this.teamB = teamB;
	}
	public Matchup(Team teamA, double projectedAPoints, double numberOfPlayersPlayedA, Team teamB, double projectedBPoints, double numberOfPlayersPlayedB) {
		super();
		this.teamA = teamA;
		this.teamB = teamB;
		this.projectedAPoints = projectedAPoints;
		this.projectedBPoints = projectedBPoints;
		this.actualPointsA = numberOfPlayersPlayedA;
		this.actualPointsB = numberOfPlayersPlayedB;
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
		double stDevMultiplier = 1;
		if(teamA.getGamesRemaining() > 1) {
			stDevMultiplier = teamA.getGamesRemaining();
		}
		if(projectedAPoints > 0) {
			return ((RANDOM.nextGaussian() * (teamA.getStdev()*stDevMultiplier)) +(projectedAPoints - actualPointsA))+ actualPointsA;
		}
		return (RANDOM.nextGaussian() * (teamA.getStdev()*stDevMultiplier)) + teamA.getAveragePoints();
	}
	
	public double getTeamBPoints() {
		double stDevMultiplier = 1;
		if(teamA.getGamesRemaining() > 1) {
			stDevMultiplier = teamA.getGamesRemaining();
		}
		if(projectedBPoints > 0) {
			return ((RANDOM.nextGaussian() * (teamB.getStdev()*stDevMultiplier)) +(projectedBPoints - actualPointsB))+ actualPointsB;

		}
		return (RANDOM.nextGaussian() * (teamB.getStdev()*stDevMultiplier)) + teamB.getAveragePoints();
	}
	
	public static void main(String[] args) {
		for(int i=0; i<100; i++) {
			double num = RANDOM.nextGaussian()*4.8+9.92;
			System.out.println(Math.exp(num));
		}
	}
}
