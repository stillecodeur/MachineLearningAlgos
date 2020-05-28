package statistics;

import java.util.Scanner;

public class ProbabilityDistributions {


    public static void main(String[] args) {
        binomialDistributionI();
        //binomialDistributionII();
        //geometricDistributionI();
        //geometricDistributionII();
    }

    private static void geometricDistributionI() {
        Scanner sc = new Scanner(System.in);
        double input[] = new double[2];

        for (int i = 0; i < 2; i++) {
            input[i] = sc.nextDouble();
        }

        int n = sc.nextInt();
        double probOfSuccess = input[0] / input[1];
        System.out.println(probOfSuccess);
        double probOfFailure = 1 - probOfSuccess;
        double prob = geometricProbability(5, probOfSuccess, probOfFailure);
        System.out.println(StatUtils.round(prob, 3));

    }

    private static void geometricDistributionII() {
        Scanner sc = new Scanner(System.in);
        double input[] = new double[2];

        for (int i = 0; i < 2; i++) {
            input[i] = sc.nextDouble();
        }

        int n = sc.nextInt();
        double probOfSuccess = input[0] / input[1];
        double probOfFailure = 1 - probOfSuccess;

        double prob = 0;
        for (int i = 1; i <= n; i++) {
            prob = prob + geometricProbability(i, probOfSuccess, probOfFailure);
        }

        System.out.println(StatUtils.round(prob, 3));

    }


    private static void binomialDistributionI() {
        Scanner sc = new Scanner(System.in);
        double[] ratioValues = new double[2];
        for (int i = 0; i < 2; i++) {
            ratioValues[i] = sc.nextDouble();
        }

        double totalOfRatioValues = ratioValues[0] + ratioValues[1];

        double probOfHavingBoy = ratioValues[0] / totalOfRatioValues;
        double probOfHavingGirl = ratioValues[1] / totalOfRatioValues;
        double probabilityOfHavingAtMostTwoBoys = binomialProbability(6, 0, 2, probOfHavingBoy, probOfHavingGirl);
        double probabilityOfHavingAtLeastThreeBoys = 1 - probabilityOfHavingAtMostTwoBoys;
        System.out.println(StatUtils.round(probabilityOfHavingAtLeastThreeBoys, 3));
    }

    private static void binomialDistributionII() {

        Scanner sc = new Scanner(System.in);
        int[] inputs = new int[2];
        for (int i = 0; i < 2; i++) {
            inputs[i] = sc.nextInt();
        }

        int defectPercentage = inputs[0];
        int numberOfPistons = inputs[1];


        double probOfSuccess = ((double) defectPercentage) / 100;
        double probOfFailure = 1 - probOfSuccess;

        double probabilityOfAtMost2Rejections = binomialProbability(numberOfPistons, 0, 2, probOfSuccess, probOfFailure);
        double probabilityOfAtLeast2Rejections = binomialProbability(numberOfPistons, 2, numberOfPistons, probOfSuccess, probOfFailure);

        System.out.println(StatUtils.round(probabilityOfAtMost2Rejections, 3));
        System.out.println(StatUtils.round(probabilityOfAtLeast2Rejections, 3));
    }


    private static double geometricProbability(int n, double pSuccess, double pFailure) {
        double probability = Math.pow(pSuccess, 1) * Math.pow(pFailure, n - 1);
        return probability;
    }

    private static double binomialProbability(int n, int lowerX, int higherX, double pSuccess, double pFailure) {
        double probability = 0;
        for (int i = lowerX; i <= higherX; i++) {
            probability = probability + combination(n, i) * Math.pow(pSuccess, i) * Math.pow(pFailure, n - i);
        }
        return probability;
    }

    private static double combination(int n, int x) {
        return factorial(n) / (factorial(n - x) * factorial(x));
    }

    private static int factorial(int n) {
        int factorial = 1;
        for (int i = n; i > 1; i--) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
