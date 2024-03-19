package org.example;

import jdk.jfr.Description;

import java.lang.annotation.*;

import jdk.jfr.Description;
public class Fraction implements Fractionable{
    private int num;
    private int denum;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    @Mutator()
    public void setNum(int num) {
        this.num = num;
    }

    @Mutator()
    public void setDenum(int denum) {
        this.denum = denum;
    }

    @Override
    @Cache()
    public double doubleValue() {
        System.out.println("invoke double value");
        return (double) num/denum;
    }
}

