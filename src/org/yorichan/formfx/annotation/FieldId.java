package org.yorichan.formfx.annotation;

import java.lang.annotation.*;

/**
 * Created by YoriChan on 2017/4/25
 * An annotation to map form fields to a class's properties
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldId {

    String value();

}
