package montecarlofantasy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Team {
	String name;
	double numberOfWins;
	double averagePoints;
	double stdev;
	double projectedWins;
	double projectedPoints;
	int numberOfSemis = 0;
	int numberOfFinals = 0;
	int numberOfChampionships = 0;
	int numberOfFirstPicks = 0;


	Map<String, Integer> numberOfGamesPlayed = new HashMap<String, Integer>();
	Map<String, Integer> numberOfGamesWon = new HashMap<String, Integer>();
	Map<String, Integer> numberOfGamesRemaining = new HashMap<String, Integer>();
	
	Map<String, Integer> originalGamesPlayedMap = new HashMap<String, Integer>();
	Map<String, Integer> originalGamesWon = new HashMap<String, Integer>();
	Map<String, Integer> originalGamesRemaining = new HashMap<String, Integer>();

	
	Map<Integer, Integer> seedMap = new TreeMap<Integer, Integer>();
	Map<Integer, Integer> winMap = new TreeMap<Integer, Integer>();
	int totalNumberOfWinsThroughSimulation;
	int totalNumberOfPointsThroughSimulation;
	private int numberOfTimesOver1475;
	private int numberOfTimesOver1300;
	private int pointsTitle;
	private int totalNumberOfSeedsThroughSimulation;
	private int gamesRemaining;

	
	public Team(String name, double numberOfWins, double averagePoints, double stdev) {
		this.name = name;
		this.numberOfWins = numberOfWins;
		this.averagePoints = averagePoints;
		this.stdev = stdev;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNumberOfWins() {
		return numberOfWins;
	}

	public void setNumberOfWins(double numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

	public double getAveragePoints() {
		return averagePoints;
	}

	public void setAveragePoints(double averagePoints) {
		this.averagePoints = averagePoints;
	}

	public double getStdev() {
		return stdev;
	}

	public void setStdev(double stdev) {
		this.stdev = stdev;
	}
	
	public void addProjectedWin() {
		projectedWins++;
	}
	
	public void addProjectedPoints(double points) {
		projectedPoints+= points;
	}
	
	public double getProjectedPoints() {
		return projectedPoints + averagePoints*(13-gamesRemaining);
	}
	
	public int getGamesRemaining() {
		return gamesRemaining;
	}

	public void setGamesRemaining(int gamesRemaining) {
		this.gamesRemaining = gamesRemaining;
	}

	public double getTotalWins() {
		return projectedWins + numberOfWins;
	}
	
	public void clear() {
		projectedWins = 0;
		projectedPoints = 0;
	}

	public void addSeed(int i) {
		if(seedMap.containsKey(i)) {
			seedMap.replace(i, seedMap.get(i)+1);
		} else {
			seedMap.put(i, 1);
		}
		totalNumberOfSeedsThroughSimulation += i;
	}
	
	public Map<Integer, Integer> getSeedMap() {
		return seedMap;
	}

	public void addWinsToMap() {
		if(winMap.containsKey((int)getTotalWins())) {
			winMap.replace((int)getTotalWins(), winMap.get((int) getTotalWins())+1);
		} else {
			winMap.put((int)getTotalWins(), 1);
		}
		totalNumberOfWinsThroughSimulation+= getTotalWins();
	}
	
	public void addPoints() {
		totalNumberOfPointsThroughSimulation += getProjectedPoints();
		numberOfTimesOver1475 = getProjectedPoints() >=1571 ? numberOfTimesOver1475 +1 : numberOfTimesOver1475;
		numberOfTimesOver1300 = getProjectedPoints() >=1300 ? numberOfTimesOver1300 +1 : numberOfTimesOver1300;

	}

	public Map<Integer, Integer> getWinMap() {
		return winMap;
	}

	public void setWinMap(Map<Integer, Integer> winMap) {
		this.winMap = winMap;
	}

	public int getTotalNumberOfWinsThroughSimulation() {
		return totalNumberOfWinsThroughSimulation;
	}

	public void setTotalNumberOfWinsThroughSimulation(int totalNumberOfWinsThroughSimulation) {
		this.totalNumberOfWinsThroughSimulation = totalNumberOfWinsThroughSimulation;
	}

	public int getTotalNumberOfPointsThroughSimulation() {
		return totalNumberOfPointsThroughSimulation;
	}

	public void setTotalNumberOfPointsThroughSimulation(int totalNumberOfPointsThroughSimulation) {
		this.totalNumberOfPointsThroughSimulation = totalNumberOfPointsThroughSimulation;
	}

	public int getNumberOfTimesOver1475() {
		return numberOfTimesOver1475;
	}

	public void setNumberOfTimesOver1475(int numberOfTimesOver1475) {
		this.numberOfTimesOver1475 = numberOfTimesOver1475;
	}

	public int getNumberOfTimesOver1300() {
		return numberOfTimesOver1300;
	}

	public void setNumberOfTimesOver1300(int numberOfTimesOver1300) {
		this.numberOfTimesOver1300 = numberOfTimesOver1300;
	}
	
	public Map<String, Integer> getNumberOfGamesRemaining() {
		return numberOfGamesRemaining;
	}

	public void setNumberOfGamesRemaining(Map<String, Integer> numberOfGamesRemaining) {
		this.numberOfGamesRemaining = numberOfGamesRemaining;
	}

	public void addRemainingGames(String name, int remaining) {
		
		if(numberOfGamesRemaining.containsKey(name)) {
			numberOfGamesRemaining.put(name, numberOfGamesRemaining.get(name)+remaining);

		} else {
			numberOfGamesRemaining.put(name, remaining);
		}

	}
	
	public void addNumberOfGamesWon(String name, int remaining) {
		
		if(numberOfGamesWon.containsKey(name)) {
			numberOfGamesWon.put(name, numberOfGamesWon.get(name)+remaining);

		} else {
			numberOfGamesWon.put(name, remaining);
		}

	}
	
	public Map<String, Integer> getNumberOfGamesWon() {
		return numberOfGamesWon;
	}

	public void setNumberOfGamesWon(Map<String, Integer> numberOfGamesWon) {
		this.numberOfGamesWon = numberOfGamesWon;
	}

	public void addNumberOfGamesPlayed(String name, int remaining) {
		
		if(numberOfGamesPlayed.containsKey(name)) {
			numberOfGamesPlayed.put(name, numberOfGamesPlayed.get(name)+remaining);
		} else {
			numberOfGamesPlayed.put(name, remaining);
		}

	}

	public Map<String, Integer> getNumberOfGamesPlayed() {
		return numberOfGamesPlayed;
	}

	public void setNumberOfGamesPlayed(Map<String, Integer> numberOfGamesPlayed) {
		this.numberOfGamesPlayed = numberOfGamesPlayed;
	}

	public void initialize() {
//		clear();
		originalGamesPlayedMap = new HashMap<String, Integer>(numberOfGamesPlayed);
		originalGamesRemaining = new HashMap<String, Integer>(numberOfGamesRemaining);
		originalGamesPlayedMap = new HashMap<String, Integer>(numberOfGamesPlayed);
		for(int i : originalGamesRemaining.values()) {
			gamesRemaining += i;
		}
	}
	
	public void reset() {
		clear();
		numberOfGamesPlayed  = new HashMap<String, Integer>(originalGamesPlayedMap);
		numberOfGamesRemaining  = new HashMap<String, Integer>(originalGamesRemaining);
		numberOfGamesPlayed  = new HashMap<String, Integer>(originalGamesPlayedMap);
	}

	public void addSemiFinal() {
		numberOfSemis++;
	}

	public void addFinals() {
		numberOfFinals++;
		
	}
	
	public void addChampionship() {
		numberOfChampionships++;
		
	}

	public int getNumberOfSemis() {
		return numberOfSemis;
	}

	public void setNumberOfSemis(int numberOfSemis) {
		this.numberOfSemis = numberOfSemis;
	}

	public int getNumberOfFinals() {
		return numberOfFinals;
	}

	public void setNumberOfFinals(int numberOfFinals) {
		this.numberOfFinals = numberOfFinals;
	}

	public int getNumberOfChampionships() {
		return numberOfChampionships;
	}

	public void setNumberOfChampionships(int numberOfChampionships) {
		this.numberOfChampionships = numberOfChampionships;
	}

	public void addPointsTitle() {
		pointsTitle++;
		
	}

	public int getPointsTitle() {
		return pointsTitle;
	}

	public void setPointsTitle(int pointsTitle) {
		this.pointsTitle = pointsTitle;
	}

	public void add1stPick() {
		numberOfFirstPicks++;
	}

	public int getNumberOfFirstPicks() {
		return numberOfFirstPicks;
	}

	public void setNumberOfFirstPicks(int numberOfFirstPicks) {
		this.numberOfFirstPicks = numberOfFirstPicks;
	}

	public int getTotalNumberOfSeedsThroughSimulation() {
		return totalNumberOfSeedsThroughSimulation;
	}

	public void addProjectedTie() {
		projectedWins+= .5;
	}

}
