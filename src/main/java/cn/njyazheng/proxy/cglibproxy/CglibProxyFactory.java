package cn.njyazheng.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {
    //目标对象
    private Object target;
    
    public CglibProxyFactory(Object target) {
        this.target = target;
    }
    
    //给目标创建代理对象
    public Object getProxy() {
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调
        enhancer.setCallback(this);
        //创建子类
        return enhancer.create();
    }
    
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("*******************开启事务");
        Object returnvalue = method.invoke(target, objects);
        System.out.println("*******************提交事务");
        return returnvalue;
    }
}
