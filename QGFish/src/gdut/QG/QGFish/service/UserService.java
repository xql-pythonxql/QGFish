package gdut.QG.QGFish.service;

import gdut.QG.QGFish.domain.ResponseInfo;
import gdut.QG.QGFish.domain.User;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.Map;

/*
    用户管理的业务接口
 */
public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     * @date 2020.5.1
     */
    public User login(String username, String password);

    /**
     * 注册
     * @return
     * @date 2020.5.1
     */
    public boolean register(User user);

    /**
     * 通过id查找user对象
     * @return user对象
     * @date 2020.5.1
     */
    public User selectById(int id);

    /**
     * 更新用户的信息
     * @param map
     * @return 更新后的user
     * @date 2020.5.2
     */
    public User updateInfo(Map<String, String[]> map);

}
