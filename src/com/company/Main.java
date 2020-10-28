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

    private static void printResult(double sum1, double sum2, double sum3, double res) {
        System.out.printf("1) %.3f\n", sum1);
        System.out.printf("2) %.3f\n", sum2);
        System.out.printf("3) %.3f\n", sum3);
        System.out.printf("4) %.3f\n", res);
    }

    public static void calc(double x, int n, double e) {
        double a = 1;
        double sum1 = 0, sum2 = 0, sum3 = 0;
        for(int i = 1; i <= n || Math.abs(a) > e / 10; i++) {
            if(i <= n) {
                sum1 += a;
            }
            if(Math.abs(a) > e) {
                sum2 += a;
            }
            if(Math.abs(a) > e / 10) {
                sum3 += a;
            }
            a = - a * x * (i + 1) / i;
        }
        double res = 1 / Math.pow(1 + x, 2);
        printResult(sum1, sum2, sum3, res);
    }
}
