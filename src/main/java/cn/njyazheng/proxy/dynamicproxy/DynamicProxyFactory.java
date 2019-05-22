package cn.njyazheng.proxy.dynamicproxy;

import cn.njyazheng.proxy.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyFactory {
    private UserDao userDao;
    
    public DynamicProxyFactory(UserDao userDao) {
        this.userDao = userDao;
    }
    
    Object getProxy() {
        return Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("++++++++++++++++++++开启事务");
                //执行目标方法从,并返回值
                Object returnvalue = method.invoke(userDao, args);
                System.out.println("++++++++++++++++++++关闭事务");
                return returnvalue;
            }
        });
    }
}
