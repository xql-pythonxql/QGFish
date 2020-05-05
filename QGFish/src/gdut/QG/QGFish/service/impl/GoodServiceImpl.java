package gdut.QG.QGFish.service.impl;

import gdut.QG.QGFish.dao.GoodDao;
import gdut.QG.QGFish.dao.MessageDao;
import gdut.QG.QGFish.dao.UserDao;
import gdut.QG.QGFish.dao.impl.GoodDaoImpl;
import gdut.QG.QGFish.dao.impl.MessageDaoImpl;
import gdut.QG.QGFish.dao.impl.UserDaoImpl;
import gdut.QG.QGFish.domain.Good;
import gdut.QG.QGFish.domain.ResponseInfo;
import gdut.QG.QGFish.domain.User;
import gdut.QG.QGFish.service.GoodService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodServiceImpl implements GoodService {

    private GoodDao goodDao = new GoodDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private MessageDao messageDao = new MessageDaoImpl();

    @Override
    public List<Good> findByName(String name) {
        return goodDao.findByName(name);
    }

    @Override
    public List<Good> findByConditionMap(Map<String, String[]> condition, boolean who) {

        List<Good> list = new ArrayList<Good>();
        //管理员
        if (who) {
            String choose = condition.get("choose")[0];
            String name = condition.get("name")[0];
            if ("user".equals(choose)) {
                ArrayList<Integer> userIds = userDao.findByName(name);
                for (int userId : userIds) {
                    list.addAll(goodDao.findByUserId(userId));
                }
            } else if ("good".equals(choose)) {
                list = goodDao.findByName(name);
            }
        } else {    //用户
            String name = condition.get("name")[0];
            String order = condition.get("order")[0];
            String orderValue = condition.get("orderValue")[0];
            list = goodDao.findByNameAndOrder(name, order, orderValue);
        }
        return list;
    }

    @Override
    public ResponseInfo buy(int buyerId, int goodId, int count) {

        ResponseInfo info = new ResponseInfo();

        Good good = goodDao.findById(goodId);
        if (good.getCount() < count) {
            info.setStatus(false);
            info.setMessage("商品数量不足");
            info.setData(null);
            return info;
        }

        double money = good.getPrice() * count;

        User buyer = userDao.selectById(buyerId);
        if (buyer.getBalance() < money) {
            info.setStatus(false);
            info.setMessage("余额不足");
            info.setData(null);
            return info;
        }

        User seller = userDao.selectById(good.getUser_id());

        //设置购买信息，等待买主回应
        messageDao.setMessage(buyerId,seller.getId(),goodId,count,true,false);

        info.setStatus(true);
        info.setMessage("已给对方发送购买请求，请等待回应");
        info.setData(null);

        return info;

    }

    @Override
    public ResponseInfo findByUserId(int user_id) {
        List<Good> goods = goodDao.findByUserId(user_id);

        ResponseInfo info = new ResponseInfo();
        return null;
    }

    @Override
    public ResponseInfo addExceptImg(Map<String, String[]> map) {

        String name = map.get("name")[0];
        double price = Double.parseDouble(map.get("price")[0]);
        int count = Integer.parseInt(map.get("count")[0]);
        String message = map.get("message")[0];
        int user_id = Integer.parseInt(map.get("user_id")[0]);
        goodDao.addExceptImg(name,price,count,message,user_id,0,true,false);

        ResponseInfo info = new ResponseInfo();
        info.setStatus(true);
        info.setMessage("Success");
        info.setData(null);
        return info;
    }

    @Override
    public ResponseInfo delById(int id) {
        goodDao.delById(id);

        ResponseInfo info = new ResponseInfo();
        info.setStatus(true);
        info.setMessage("Success");
        info.setData(null);
        return info;
    }


}
