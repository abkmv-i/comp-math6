package com.lab6spring.Methods;

import com.lab6spring.Function;

public class MilanaMethod {

    Function function = new Function();

    public double[][] method(double a, double b, double y0, double h, int functionNumber, double e) {
        Function function = new Function();
        int n = (int) ((b - a) / h) + 1;
        double[][] result = new double[n][4];
        result[0][0] = a;
        result[0][1] = y0;
        result[0][2] = function.f(result[0][0], result[0][1], functionNumber);
        result[0][3] = function.f1(result[0][0], result[0][1], functionNumber);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;

            double yEuler = result[i - 1][1] + h * function.f(x - h, result[i - 1][1], functionNumber);
            double fEuler = function.f(x, yEuler, functionNumber);
            double f1Euler = function.f1(x, yEuler, functionNumber);

            result[i][0] = x;
            result[i][1] = result[i - 1][1] + (h / 2) * (result[i - 1][3] + f1Euler);
            result[i][2] = function.f(x, result[i][1], functionNumber);
            result[i][3] = function.f1(x, result[i][1], functionNumber);

            while (Math.abs(result[i][2] - fEuler) / 3 >= e) {
                yEuler = result[i][1];
                fEuler = result[i][2];
                f1Euler = result[i][3];

                result[i][1] = result[i - 1][1] + (h / 2) * (result[i - 1][3] + f1Euler);
                result[i][2] = function.f(x, result[i][1], functionNumber);
                result[i][3] = function.f1(x, result[i][1], functionNumber);
            }
        }

        return result;

    }
}
