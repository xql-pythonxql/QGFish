package gdut.QG.QGFish.service.impl;

import gdut.QG.QGFish.dao.UserDao;
import gdut.QG.QGFish.dao.impl.UserDaoImpl;
import gdut.QG.QGFish.domain.User;
import gdut.QG.QGFish.service.UserService;

import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public boolean register(User user) {
        //查询是否存在
        User selectUser = userDao.selectByUsername(user.getUsername());
        if (selectUser == null) {
            return userDao.register(user);
        } else {
            return false;
        }
    }

    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public User updateInfo(Map<String, String[]> map) {
        return userDao.updateInfo(map);
    }


}
