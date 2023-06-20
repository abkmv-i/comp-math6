package com.lab6spring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Form {
    private int method;
    private int numberOfFunction;
    private double a;
    private double b;
    private double h;
    private double y0;
    private double e;

    public Form(int method, int numberOfFunction, double a, double b, double h, double y0, double e) {
        this.method = method;
        this.numberOfFunction = numberOfFunction;
        this.a = a;
        this.b = b;
        this.h = h;
        this.y0 = y0;
        this.e = e;
    }
    public Form(){}
}
