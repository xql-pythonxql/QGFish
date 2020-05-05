package gdut.QG.QGFish.dao;

import gdut.QG.QGFish.domain.Message;

import java.util.List;

public interface MessageDao {

    public List<Message> findByToUserId(int to_uid);

    public void setMessage(int from_uid, int to_uid, int good_id, int count, boolean status_f, boolean status_t);

    public Message findById(int id);

    public void updateStatusById(int id, String statusName, boolean status);

    public List<Message> findByFromUserId(int from_uid);

    public void delById(int id);

    //public Message findByAllExceptId(int from_uid, int to_uid, int good_id, int count, boolean status_f, boolean status_t);
}
