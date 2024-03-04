package org.example;

public class FractionCache implements Fractionable{
    private Fraction fraction;

    public FractionCache(Fraction fraction) {
        this.fraction = fraction;
    }

    public double doubleValue(){
        return fraction.doubleValue();
    };

    public void setNum(int num){
        fraction.setNum(num);
    };

    public void setDenum(int denum){
        fraction.setDenum(denum);
    };
}
