package gdut.QG.QGFish.dao;

import gdut.QG.QGFish.domain.User;

import java.util.ArrayList;
import java.util.Map;

public interface UserDao {

    public User login(String username, String password);

    public boolean register(User user);

    public User selectByUsername(String username);

    public User selectById(int id);

    public User updateInfo(Map<String, String[]> map);

    public boolean deal(User buyer, User seller, double money);

    public ArrayList<Integer> findByName(String name);
}
