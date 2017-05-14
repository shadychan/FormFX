package org.yorichan.formfx.utils;

import org.yorichan.formfx.annotation.FieldId;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YoriChan on 2017/5/4
 * Some utils
 */
public class ReflectUtil {

    /**
     * 获取实体类属性和表单id的映射
     * @param clazz
     * @return
     */
    public static Map<String, Field> getFieldMap(Class clazz) {
        Map<String, Field> map = new HashMap<>();
        for (Field f : clazz.getDeclaredFields()) {
            FieldId fieldId = f.getAnnotation(FieldId.class);
            if (fieldId != null)
                map.put(fieldId.value(), f);
            else
                map.put("#" + f.getName(), f);
        }
        return map;
    }

    /**
     * 获取一个类的某个属性
     * @param clazz 属性所在类
     */
    public static Field getField(Class clazz, String fieldName) {
        Field field = null;
        for (Field f : clazz.getDeclaredFields()) {
            if (f.getName().equals(fieldName)) {
                field = f;
                break;
            }
        }
        return field;
    }

    /**
     * 为某个对象的属性设置值
     * @param valMap 表单值映射表
     * @param obj 对象
     */
    public static void setValueFromValMap(Map<String, Object> valMap, Object obj) {
        Class clazz = obj.getClass();
        Map<String, Field> fieldIdMap = ReflectUtil.getFieldMap(clazz);
        for (Map.Entry<String, Field> entry : fieldIdMap.entrySet()) {
            try {
                PropertyDescriptor pd = new PropertyDescriptor(entry.getValue().getName(), clazz);
                Method setter = pd.getWriteMethod();
                setter.invoke(obj, valMap.get(entry.getKey()));
            } catch (IllegalAccessException | InvocationTargetException | IntrospectionException e1) {
                // e1.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

}
