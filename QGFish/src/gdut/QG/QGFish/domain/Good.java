package gdut.QG.QGFish.domain;

import java.util.List;

/*
    good的JavaBean
 */
public class Good {

    private int id;             //商品id
    private String name;        //商品的名称
    private double price;       //商品的价格
    private int count;          //商品的数目
    private String message;     //商品的描述
    private List<String> img;   //商品的图片展示
    private int bought;         //被购买的数量
    private int user_id;        //用户id
    private boolean status_u;   //用户状态
    private boolean status_m;   //管理员状态

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", message='" + message + '\'' +
                ", img=" + img +
                ", bought=" + bought +
                ", user_id=" + user_id +
                ", status_u=" + status_u +
                ", status_m=" + status_m +
                '}';
    }

    public String getImg0() {
        return img.get(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMassage() {
        return message;
    }

    public void setMassage(String massage) {
        this.message = massage;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
    }


    public int getBought() {
        return bought;
    }

    public void setBought(int bought) {
        this.bought = bought;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isStatus_u() {
        return status_u;
    }

    public void setStatus_u(boolean status_u) {
        this.status_u = status_u;
    }

    public boolean isStatus_m() {
        return status_m;
    }

    public void setStatus_m(boolean status_m) {
        this.status_m = status_m;
    }
}
