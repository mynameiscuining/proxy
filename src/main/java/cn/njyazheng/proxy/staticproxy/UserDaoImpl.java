package cn.njyazheng.proxy.staticproxy;
/**
 * 静态代理在使用时,需要定义接口或者父类,
 * 被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
 */
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("--------------------保存数据");
    }
}
