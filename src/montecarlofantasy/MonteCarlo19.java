package montecarlofantasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MonteCarlo19 {

	static Map<String, Team> teams = new HashMap<String, Team>();

	public static void main(String[] args) {
		try {
			Path path = Paths.get("resources/currentstats");

			Reader source = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			BufferedReader reader = new BufferedReader(source);
			String string;
			// skip line.
			reader.readLine();
			while ((string = reader.readLine()) != null) {
				String[] str = string.split("\t");
				Team team = new Team(str[0], Double.valueOf(str[1]), Double.valueOf(str[2]), Double.valueOf(str[3]));
				teams.put(str[0], team);
			}
			path = Paths.get("resources/gamesremaining");

			source = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			reader = new BufferedReader(source);
			String[] headers = reader.readLine().split("\t");
			while ((string = reader.readLine()) != null) {
				String[] remaining = string.split("\t");
				Team team = teams.get(remaining[0]);
				for (int i = 1; i < headers.length; i++) {
					if (!remaining[i].equalsIgnoreCase("x")) {
						team.addRemainingGames(headers[i], Integer.valueOf(remaining[i]));
					}
				}
			}
			initializeTeams();
			for (int j = 0; j < 10000; j++) {
				resetTeams();
				for (Team team : teams.values()) {
					for (Map.Entry<String, Integer> gamesRemaining : team.getNumberOfGamesRemaining().entrySet()) {
						int remaining = gamesRemaining.getValue();
						Team opponent = teams.get(gamesRemaining.getKey());
						for (int i = 0; i < remaining; i++) {
							processMatchup(new Matchup(team, opponent));

						}
					}
//					System.out.println(team.getName() + " " + team.getTotalWins());
				}
				

				List<Team> teamList = new ArrayList<Team>(teams.values());
				processStandings(teamList);
			}
			processTeams(teams.values());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	private static void resetTeams() {
		for(Team team : teams.values()) {
			team.reset();
		}
	}

	private static void initializeTeams() {
		for(Team team : teams.values()) {
			team.initialize();
		}
	}

	private static void processMatchup(Matchup matchup) {
		double teamAPoints = matchup.getTeamAPoints();
		double teamBPoints = matchup.getTeamBPoints();
		Team teamA = matchup.getTeamA();
		Team teamB = matchup.getTeamB();

		// teamA.addProjectedPoints(teamAPoints);
		// teamB.addProjectedPoints(teamBPoints);
		// System.out.println(teamA.getName() + " " + teamAPoints + " " +
		// teamB.getName() + " " + teamBPoints);
		if (teamAPoints > teamBPoints) {
			teamA.addProjectedWin();
			teamA.addNumberOfGamesWon(matchup.getTeamB().getName(), 1);
		} else {
			teamB.addProjectedWin();
			teamB.addNumberOfGamesWon(matchup.getTeamA().getName(), 1);
		}
		teamA.addProjectedPoints(teamAPoints);
		teamB.addProjectedPoints(teamBPoints);

		teamA.addNumberOfGamesPlayed(matchup.getTeamB().getName(), 1);
		teamB.addNumberOfGamesPlayed(matchup.getTeamA().getName(), 1);
		teamA.addRemainingGames(matchup.getTeamB().getName(), -1);
		teamB.addRemainingGames(matchup.getTeamA().getName(), -1);
	}

	private static void processStandings(List<Team> teams) {
		Collections.sort(teams, new PPRTeamComparator());
		double mostPoints = 0;
		int index = 0;
//		for(Team team : teams) {
//			 System.out.println(team.getName() + " " +
//			 team.getTotalWins() + " " +
//			 team.getProjectedPoints());
//		}
//		for(int i=5; i<12; i++) {
//			if(teams.get(i).getProjectedPoints() > mostPoints) {
//				mostPoints = teams.get(i).getProjectedPoints();
//				index = i;
//			}
//		}
//		Collections.swap(teams, 5, index);
//		for(Team team : teams) {
//			 System.out.println(team.getName() + " " +
//			 team.getTotalWins() + " " +
//			 team.getProjectedPoints());
//		}
		int maxPointsTeam = 0;
		double maxPoints = 0;
		for (int i = 0; i < teams.size(); i++) {
			teams.get(i).addSeed(i + 1);
			teams.get(i).addWinsToMap();
			teams.get(i).addPoints();
			if(teams.get(i).getProjectedPoints() > maxPoints) {
				maxPoints = teams.get(i).getProjectedPoints();
				maxPointsTeam = i;
			}
//			 System.out.println((i+1) + ":" + teams.get(i).getName() + " " +
//			 teams.get(i).getTotalWins() + " " +
//			 teams.get(i).getProjectedPoints());
		}
		teams.get(maxPointsTeam).addPointsTitle();
		teams.get(0).addSemiFinal();
		teams.get(1).addSemiFinal();

		Team winner1 = processQuarter(new Matchup(teams.get(2), teams.get(5)), true);
		Team winner2 = processQuarter(new Matchup(teams.get(3), teams.get(4)), true);
		Team finalist1;
		Team finalist2;
		if(winner1 == teams.get(2)) {
			finalist1 = processSemi(new Matchup(winner1, teams.get(1)), true);
			finalist2 = processSemi(new Matchup(winner2, teams.get(0)), true);

		} else {
			finalist1 = processSemi(new Matchup(winner2, teams.get(1)), true);
			finalist2 = processSemi(new Matchup(winner1, teams.get(0)), true);
		}
		processFinal(new Matchup(finalist1, finalist2), true);
		
		
		// 
//		teams.get(6).addSemiFinal();
//		teams.get(7).addSemiFinal();

		Team winner3 = processQuarter(new Matchup(teams.get(8), teams.get(11)), false);
		Team winner4 = processQuarter(new Matchup(teams.get(9), teams.get(10)), false);
		Team finalist3;
		Team finalist4;
		if(winner3 == teams.get(8)) {
			finalist3 = processSemi(new Matchup(winner3, teams.get(7)), false);
			finalist4 = processSemi(new Matchup(winner4, teams.get(6)), false);

		} else {
			finalist3 = processSemi(new Matchup(winner4, teams.get(7)), false);
			finalist4 = processSemi(new Matchup(winner3, teams.get(6)), false);
		}
		processFinal(new Matchup(finalist3, finalist4), false);
	}
	
	private static void processFinal(Matchup matchup, boolean addChampionship) {
		double teamAPoints = matchup.getTeamAPoints();
		double teamBPoints = matchup.getTeamBPoints();
		Team teamA = matchup.getTeamA();
		Team teamB = matchup.getTeamB();

		// teamA.addProjectedPoints(teamAPoints);
		// teamB.addProjectedPoints(teamBPoints);
		// System.out.println(teamA.getName() + " " + teamAPoints + " " +
		// teamB.getName() + " " + teamBPoints);
		if (teamAPoints > teamBPoints) {
			if(addChampionship) {
				teamA.addChampionship();
			} else {
				teamA.add1stPick();
			}
//			teamA.addNumberOfGamesWon(matchup.getTeamB().getName(), 1);
		} else {
			if(addChampionship) {
				teamB.addChampionship();
			} else {
				teamB.add1stPick();
			}
		}
	}

	private static Team processSemi(Matchup matchup, boolean addFinal) {
		double teamAPoints = matchup.getTeamAPoints();
		double teamBPoints = matchup.getTeamBPoints();
		Team teamA = matchup.getTeamA();
		Team teamB = matchup.getTeamB();

		// teamA.addProjectedPoints(teamAPoints);
		// teamB.addProjectedPoints(teamBPoints);
		// System.out.println(teamA.getName() + " " + teamAPoints + " " +
		// teamB.getName() + " " + teamBPoints);
		if (teamAPoints > teamBPoints) {
			if(addFinal) {
				teamA.addFinals();
			}
//			teamA.addNumberOfGamesWon(matchup.getTeamB().getName(), 1);
			return teamA;
		} else {
			if(addFinal) {
				teamB.addFinals();
			}
			return teamB;
		}
	}

	private static Team processQuarter(Matchup matchup, boolean addSemifinal) {
		double teamAPoints = matchup.getTeamAPoints();
		double teamBPoints = matchup.getTeamBPoints();
		Team teamA = matchup.getTeamA();
		Team teamB = matchup.getTeamB();

		// teamA.addProjectedPoints(teamAPoints);
		// teamB.addProjectedPoints(teamBPoints);
		// System.out.println(teamA.getName() + " " + teamAPoints + " " +
		// teamB.getName() + " " + teamBPoints);
		if (teamAPoints > teamBPoints) {
			if(addSemifinal) {
				teamA.addSemiFinal();
			}
//			teamA.addNumberOfGamesWon(matchup.getTeamB().getName(), 1);
			return teamA;
		} else {
			if(addSemifinal) {
				teamB.addSemiFinal();
			}
			return teamB;
		}
	
	}

	private static void processTeams(Collection<Team> teams) {
		for (Team team : teams) {
			System.out.println(team.getName() + "\tWins\t" + team.getTotalNumberOfWinsThroughSimulation() / 10000.0
					+ "\tPoints\t" + team.getTotalNumberOfPointsThroughSimulation() / 10000.0);
			for (Map.Entry<Integer, Integer> entry : team.getSeedMap().entrySet()) {
				System.out.println("\tSeeds\t" + entry.getKey() + "\t" + entry.getValue());
			}
			for (Map.Entry<Integer, Integer> entry : team.getWinMap().entrySet()) {
				System.out.println("\tWins\t" + entry.getKey() + "\t" + entry.getValue());
			}
			System.out.println("\tOver 1300: " + team.getNumberOfTimesOver1300());
			System.out.println("\tOver 1475: " + team.getNumberOfTimesOver1475());
			System.out.println("\tNumber of Semifinals: " + team.getNumberOfSemis());
			System.out.println("\tNumber of Finals: " + team.getNumberOfFinals());
			System.out.println("\tNumber of Championships: " + team.getNumberOfChampionships());
			System.out.println("\tPoints Title: " + team.getPointsTitle());
			System.out.println("\tGot 1st Pick: " + team.getNumberOfFirstPicks());

		}
	}
	// s

}
