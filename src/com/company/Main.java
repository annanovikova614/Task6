package com.company;

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = readVariable("x");
        double n = readVariable("n");
        double e = readVariable("e");
        if(!verifyVariableX(x)) {
            return;
        }
        calc(x, (int)n, e);
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

    private static void printResult(double sum1, double sum2, int n2, double sum3, int n3, double res) {
        System.out.printf("1) %.3f\n", sum1);
        System.out.printf("2) %.3f - %d слагаемых\n", sum2, n2);
        System.out.printf("3) %.3f - %d слагаемых\n", sum3, n3);
        System.out.printf("4) %.3f\n", res);
    }

    public static void calc(double x, int n, double e) {
        double a = 1;
        double sum1 = 0, sum2 = 0, sum3 = 0;
        int n2 = 0, n3 = 0;
        for(int i = 1; i <= n || Math.abs(a) > e / 10; i++) {
            if(i <= n) {
                sum1 += a;
            }
            if(Math.abs(sum2 - (sum2 + a)) > e) {
                sum2 += a;
                n2++;
            }
            if(Math.abs(sum3 - (sum3 + a)) > e / 10) {
                sum3 += a;
                n3++;
            }
            a = - a * x * (i + 1) / i;
        }
        double res = calcRes(x);
        printResult(sum1, sum2, n2, sum3, n3, res);
    }

    private static double calcRes(double x) {
        return 1 / Math.pow(1 + x, 2);
    }
}
