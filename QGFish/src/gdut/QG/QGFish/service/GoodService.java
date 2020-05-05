package gdut.QG.QGFish.service;

import gdut.QG.QGFish.domain.Good;
import gdut.QG.QGFish.domain.ResponseInfo;

import java.util.List;
import java.util.Map;

public interface GoodService {

    /**
     * 根据名称展示查询
     * @param name
     * @return 所查找的商品集合
     * @date 2020.5.1
     */
    public List<Good> findByName(String name);

    /**
     * 根据条件map集合查询
     * @param condition
     * @param who true 管理员，false 用户
     * @return
     */
    List<Good> findByConditionMap(Map<String, String[]> condition, boolean who);

    /**
     * 买，消费者买了多少的商品
     * @param buyerId
     * @param goodId
     * @param count
     */
    public ResponseInfo buy(int buyerId, int goodId, int count);

    /**
     * 通过用户id查询
     * @param user_id
     * @return
     */
    public ResponseInfo findByUserId(int user_id);

    /**
     * 添加一个商品信息
     * @param map
     * @return
     */
    public ResponseInfo addExceptImg(Map<String, String[]> map);

    /**
     * 根据id删除商品
     * @param id
     * @return
     */
    public ResponseInfo delById(int id);
}
