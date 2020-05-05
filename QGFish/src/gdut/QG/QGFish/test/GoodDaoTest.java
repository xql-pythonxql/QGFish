package gdut.QG.QGFish.test;

import gdut.QG.QGFish.dao.GoodDao;
import gdut.QG.QGFish.dao.impl.GoodDaoImpl;
import gdut.QG.QGFish.domain.Good;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodDaoTest {
    public static void main(String[] args) {
        //good_img();
        //findByName();
        //findByConditionMap();
    }

    private static void findByName() {
        GoodDao dao = new GoodDaoImpl();
        List<Good> goods = dao.findByName("可乐");
        System.out.println(goods);
        for (int i = 0; i < goods.size(); i++) {
            System.out.println(goods.get(i));
        }
    }

    private static void good_img() {
        GoodDao dao = new GoodDaoImpl();
        List<String> list = dao.findImageByGoodIdFromTableGood_img(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void findByConditionMap() {

        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("name",new String[]{""});
        map.put("order",new String[]{"price"});
        map.put("orderValue",new String[]{"asc"});
        GoodDao dao = new GoodDaoImpl();
        List<Good> list = dao.findByConditionMap(map);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
