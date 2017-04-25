package org.nantes.univ.archi.platform.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created on 25/04/17.
 */
public class LogHandler implements InvocationHandler{

    protected Object target;

    public LogHandler(Object o) {
        this.target = o;
    }

    public Object invoke (Object proxy, Method method, Object... args) throws InvocationTargetException, IllegalAccessException {
        System.out.println(method.getName() + " started");

        return method.invoke(target, args);
    }
}
