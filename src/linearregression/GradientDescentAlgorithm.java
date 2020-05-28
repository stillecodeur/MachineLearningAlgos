package linearregression;

public class GradientDescentAlgorithm {


    public static void main(String[] args) {
        double x[] = {3, 5, 7, 5, 6, 7, 9, 4, 8, 6};
        double y[] = {6, 9, 12, 10, 14, 12, 14, 8, 15, 10};

        double minValue = 0.0000005, learningRate = 0.001;
        double[] regParams = computeRegressionParams(x, y, learningRate, minValue);
        System.out.println(regParams[0]);
        System.out.println(regParams[1]);
    }

    private static double[] computeRegressionParams(double x[], double y[], double learningRate, double minValue) {

        double tempTheta0 = 0, tempTheta1 = 0, theta0 = 0, theta1 = 0, theta0Factor = 0, theta1Factor = 0;

        do {
            theta0Factor = (learningRate * theta0(x, y, theta0, theta1));
            tempTheta0 = theta0 - theta0Factor;

            theta1Factor = (learningRate * theta1(x, y, theta0, theta1));
            tempTheta1 = theta1 - theta1Factor;

            theta0 = tempTheta0;
            theta1 = tempTheta1;

        } while (!(Math.abs(theta0Factor) <= minValue || Math.abs(theta1Factor) <= minValue));

        return new double[]{theta0, theta1};

    }

    private static double theta0(double xData[], double yData[], double theta0, double theta1) {
        double result = 0;
        for (int i = 0; i < xData.length; i++) {
            double x = xData[i];
            double targetY = yData[i];
            double predictedY = predictedY(x, theta0, theta1);
            result = result + (predictedY - targetY);
        }
        return result;
    }

    private static double theta1(double xData[], double yData[], double theta0, double theta1) {
        double result = 0;
        for (int i = 0; i < xData.length; i++) {
            double x = xData[i];
            double targetY = yData[i];
            double predictedY = predictedY(x, theta0, theta1);
            result = result + ((predictedY - targetY) * x);
        }
        return result;
    }

    private static double predictedY(double x, double theta0, double theta1) {
        return theta0 + (theta1 * x);
    }


}
