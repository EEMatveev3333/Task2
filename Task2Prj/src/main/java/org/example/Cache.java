package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.*;
import java.lang.annotation.*;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
}
