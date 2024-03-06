package org.example;

//import java.util.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;
import java.lang.*;
//import java.util.Queue;
//import java.lang.reflect.InvocationTargetException;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args)  throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException  {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Fraction fr= new Fraction(2,3);
        //--- Тестовый пример
        FractionCache frC= new FractionCache(fr);

        Fractionable num1 = frC;
        System.out.println("===!");
        System.out.println("            " + String.valueOf(num1.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num1.doubleValue()));// sout молчит
        System.out.println("            " + String.valueOf(num1.doubleValue()));// sout молчит
        num1.setNum(5);
        System.out.println("            " + String.valueOf(num1.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num1.doubleValue()));// sout молчит
        //--- Тестовый пример
        //Class clazz = Fraction.class;
        //
        System.out.println("===!");
        Fractionable num = Utils.cache(fr);
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        num.setNum(5);
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        System.out.println("===!");


    }
}