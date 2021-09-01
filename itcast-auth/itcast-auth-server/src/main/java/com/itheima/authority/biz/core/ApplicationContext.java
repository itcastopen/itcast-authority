package com.itheima.authority.biz.core;

public class ApplicationContext {
    private static final ThreadLocal<Long> THREAD_LOCAL_APPLICATION_ID = new ThreadLocal();
    private static final ThreadLocal<Boolean> THREAD_LOCAL_APPLICATION_TYPE = new ThreadLocal();

    public static void put(Long applicationId) {
        THREAD_LOCAL_APPLICATION_ID.set(applicationId);
    }

    public static Long get() {
        return THREAD_LOCAL_APPLICATION_ID.get();
    }

    public static void setSystem(Boolean type) {
        THREAD_LOCAL_APPLICATION_TYPE.set(type);
    }

    public static Boolean isSystem() {
        return THREAD_LOCAL_APPLICATION_TYPE.get();
    }
}
