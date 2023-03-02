package org.m4bank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.LOCAL_VARIABLE })
public @interface NotNull {
}
