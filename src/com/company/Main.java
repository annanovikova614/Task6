package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double x = readVariable(" значение (x)");
        double n = readVariable("колличество слагаемых (n)");
        double e = readVariable("эпсилон (e)");

        if(!verifyVariableX(x)) {
            return;
        }

        double function = calculateFunction(x);
        double sumOfNSlag = calculateSumOfNSlag(x, (int)n);
        Result resultEpsilon = calculateEpsilonSum(x, e);
        Result resultEpsilonSumOn10 = calculateEpsilonSumOn10(x, e);

        printResult(sumOfNSlag, resultEpsilon, resultEpsilonSumOn10, function);
    }

    private static double readVariable(String string) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите %s: ", string);
        return scanner.nextDouble();
    }

    private static boolean verifyVariableX(double x) {
        if(x < -1 || x > 1) {
            System.out.println("x не подходит, поскольку не принадлежит интервалу (-1;1)");
            return false;
        }
        return true;
    }

    private static void printResult(double sumOfNSlag, Result resultEpsilon, Result resultEpsilonSumOn10, double function) {
        System.out.printf("1) Значение функции равно %.5f\n", sumOfNSlag);
        System.out.printf("2) Значение функции при %d слагаемых равно %.5f\n", resultEpsilon.n, resultEpsilon.sum);
        System.out.printf("3) Значение функции при %d слагаемых равно %.5f\n", resultEpsilonSumOn10.n, resultEpsilonSumOn10.sum);
        System.out.printf("4) Значение функции 1/(1+x)^2 равно %.5f\n", function);
    }

    private static double calculateSumOfNSlag(double x, int n) {
        double slag = 1;
        double sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += slag;
            slag = - slag * x * (i + 1) / i;
        }
        return sum;
    }

    private static Result calculateEpsilonSum(double x, double e) {
        double slag = 1;
        double sum = 0;
        int n = 0;
        while(Math.abs(sum - (sum + slag)) > e) {
            sum += slag;
            n++;
            slag = - slag * x * (n + 1) / n;
        }
        return new Result(n, sum);
    }

    private static Result calculateEpsilonSumOn10(double x, double e) {
        double slag = 1;
        double sum = 0;
        int n = 0;
        while(Math.abs(sum - (sum + slag)) > e / 10) {
            sum += slag;
            n++;
            slag = - slag * x * (n + 1) / n;
        }
        return new Result(n, sum);
    }

    private static double calculateFunction(double x) {
        return 1 / Math.pow(1 + x, 2);
    }

    static class Result {
        public int n;
        public double sum;

        public Result(int n, double sum) {
            this.n = n;
            this.sum = sum;
        }
    }
}
