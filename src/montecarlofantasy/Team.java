package montecarlofantasy;

import java.util.Map;
import java.util.TreeMap;

public class Team {
	String name;
	double numberOfWins;
	double averagePoints;
	double stdev;
	double projectedWins;
	double projectedPoints;
	
	Map<Integer, Integer> seedMap = new TreeMap<Integer, Integer>();
	Map<Integer, Integer> winMap = new TreeMap<Integer, Integer>();
	int totalNumberOfWinsThroughSimulation;
	int totalNumberOfPointsThroughSimulation;

	
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
		return projectedPoints + averagePoints * MonteCarloRun.NUMBER_OF_WEEKS_PLAYED;
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
	
}
