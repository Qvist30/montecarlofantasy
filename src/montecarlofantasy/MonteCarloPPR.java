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

public class MonteCarloPPR {

	static Map<String, Team> teams = new HashMap<String, Team>();

	public static void main(String[] args) {
		try {
			Path path = Paths.get("resources/ppr/currentstats");

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
			path = Paths.get("resources/ppr/gamesremaining");

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
		for(int i=5; i<12; i++) {
			if(teams.get(i).getProjectedPoints() > mostPoints) {
				mostPoints = teams.get(i).getProjectedPoints();
				index = i;
			}
		}
		Collections.swap(teams, 5, index);
//		for(Team team : teams) {
//			 System.out.println(team.getName() + " " +
//			 team.getTotalWins() + " " +
//			 team.getProjectedPoints());
//		}
		for (int i = 0; i < teams.size(); i++) {
			teams.get(i).addSeed(i + 1);
			teams.get(i).addWinsToMap();
			teams.get(i).addPoints();
//			 System.out.println((i+1) + ":" + teams.get(i).getName() + " " +
//			 teams.get(i).getTotalWins() + " " +
//			 teams.get(i).getProjectedPoints());

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

		}
	}
	// s

}
