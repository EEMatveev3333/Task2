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

    public static <T> void start(Class<T> c) throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException {

//        Constructor<T> constructor = c.getDeclaredConstructor();
//        T o = constructor.newInstance();
        Method[] methods = c.getDeclaredMethods();

//        Queue<Method> queue1 = new PriorityQueue<>();
//                (m1, m2) -> Integer.compare(m2.getDeclaredAnnotation(Cache.class).value(),
//                        m1.getDeclaredAnnotation(Cache.class).value())
//        );
//        Queue<Method> queue2 = new PriorityQueue<>(
//                (m1, m2) -> Integer.compare(m2.getDeclaredAnnotation(Mutator.class).value(),
//                        m1.getDeclaredAnnotation(Mutator.class).value())
//        );
//        Queue<Method> queue3 = new PriorityQueue<>(
//                (m1, m2) -> Integer.compare(m2.getDeclaredAnnotation(AfterSuite.class).value(),
//                        m1.getDeclaredAnnotation(AfterSuite.class).value())
//        );

        for (Method method : methods) {
            //method
            System.out.println(method + " [Anotations:] " + method.getAnnotations());
            for (Annotation annotation : method.getAnnotations())
                System.out.println("            " + annotation.toString() );
            for (Annotation Declaredannotation : method.getDeclaredAnnotations())
                System.out.println("            " + Declaredannotation.toString() );

            Annotation[] annotations = method.getAnnotations();
            System.out.println(Arrays.toString(annotations));
            Annotation[] Declaredannotations = method.getDeclaredAnnotations();
            System.out.println(Arrays.toString(Declaredannotations));
//            if (method.getDeclaredAnnotation(Cache.class) != null) {
//                queue1.add(method);
//            }
//            else if (method.getDeclaredAnnotation(Mutator.class) != null) {
//                    queue1.add(method);
//            }
//                else if (method.getDeclaredAnnotation(AfterSuite.class) != null) {
//                    queue3.add(method);
//                }
//                else {
//                    queue2.add(method);
//                }
//            }
        }

//        Method m;
//        while ((m = queue1.poll()) != null) {
//            m.invoke(o);
//        }
//        while ((m = queue2.poll()) != null) {
//            m.invoke(o);
//        }
//        while ((m = queue3.poll()) != null) {
//            m.invoke(o);
//        }
    }

    public static void main(String[] args)  throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException  {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

//        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Shift+F9 to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Ctrl+F8.
//            System.out.println("i = " + i);
//        }

        Fraction fr= new Fraction(2,3);
        //--- Тестовый пример
        FractionCache frC= new FractionCache(fr);

        Fractionable num1 = frC;


        num1.doubleValue();// sout сработал
        num1.doubleValue();// sout молчит
        num1.doubleValue();// sout молчит
        num1.setNum(5);
        num1.doubleValue();// sout сработал
        num1.doubleValue();// sout молчит
        //--- Тестовый пример
        //Class clazz = Fraction.class;
        //

        Fractionable num = Utils.cache(fr);

        num.doubleValue();// sout сработал
        num.doubleValue();// sout молчит
        num.doubleValue();// sout молчит
        num.setNum(5);
        num.doubleValue();// sout сработал
        num.doubleValue();// sout молчит

        System.out.println("===!");
        System.out.println("===!");
        System.out.println("===!");

        start(Fraction.class);
        System.out.println("===!");
        //start(frC.getClass());
        //Class<? extends Car> carClass = car.getClass();

    }
}