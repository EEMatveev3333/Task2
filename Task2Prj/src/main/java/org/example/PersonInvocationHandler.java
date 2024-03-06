package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.*;

public class PersonInvocationHandler<T>implements InvocationHandler {
    //private Person person;

    // Маркер изменений, устанавливается в true Mutable методами, сбрасывается в false Cache методами, по усолчанию для пересчета = true
    boolean isChanged = true;

    // Универсальный объект
    private T uniObj;

    //Objects tmp;
    HashMap<String, Object> ObjectsCache = new HashMap<>();

    // Конструктор
    public PersonInvocationHandler(T t) {
        this.uniObj = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("-----------------------");
//                System.out.println("Перевызов из под прокси! для метода " + method.getName() + " для класса ");// + uniObj.class.getName());
//        System.out.println(Arrays.toString(method.getDeclaredAnnotations()));
//        System.out.println(Arrays.toString(method.getAnnotations()));
//        System.out.println(Arrays.toString(method.getgetAnnotations());

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

/*        public double doubleValue(){
            if (isChanged) tmp = fraction.doubleValue();
            else
                System.out.println("tmp double value");
            isChanged = false;
            return tmp;
        };*/

        if (method.isAnnotationPresent(Cache.class))
        {
 //           System.out.println("Найдена аннотация Cache в методе " + method.getName());
            //passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
            if (isChanged) ObjectsCache.put(method.getName(), method.invoke(this.uniObj, args)); //tmp = method.invoke(this.uniObj, args);
            isChanged = false;
            return ObjectsCache.get(method.getName());
        }
        else if (method.isAnnotationPresent(Mutator.class))
        {
//            System.out.println("Найдена аннотация Mutator в методе " + method.getName());
            Object tmpObj = method.invoke(this.uniObj, args);
            isChanged = true;
            return tmpObj;
        }
        else {
//            System.out.println("Без аннотаций Cache и Mutator в методе " + method.getName());
            return method.invoke(this.uniObj, args);
        }
    }

}