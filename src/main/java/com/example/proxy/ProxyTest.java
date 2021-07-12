package com.example.proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class ProxyTest {

    private Object target;

    public ProxyTest(Object testImpl) {
        target = testImpl;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("proxy start");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("proxy end");
                        return returnValue;
                    }
                }
        );
    }
}
