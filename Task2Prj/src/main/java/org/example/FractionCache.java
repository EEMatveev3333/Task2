package org.example;

public class FractionCache implements Fractionable{
    private Fraction fraction;

    boolean isChanged;

    double tmp;

    public FractionCache(Fraction fraction) {
        this.fraction = fraction;
    }

    public double doubleValue(){
        if (isChanged) tmp = fraction.doubleValue();
        return tmp;
    };

    public void setNum(int num){
        fraction.setNum(num);
        isChanged = true;
    };

    public void setDenum(int denum){
        fraction.setDenum(denum);
        isChanged = true;
    };
}
