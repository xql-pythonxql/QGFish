package gdut.QG.QGFish.domain;

public class Message {

    private int id;
    private int from_uid;
    private int to_uid;
    private int good_id;
    private int count;
    private boolean status_f;   //买主状态
    private boolean status_t;   //卖主状态
    /*
        +----------+----------+-------------+
        | status_f | status_f | meanings    |
        +----------+----------+-------------+
        | true     | false    | 请求，未回应 |
        | true     | true     | 请求，通过   |
        | false    | false    | 请求，不通过 |
        +----------+----------+-------------+
     */

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from_uid=" + from_uid +
                ", to_uid=" + to_uid +
                ", good_id=" + good_id +
                ", count=" + count +
                ", status_f=" + status_f +
                ", status_t=" + status_t +
                '}';
    }

    public int getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(int from_uid) {
        this.from_uid = from_uid;
    }

    public int getTo_uid() {
        return to_uid;
    }

    public void setTo_uid(int to_uid) {
        this.to_uid = to_uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isStatus_f() {
        return status_f;
    }

    public void setStatus_f(boolean status_f) {
        this.status_f = status_f;
    }

    public boolean isStatus_t() {
        return status_t;
    }

    public void setStatus_t(boolean status_t) {
        this.status_t = status_t;
    }
}
