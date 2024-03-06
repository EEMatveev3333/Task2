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
        //System.out.println("Перевызов из под прокси!");

        //Здесь добавить анализ на маркировку методов анотациями,
        // если метод @Cache
        //                          - проверить текущее значение isChanged = false;
        //                          - Если isChanged = true перевызов оригинального метода, с сохранением результата tmp, установка isChanged = false
        //                          - Если isChanged = false, возврат результата из tmp
        // если метод @Mutable
        //                          - то после перевызова оригинального метода ставить isChanged = true;
        // если метод не @Cache и @Mutable
        //                          - то после перевызова оригинального метода

        //Object tmpObj;
        if (method.isAnnotationPresent(Cache.class))
        {
            System.out.println("Аннотация Cache");
            return method.invoke(this.uniObj, args);
        }
        else if (method.isAnnotationPresent(Mutator.class))
        {
            System.out.println("Аннотация Mutator");
            Object tmpObj = method.invoke(this.uniObj, args);
            isChanged = true;
            return tmpObj;
        }
        else
            return method.invoke(this.uniObj, args);
    }

}