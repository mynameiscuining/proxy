package cn.njyazheng.proxy.staticproxy;

import cn.njyazheng.proxy.UserDao;

/**
 * 静态代理在使用时,需要定义接口或者父类,
 * 被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
 */
public class UserDaoProxy implements UserDao {
    private UserDao userDao;
    public UserDaoProxy(){}
    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public void save() {
        System.out.println("--------------------开启事务");
        userDao.save();
        System.out.println("--------------------提交事务");
    }
}
