package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Utils{

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

    static <T> T cache(T t) {
        //list.add(t);

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader UniClassLoader = t.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = t.getClass().getInterfaces();

        //Создаем прокси нашего объекта vasia
        T proxyObj = (T) Proxy.newProxyInstance(UniClassLoader, interfaces, new PersonInvocationHandler(t));

        //Вызываем у прокси объекта один из методов нашего оригинального объекта
        proxyObj.introduce(vasia.getName());

        return proxyObj;
    }

    //    static <T> void add(List<T> list, T t) {
//        list.add(t);
//    }
//    public T member1;
//    public class TestRunner {
//        public static void main(String[] args) throws InvocationTargetException, IllegalAccessException,
//                NoSuchMethodException, InstantiationException {
//            ClassTest classTest = new ClassTest();
//            Class clazz = classTest.getClass();
//            start(clazz);
//        }
//
//        public static void start(Class c) throws InvocationTargetException, IllegalAccessException,
//                NoSuchMethodException, InstantiationException {
//            Object o = c.getConstructor().newInstance();
//            Method[] methods = c.getDeclaredMethods();
//            //  Queue<Method> queue = new PriorityQueue<>();
//            for (Method m : methods){
//                Annotation[] annotations = m.getDeclaredAnnotations();
//                for (Annotation a : annotations){
//                    if (a.annotationType().equals(Test.class)){
//                        m.invoke(o);
//                    }
//                }
//            }
//        }
//    }



}
