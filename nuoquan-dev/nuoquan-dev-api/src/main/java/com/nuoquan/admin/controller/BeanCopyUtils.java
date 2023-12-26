package com.nuoquan.admin.controller;

import static org.springframework.beans.BeanUtils.getPropertyDescriptor;
import static org.springframework.beans.BeanUtils.getPropertyDescriptors;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.google.common.collect.Lists;

/**
 * 解决bean copy 泛型问题
 */
public class BeanCopyUtils {
    public static <S, T> T map(S source, Class<T> clazz) {
        return map(source, clazz, x -> {
        });
    }

    public static <S, T> T map(S source, Class<T> clazz, Consumer<T> consumer) {
        T target = org.springframework.beans.BeanUtils.instantiateClass(clazz);
        copyProperties(source, target);
        consumer.accept(target);
        return target;
    }

    public static <E, T> List<T> map(Collection<E> collection, Class<T> clazz) {
        return mapBy(collection, x -> {
            return map(x, clazz);
        });
    }

    public static <T, R> List<R> mapBy(Collection<T> collection, Function<T, R> mapper) {
        return mapBy(collection, mapper, x -> {
        });
    }

    public static <T, R> List<R> mapBy(Collection<T> collection, Function<T, R> mapper, Consumer<R> action) {
        return (List) Optional.ofNullable(collection).map(x -> {
            return (List) x.stream().filter(Objects::nonNull).map(mapper).filter(Objects::nonNull).peek(action).collect(Collectors.toList());
        }).orElseGet(Lists::newArrayList);
    }

    public static <S, T> Optional<T> castIf(S source, Class<T> clazz) {
        Optional var10000 = Optional.ofNullable(source);
        clazz.getClass();
        var10000 = var10000.filter(clazz::isInstance);
        clazz.getClass();
        return var10000.map(clazz::cast);
    }

    public static <S, T, R> R mapIfPresent(S source, Class<T> clazz, Function<T, R> mapper) {
        return castIf(source, clazz).map(mapper).orElse(null);
    }

    public static <T, R> R mapIf(T t, Function<T, R> mapper, Supplier<R> other) {
        return Optional.ofNullable(t).map(mapper).orElseGet(other);
    }

    public static void copyProperties(Object source, Object target) throws BeansException {
        copyProperties(source, target, (Class) null, (String[]) null);
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        T t = null;
        if (source != null && targetClass != null) {
            try {
                t = targetClass.newInstance();
                copyProperties(source, t);
                return t;
            } catch (Exception var4) {
                throw new IllegalArgumentException("Create new instance of " + targetClass + " failed: " + var4.getMessage());
            }
        } else {
            return t;
        }
    }

    public static void copyProperties(Object source, Object target, @Nullable Class<?> editable, @Nullable String... ignoreProperties) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
            }

            actualEditable = editable;
        }

        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> ignoreList = ignoreProperties != null ? Arrays.asList(ignoreProperties) : null;
        PropertyDescriptor[] var7 = targetPds;
        int var8 = targetPds.length;

        for (int var9 = 0; var9 < var8; ++var9) {
            PropertyDescriptor targetPd = var7[var9];
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }

                            Object value = readMethod.invoke(source);
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }

                            writeMethod.invoke(target, value);
                        } catch (Throwable var18) {
                            throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", var18);
                        }
                    }
                }
            }
        }

    }

    public static String[] getValuePropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (null == srcValue) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
