package gdut.QG.QGFish.dao;

import gdut.QG.QGFish.domain.Good;

import java.util.List;
import java.util.Map;

public interface GoodDao {

    public List<Good> findByName(String name);

    public List<String> findImageByGoodIdFromTableGood_img(int good_id);

    public List<Good> findByConditionMap(Map<String, String[]> condition);

    public Good findById(int id);

    public List<Good> findByUserId(int user_id);

    public void addExceptImg(String name, double price, int count, String message, int user_id, int bought, boolean status_u, boolean status_m);

    public void delById(int id);

    public void updateByIdAfterBuy(int id, int count, int bought);

    public List<Good> findByNameAndOrder(String name, String order, String orderValue);

    //public Good findByAllExceptId();

}
