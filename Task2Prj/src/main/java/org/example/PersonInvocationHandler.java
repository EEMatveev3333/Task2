package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler<T>implements InvocationHandler {
    //private Person person;

    // Маркер изменений, устанавливается в true Mutable методами, сбрасывается в false Cache методами, по усолчанию для пересчета = true
    boolean isChanged = true;

    // Универсальный объект
    private T uniObj;

    // Конструктор
    public PersonInvocationHandler(T t) {
        this.uniObj = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Перевызов из под прокси!");
        return method.invoke(this.uniObj, args);
    }

}