package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
class MainTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Тест 1. Проверить запись в кэш корректного значения")
    void testUnCachedValue() {
        Fraction fr = new Fraction(2,3);
        System.out.println("===!");
        Fractionable num = Utils.cache(fr);


        assertNotEquals(String.valueOf(num.doubleValue()), String.valueOf(4.0/3.0));
        num.setNum(5);
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(5.0/3.0));
        assertNotEquals(String.valueOf(num.doubleValue()), String.valueOf(6.0/3.0));
        num.setDenum(15);
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        assertEquals(String.valueOf(Utils.referPersonInvocationHandler.ObjectsCache.get("doubleValue")), String.valueOf(5.0/15.0));
        System.out.println("===!");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Тест 2. Проверить чтение из кэша искуственно скорректированным кэшированное значением.")
    void testCrushedCachedValue() {
        Fraction fr = new Fraction(2,3);
        System.out.println("===!");
        Fractionable num = Utils.cache(fr);
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(2.0/3.0));
        //        Искуствено меняем содержимое кэша на другое число
        double test_val = 0.25;
        Utils.referPersonInvocationHandler.ObjectsCache.put("doubleValue",(Object)test_val);
        assertEquals(String.valueOf(num.doubleValue()), String.valueOf(test_val));

        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        num.setNum(5);
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout сработал
        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит

        System.out.println("            " + String.valueOf(num.doubleValue()));// sout молчит
        System.out.println("===!");
    }
}