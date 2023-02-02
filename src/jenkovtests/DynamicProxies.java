package jenkovtests;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxies {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                handler);

        System.out.println(proxy);
    }
}
