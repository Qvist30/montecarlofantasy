package montecarlofantasy;

import java.util.Random;

public class OneMatchup {

	public static void main(String[] args) {
		double team1Average = 82.05165;
		double team1Stdev = 17.184;
		double team2Average =84.95385;
		double team2Stdev = 18.84454;
		int team1Wins = 0;
		int team2Wins = 0;
		double team1High = 0;
		double team2High = 0;
		double team1Low = Double.MAX_VALUE;
		double team2Low = Double.MAX_VALUE;
		Random random = new Random(System.currentTimeMillis());
		for(int i=0; i<10000;i++) {
			double team1Points = random.nextGaussian() * team1Stdev + team1Average;
			double team2Points = random.nextGaussian() * team2Stdev + team2Average;
			if(team1Points > team2Points) {
				team1Wins++;
			} else {
				team2Wins++;
			}
			if(team1Points > team1High) {
				team1High = team1Points;
			} if(team1Points < team1Low) {
				team1Low = team1Points;
			} if(team2Points > team2High) {
				team2High = team2Points;
			} if(team2Points < team2Low) {
				team2Low = team2Points;
			}
		}
		System.out.println("Team 1 Wins: " + team1Wins + " score range " + team1Low + " - " + team1High);
		System.out.println("Team 2 Wins: " + team2Wins + " score range " + team2Low + " - " + team2High);
		
	}
}
