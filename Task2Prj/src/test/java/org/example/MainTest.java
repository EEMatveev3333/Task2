package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
class MainTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест 1.1 . Проверить корректность значений")
    void testCorrectValue() {
        Fraction fr = new Fraction(2,3);
        System.out.println("===!");
        Fractionable num = Utils.cache(fr);
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(2.0/3.0));
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        num.setNum(5);
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(5.0/3.0));
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        System.out.println("===!");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест 1.2 . Проверить не корректность значений")
    void testUnCorrectValue() {
        Fraction fr = new Fraction(2,3);
        System.out.println("===!");
        Fractionable num = Utils.cache(fr);
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(3.0/3.0));
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        num.setNum(5);
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(7.0/3.0));
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        System.out.println("===!");
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Тест 2. Проверить своевременный пересчет значений")
    void testUnCachedValue() {
        Fraction fr = new Fraction(2,3);
        System.out.println("===!");
        Fractionable num = Utils.cache(fr);
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(2.0/3.0));
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(4.0/3.0));
        num.setNum(5);
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(5.0/3.0));
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(6.0/3.0));
        num.setDenum(15);
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(5.0/15.0));
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(5.0/16.0));
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(100.0/100.0));

        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        System.out.println("===!");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест 3. Проверить искуственно скорректированное кэшированное значение, на предмет чтения из кэша")
    void testCrushedCachedValue() {
        Fraction fr = new Fraction(2,3);
        System.out.println("===!");
        Fractionable num = Utils.cache(fr);
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
//        Искуствено меняем содержимое кэша на другое число
        PersonInvocationHandler CacheCrusher;// = (PersonInvocationHandler)num;

        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        num.setNum(5);
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит

        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        System.out.println("===!");
    }
}