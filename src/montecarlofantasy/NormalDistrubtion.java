package montecarlofantasy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NormalDistrubtion {
	public static void main(String[] args) {
		Random random = new Random(System.currentTimeMillis());
		List<Double> doubles = new ArrayList<Double>(1000);
		double lowVelocity = Double.MAX_VALUE;
		double maxVelocity = Double.MIN_VALUE;
		for(int i=0; i<1000;i++) {
			double theta = 43 + random.nextDouble() * 4.0;
			if(theta < 43 || theta > 47) {
				System.out.println("ERROR!!!!!!");
			}
			double initialVelocity = 88 + random.nextGaussian() *10;
			if(initialVelocity < lowVelocity) {
				lowVelocity = initialVelocity;
			} if(initialVelocity > maxVelocity) {
				maxVelocity = initialVelocity;
			}
			double r = (initialVelocity*initialVelocity * Math.sin(Math.toRadians(2*theta)))/32.2;
			doubles.add(r);
		}
		Collections.sort(doubles);
		System.out.println("Min Velocity: " + lowVelocity);
		System.out.println("Max Velocity: " + maxVelocity);
		getMean(doubles);
		getMedian(doubles);
		get90thPercentile(doubles);
		
	}

	private static void get90thPercentile(List<Double> doubles) {
		int nintienthPercentile = doubles.size() /10 *9;
		System.out.println("90th percentile: " + doubles.get(nintienthPercentile));
	}

	private static void getMedian(List<Double> doubles) {
		int half = doubles.size() /2;

		System.out.println("Median: " + doubles.get(half));
	}

	private static void getMean(List<Double> doubles) {
		double sum = 0;
		for(double doub : doubles) {
			sum += doub;
		}
		System.out.println("Mean: " + sum/doubles.size());
	}
}
