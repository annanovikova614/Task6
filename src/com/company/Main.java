package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = readVariable("x");
        double n = readVariable("n");
        double e = readVariable("e");
        double res = calculateRes(x);
        double result[] = calculateSum(x, (int) n, e);

        if(!verifyVariableX(x)) {
            return;
        }

        printResult(x, n, e, res);
    }

    private static double readVariable(String string) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите %s: ", string);
        return scanner.nextDouble();
    }

    private static boolean verifyVariableX(double x) {
        if(x < -1 || x > 1) {
            System.out.println("x не подходит");
            return false;
        }
        return true;
    }

    private static void printResult(double x, double n, double e, double res) {
        double result[] = calculateSum(x, (int) n, e);
        System.out.printf("1) Значение функции равно %.5f", result[0]);
        System.out.println();
        System.out.printf("2) Значение функции при %.0f слагаемых равно %.5f", result[2], result[1]);
        System.out.println();
        System.out.printf("3) Значение функции при %.0f слагаемых равно %.5f", result[4], result[3]);
        System.out.println();
        System.out.printf("4) Значение функции 1/(1+x)^2 равно %.5f", res);
    }

    private static double[] calculateSum(double x, int n, double e) {
        double R = 1;
        double sum_n = 0, sum_e = 0, sum_e_10 = 0;
        int n2 = 0, n3 = 0;
        for(int i = 1; i <= n || Math.abs(R) > e / 10; i++) {
            if(i <= n) {
                sum_n += R;
            }
            if(Math.abs(sum_e - (sum_e + R)) > e) {
                sum_e += R;
                n2++;
            }
            if(Math.abs(sum_e_10 - (sum_e_10 + R)) > e / 10) {
                sum_e_10 += R;
                n3++;
            }
            R = - R * x * (i + 1) / i;
        }
        return new double[] {sum_n, sum_e, n2, sum_e_10, n3};
    }

    private static double calculateRes(double x) {
        return 1 / Math.pow(1 + x, 2);
    }
}
