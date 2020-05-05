package gdut.QG.QGFish.service.impl;

import gdut.QG.QGFish.dao.GoodDao;
import gdut.QG.QGFish.dao.MessageDao;
import gdut.QG.QGFish.dao.UserDao;
import gdut.QG.QGFish.dao.impl.GoodDaoImpl;
import gdut.QG.QGFish.dao.impl.MessageDaoImpl;
import gdut.QG.QGFish.dao.impl.UserDaoImpl;
import gdut.QG.QGFish.domain.Good;
import gdut.QG.QGFish.domain.Message;
import gdut.QG.QGFish.domain.ResponseInfo;
import gdut.QG.QGFish.domain.User;
import gdut.QG.QGFish.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    MessageDao messageDao = new MessageDaoImpl();
    UserDao userDao = new UserDaoImpl();
    GoodDao goodDao = new GoodDaoImpl();

    @Override
    public ResponseInfo selectByUserId(String user, int userId) {
        List<Message> messages = null;
        if ("from".equals(user)) {
             messages = messageDao.findByFromUserId(userId);
        } else if("to".equals(user)) {
            messages = messageDao.findByToUserId(userId);
        }
        ResponseInfo info = new ResponseInfo();
        info.setStatus(true);
        info.setMessage("Success");
        info.setData(messages);
        return info;
    }

    @Override
    public ResponseInfo buyResponse(int messageId, boolean flag) {

        ResponseInfo info = new ResponseInfo();

        Message message = messageDao.findById(messageId);
        int from_uid = message.getFrom_uid();
        int to_uid = message.getTo_uid();
        User buyer = userDao.selectById(from_uid);
        User seller = userDao.selectById(to_uid);
        Good good = goodDao.findById(message.getGood_id());
        //通过购买请求
        if (flag) {
            //交易
            userDao.deal(buyer, seller, good.getPrice() * message.getCount());
            goodDao.updateByIdAfterBuy(good.getId(),good.getCount()-message.getCount(),good.getBought()+message.getCount());
        }
        //设置卖主回应
        messageDao.updateStatusById(messageId,"status_t",flag);

        info.setStatus(true);
        info.setData("Success");
        info.setData(null);
        return info;
    }

    @Override
    public ResponseInfo sureGood(int id) {
        messageDao.delById(id);

        ResponseInfo info = new ResponseInfo();
        info.setStatus(true);
        info.setData("Success");
        info.setData(null);
        return info;
    }

    @Override
    public ResponseInfo cancelGood(int id) {
        messageDao.updateStatusById(id,"status_f",false);
        ResponseInfo info = new ResponseInfo();
        info.setStatus(true);
        info.setData("Success");
        info.setData(null);
        return info;
    }

}
