package com.lab6spring.Methods;

import com.lab6spring.Function;
import java.util.ArrayList;
import java.util.List;

public class RungeMethod{
    public static double[][] method(double a, double b, double y0, double h, int functionNumber, double e) {
        List<double[]> result = new ArrayList<>();
        double x = a;
        double y = y0;
        Function function = new Function();

        while (x <= b) {
            double[] row = {x, y, function.f(x, y, functionNumber), function.f1(x, y, functionNumber)};
            result.add(row);

            double k1 = h * function.f(x, y, functionNumber);
            double k2 = h * function.f(x + h / 2, y + k1 / 2, functionNumber);
            double k3 = h * function.f(x + h / 2, y + k2 / 2, functionNumber);
            double k4 = h * function.f(x + h, y + k3, functionNumber);

            y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            x = x + h;
        }

        return result.toArray(new double[0][]);
    }
}
