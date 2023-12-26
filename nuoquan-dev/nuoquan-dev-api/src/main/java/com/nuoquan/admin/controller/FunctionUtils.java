package com.nuoquan.admin.controller;

import java.util.Arrays;
import java.util.function.Consumer;

public class FunctionUtils {

    public static <T> Consumer<T> doIf(final boolean condition, final Consumer<T> trueFunction, final Consumer<T> falseFunction) {
        return account -> {
            if (condition) {
                trueFunction.accept(account);
            } else {
                falseFunction.accept(account);
            }
        };
    }

    public static <T> Consumer<T> doIf(final boolean condition, final Consumer<T> trueFunction) {
        return doIf(condition, trueFunction, __ -> {
        });
    }

    public static void doIf(final boolean condition, Runnable task) {
        if (condition) {
            task.run();
        }
    }

    public static boolean isNull(Object... obj) {
        return Arrays.asList(obj).stream().allMatch(x -> x == null);
    }

    public static <T> T requireNonNullElse(T obj, T defaultObj) {
        return (obj != null) ? obj : requireNonNull(defaultObj, "defaultObj");
    }

    public static <T> T requireNonNull(T obj, String message) {
        if (obj == null)
            throw new NullPointerException(message);
        return obj;
    }
}
