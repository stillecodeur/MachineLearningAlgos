package statistics;

import java.util.Scanner;

public class Quartiles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] X = new int[n];
        int[] F = new int[n];

        for (int i = 0; i < n; i++) {
            X[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            F[i] = scanner.nextInt();
        }

        int totalElements = 0;
        for (int i = 0; i < n; i++) {
            totalElements = totalElements + F[i];
        }

        int[] S = new int[totalElements];


        int currentSIndex = 0;
        for (int i = 0; i < n; i++) {
            int element = X[i];
            int frequency = F[i];
            for (int j = 0; j < frequency; j++) {
                S[currentSIndex] = element;
                currentSIndex++;
            }
        }

        StatUtils.sortArray(S);
        n = S.length;

        for (int i = 0; i < S.length; i++) {
            System.out.print(S[i]);
        }

        int lStart, uStart, lEnd, uEnd;
        if (StatUtils.isOdd(n)) {
            int mid = (int) Math.floor(n / 2);
            lStart = 0;
            lEnd = mid - 1;
            uStart = mid + 1;
            uEnd = n - 1;
        } else {
            int mid2 = n / 2;
            int mid1 = mid2 - 1;
            lStart = 0;
            lEnd = mid1;
            uStart = mid2;
            uEnd = n - 1;
        }


        double Q1 = StatUtils.median(S, lStart, lEnd);
        double Q2 = StatUtils.median(S, 0, n - 1);
        double Q3 = StatUtils.median(S, uStart, uEnd);
        System.out.println(Q1);
        System.out.println(Q3);

    }




}
