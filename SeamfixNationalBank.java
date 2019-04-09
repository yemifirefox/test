package log;

import java.util.Scanner;

public class SeamfixNationalBank {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter number of days and number of trailing days: ");
        int n = input.nextInt(); //the number of days of transaction data
        System.out.println("Please enter number of trailing days: ");
        int d = input.nextInt(); //the number of trailing days

        int[] expenditures = new int[n];
        for (int i = 0; i < expenditures.length; i++) {
            expenditures[i] = input.nextInt();
        }

        System.out.println(notification(expenditures, d));

        input.close();
    }

    static int notification(int[] expenditures, int d) {
        int[] counts = new int[201];
        for (int i = 0; i < d; i++) {
            counts[expenditures[i]]++;
        }

        int result = 0;
        for (int i = d; i < expenditures.length; i++) {
            int lower = 0;
            int leftNum = 0;
            while ((leftNum + counts[lower]) * 2 <= d) {
                leftNum += counts[lower];
                lower++;
            }

            int upper = counts.length - 1;
            int rightNum = 0;
            while ((rightNum + counts[upper]) * 2 <= d) {
                rightNum += counts[upper];
                upper--;
            }

            if (expenditures[i] >= lower + upper) {
                result++;
            }

            counts[expenditures[i - d]]--;
            counts[expenditures[i]]++;
        }
        return result;
    }
}

