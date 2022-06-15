package com.connectivity.Model.Dao.Markers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JoinField {
    Class<?> referencedClass();
    String columnName();
    OnDelete onDelete() default OnDelete.CASCADE;

    enum OnDelete{
        CASCADE, SETNULL, RESTRICT
    }
}
