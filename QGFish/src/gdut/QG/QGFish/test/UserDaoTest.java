package gdut.QG.QGFish.test;

import gdut.QG.QGFish.dao.UserDao;
import gdut.QG.QGFish.dao.impl.UserDaoImpl;
import gdut.QG.QGFish.domain.User;

import java.util.HashMap;
import java.util.Map;


public class UserDaoTest {

    public static void main(String[] args) {
        //login();
        //login();
        update();
    }

    private static void login() {
        UserDao dao = new UserDaoImpl();
        User user = dao.login("1111111", "zhangsan");
        System.out.println(user);
    }

    private static void register() {
        User user = new User();
        user.setUsername("zhaoliu");
        user.setPassword("zhaoliu");
        user.setEmail("zhaoliu@qq.com");
        String name = "" + System.currentTimeMillis();
        String icon = "img/defaultIcon.jpg";
        user.setName(name);
        user.setBalance(1000.00);
        UserDao userDao = new UserDaoImpl();
        boolean b = userDao.register(user);
        System.out.println(b);
    }

    private static void update() {
        UserDao dao = new UserDaoImpl();
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("id",new String[]{"4"});
        map.put("name",new String[]{"赵六"});
        map.put("email",new String[]{"zhaoliu@qq.com"});
        User user = dao.updateInfo(map);
        System.out.println(user);
    }
}
