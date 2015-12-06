package montecarlofantasy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MonteCarloRun {
	
	public static Team tom = new Team("Tom", 11.0, 118.16, 15.93);
	public static Team aaron = new Team("Aaron", 6.0, 93.05, 10.18);
	public static Team brad = new Team("Brad", 5.0, 87.51, 18.27);
	public static Team jeff = new Team("Jeff", 3.0, 68.45, 31.08);
	
	public static Team nick = new Team("Nick", 8.0, 93.28, 19.08);
	public static Team jackie = new Team("Jackie", 7.0, 91.7, 16.03);
	public static Team joe = new Team("Joe", 9.0, 97.13, 20.26);
	public static Team seth = new Team("Seth", 6.0, 101.41, 23.12);
	
	public static Team jason = new Team("Jason", 4.0, 90.09, 17.27);
	public static Team tyler = new Team("Tyler", 6.0, 92.86, 23.41);
	public static Team ross = new Team("Ross", 4.0, 85.87, 19.57);
	public static Team tony = new Team("Tony", 3.0, 86.16, 17.53);
	private static List<Team> teams = Arrays.asList(tom, aaron, brad, jeff, nick, jackie, joe, seth, jason, tyler, ross, tony);

	// Week 12 matchups
//	private static Matchup week12Matchup1 = new Matchup(tom, aaron);
//	private static Matchup week12Matchup2 = new Matchup(brad, jeff);
//	private static Matchup week12Matchup3 = new Matchup(jason, ross);
//	private static Matchup week12Matchup4 = new Matchup(seth, joe);
//	private static Matchup week12Matchup5 = new Matchup(jackie, tyler);
//	private static Matchup week12Matchup6 = new Matchup(tony, nick);
//	private static Week week12 = new Week(week12Matchup1, week12Matchup2, week12Matchup3, week12Matchup4, week12Matchup5, week12Matchup6);

	// WEEK 13 MATCHUPs
	private static Matchup week13Matchup1 = new Matchup(jeff, tom);
	private static Matchup week13Matchup2 = new Matchup(joe, jason);
	private static Matchup week13Matchup3 = new Matchup(nick, jackie);
	private static Matchup week13Matchup4 = new Matchup(ross, seth);
	private static Matchup week13Matchup5 = new Matchup(aaron, brad);
	private static Matchup week13Matchup6 = new Matchup(tyler, tony);	
	private static Week week13 = new Week(week13Matchup1, week13Matchup2, week13Matchup3, week13Matchup4, week13Matchup5, week13Matchup6);
	public static boolean billyOverAaron;
	public static final int NUMBER_OF_WEEKS_PLAYED = 12;

	public static void main(String args[]) {
		for(int i=0; i<10000; i++) {
			clear();
//			processWeek(week12);
			processWeek(week13);
			processStandings();
		}
		
		processTeams();
	}

	private static void processTeams() {
		for(Team team : teams) {
			System.out.println(team.getName() + "\tWins\t" + team.getTotalNumberOfWinsThroughSimulation() / 10000.0
					+ "\tPoints\t" + team.getTotalNumberOfPointsThroughSimulation() / 10000.0);
			for(Map.Entry<Integer, Integer> entry : team.getSeedMap().entrySet()) {
				System.out.println("\tSeeds\t" + entry.getKey() +"\t" +  entry.getValue());
			}
			for(Map.Entry<Integer, Integer> entry : team.getWinMap().entrySet()) {
				System.out.println("\tWins\t" + entry.getKey() +"\t" +  entry.getValue());
			}
		}
	}

	private static void processStandings() {
		Collections.sort(teams, new TeamComparator());
		for(int i=0; i<teams.size(); i++) {
			teams.get(i).addSeed(i+1);
			teams.get(i).addWinsToMap();
			teams.get(i).addPoints();
			System.out.println((i+1) + ":" + teams.get(i).getName() + " " + teams.get(i).getTotalWins() + " " + teams.get(i).getProjectedPoints());

		}
	}

	private static void processWeek(Week week) {
		for(Matchup matchup : week.getMatchups()) {
			processMatchup(matchup);
			if(matchup.getTeamA() == aaron) {
				if(matchup.getTeamAPoints() > matchup.getTeamBPoints()) {
					billyOverAaron = false;
				} else {
					billyOverAaron = true;
				}
			}
		}
	}

	private static void clear() {
		for(Team team : teams) {
			team.clear();
		}
	}

	private static void processMatchup(Matchup matchup) {
		double teamAPoints = matchup.getTeamAPoints();
		double teamBPoints = matchup.getTeamBPoints();
		Team teamA = matchup.getTeamA();
		Team teamB = matchup.getTeamB();

		teamA.addProjectedPoints(teamAPoints);
		teamB.addProjectedPoints(teamBPoints);
		if(teamAPoints > teamBPoints) {
			teamA.addProjectedWin();
		} else {
			teamB.addProjectedWin();
		}
	}
}
