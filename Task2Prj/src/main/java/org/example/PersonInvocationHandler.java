package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.*;

public class PersonInvocationHandler<T>implements InvocationHandler {

    boolean isChanged = true;
    private T uniObj;
   public HashMap<String, Object> ObjectsCache = new HashMap<>();
   public PersonInvocationHandler(T t) {
        this.uniObj = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

       Method tmpMethod = uniObj.getClass().getMethod(method.getName(),method.getParameterTypes());

        if (tmpMethod.isAnnotationPresent(Cache.class))
        {
            if (isChanged) ObjectsCache.put(method.getName(), method.invoke(this.uniObj, args)); //tmp = method.invoke(this.uniObj, args);
            isChanged = false;
            return ObjectsCache.get(method.getName());
        }
        else if (tmpMethod.isAnnotationPresent(Mutator.class))
        {
            Object tmpObj = method.invoke(this.uniObj, args);
            isChanged = true;
            return tmpObj;
        }
        else {
            return method.invoke(this.uniObj, args);
        }
    }

}