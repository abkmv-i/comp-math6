package com.lab6spring;

public class Function {

    public double f(double x, double y, int functionNumber) {
        switch (functionNumber) {
            case 1:
                return Math.exp(x) + 2 * y;
              //  return Math.pow(x, 3) - Math.pow(y, 2); // Пример функции номер 1: f(x, y) = x^2 + y^2
            case 2:
                return Math.sin(x) + Math.cos(y); // Пример функции номер 2: f(x, y) = sin(x) + cos(y)
            case 3:
                return Math.pow(x, 2) + 2 * y + Math.exp(x); // Пример функции номер 2: f(x, y) = x^2 + 2y + e^x
            default:
                return 0.0; // Функция по умолчанию (если functionNumber не соответствует ни одной функции)
        }
    }

    public double f1(double x, double y, int functionNumber) {
        switch (functionNumber) {
            case 1:
                return Math.exp(x);

            //return 3 * Math.pow(x, 2);
            //return 2 * x + 2 * y; // Пример функции номер 1: f1(x, y) = 2x + 2y
            case 2:
                return Math.cos(x) - Math.sin(y); // Пример функции номер 2: f1(x, y) = cos(x) - sin(y)
            case 3:
                return 2 + Math.exp(x); // Пример функции номер 2: f1(x, y) = 2 + e^x
            default:
                return 0.0; // Функция по умолчанию (если functionNumber не соответствует ни одной функции)
        }
    }

    public boolean compareColumn(double[][] array1, double[][] array2, double e, int p) {
        if (array1 == null || array2 == null) {
            return false;
        }

        for (int i = 0; i < array2.length; i++) {
            if (array1.length - 1 < i) {
                break;
            }
            if (Math.abs((array1[i][1] - array2[i][1])) / (Math.pow(2, p) - 1) >= e) {
                return false; // Значения в указанном столбце не совпадают
            }
        }

        return true; // Значения в указанном столбце совпадают в обоих массивах
    }

}
