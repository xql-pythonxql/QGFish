package gdut.QG.QGFish.util;

import gdut.QG.QGFish.dao.impl.GoodDaoImpl;
import gdut.QG.QGFish.domain.Good;
import gdut.QG.QGFish.domain.Manager;
import gdut.QG.QGFish.domain.Message;
import gdut.QG.QGFish.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
    各种对象的封装
 */
public class ObjectUtils {

    /**
     * 将resultSet里的一个user对象进行封装
     * @param resultSet
     * @return
     * @date 2020.5.1
     */
    public static User userEncapsulation(ResultSet resultSet) {
        try {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setIcon(resultSet.getString("icon"));
            user.setBalance(resultSet.getDouble("balance"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 注册时将Map里的一个user对象进行封装
     * @param map
     * @return 封装后的对象
     * @date 2020.5.1
     */
    public static User userEncapsulation(Map<String, String[]> map) {
        User user = new User();
        user.setUsername(map.get("username")[0]);
        user.setPassword(map.get("password")[0]);
        user.setEmail(map.get("email")[0]);

        String name = "" + System.currentTimeMillis();
        user.setName(name);
        String icon = "img/defaultIcon.jpg";
        user.setIcon(icon);
        user.setBalance(1000.00);

        return user;
    }

    /**
     * 将resultSet里的一个good对象进行封装
     * @param resultSet
     * @return good对象
     * @date 2020.5.1
     */
    public static Good goodEncapsulation(ResultSet resultSet) {
        try {
            Good good = new Good();
            int id = resultSet.getInt("id");
            good.setId(id);
            good.setName(resultSet.getString("name"));
            good.setPrice(resultSet.getDouble("price"));
            good.setCount(resultSet.getInt("count"));
            good.setMassage(resultSet.getString("message"));
            good.setBought(resultSet.getInt("bought"));
            good.setUser_id(resultSet.getInt("user_id"));
            good.setStatus_u(resultSet.getBoolean("status_u"));
            good.setStatus_m(resultSet.getBoolean("status_m"));
            List<String> list = new GoodDaoImpl().findImageByGoodIdFromTableGood_img(id);
            good.setImg(list);
            return good;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将resultSet里的多个good对象进行封装
     * @param resultSet
     * @return list
     */
    public static List<Good> goodsEncapsulation(ResultSet resultSet) {
        try {
            List<Good> list = new ArrayList<Good>();
            while (resultSet.next()) {
                Good good = new Good();
                int id = resultSet.getInt("id");
                good.setId(id);
                good.setName(resultSet.getString("name"));
                good.setPrice(resultSet.getDouble("price"));
                good.setCount(resultSet.getInt("count"));
                good.setMassage(resultSet.getString("message"));
                good.setBought(resultSet.getInt("bought"));
                good.setUser_id(resultSet.getInt("user_id"));
                good.setStatus_u(resultSet.getBoolean("status_u"));
                good.setStatus_m(resultSet.getBoolean("status_m"));
                List<String> img = new GoodDaoImpl().findImageByGoodIdFromTableGood_img(id);
                good.setImg(img);
                list.add(good);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对ResultSet里的多个good_img存储为List集合
     * @param rs
     * @return good_img的List集合
     * @date 2020.5.1
     */
    public static List<String> goodImgEncapsulation(ResultSet rs) {
        try {
            List<String> list = new ArrayList<String>();
            while (rs.next()) {
                list.add(rs.getString("path"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对ResultSet里的多个message进行封装为List集合
     * @param rs
     * @return message的List集合
     * @date 2020.5.3
     */
    public static List<Message> messagesEncapsulation(ResultSet rs) {
        try {
            List<Message> list = new ArrayList<Message>();
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setFrom_uid(rs.getInt("from_uid"));
                message.setTo_uid(rs.getInt("to_uid"));
                message.setGood_id(rs.getInt("good_id"));
                message.setCount(rs.getInt("count"));
                message.setStatus_f(rs.getBoolean("status_f"));
                message.setStatus_t(rs.getBoolean("status_t"));
                list.add(message);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对ResultSet里的一个message进行封装
     * @param rs
     * @return message
     * @date 2020.5.3
     */
    public static Message messageEncapsulation(ResultSet rs) {
        try {
            Message message = new Message();
            message.setId(rs.getInt("id"));
            message.setFrom_uid(rs.getInt("from_uid"));
            message.setTo_uid(rs.getInt("to_uid"));
            message.setGood_id(rs.getInt("good_id"));
            message.setCount(rs.getInt("count"));
            message.setStatus_f(rs.getBoolean("status_f"));
            message.setStatus_t(rs.getBoolean("status_t"));
            return message;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对ResultSet里的一个manager进行封装
     * @param rs
     * @return
     */
    public static Manager managerEncapsulation(ResultSet rs) {
        try {
            Manager manager = new Manager();
            manager.setId(rs.getInt("id"));
            manager.setUsername(rs.getString("username"));
            manager.setPassword(rs.getString("password"));
            manager.setName(rs.getString("name"));
            return manager;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 封装ResultSet里多个user对象的id
     * @param rs
     * @return
     */
    public static ArrayList<Integer> userIdsEncapsulation(ResultSet rs) {
        try {
            ArrayList<Integer> users = new ArrayList<Integer>();
            while (rs.next()) {
                users.add(rs.getInt("id"));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
