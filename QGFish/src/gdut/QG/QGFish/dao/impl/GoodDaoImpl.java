package gdut.QG.QGFish.dao.impl;

import gdut.QG.QGFish.dao.GoodDao;
import gdut.QG.QGFish.domain.Good;
import gdut.QG.QGFish.util.JDBCUtils;
import gdut.QG.QGFish.util.ObjectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/*
    good表的dao层接口实现类
 */
public class GoodDaoImpl implements GoodDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public List<Good> findByName(String name) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from good where name like ?";
            pstmt = conn.prepareStatement(sql);
            String s = "%"+name+"%";
            pstmt.setString(1,s);//自动添加单引号
            rs = pstmt.executeQuery();
            return ObjectUtils.goodsEncapsulation(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public List<String> findImageByGoodIdFromTableGood_img(int good_id) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from good_img where good_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,good_id);
            rs = pstmt.executeQuery();
            return ObjectUtils.goodImgEncapsulation(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public List<Good> findByConditionMap(Map<String, String[]> condition) {

        String name = condition.get("name")[0];
        String order = condition.get("order")[0];
        String orderValue = condition.get("orderValue")[0];
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from good where name like ? order by " + order + " " + orderValue;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+name+"%");
            rs = pstmt.executeQuery();
            return ObjectUtils.goodsEncapsulation(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public Good findById(int id) {

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from good where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            Good good = ObjectUtils.goodEncapsulation(rs);
            return good;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public List<Good> findByUserId(int user_id) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from good where user_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            rs = pstmt.executeQuery();
            return ObjectUtils.goodsEncapsulation(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addExceptImg(String name, double price, int count, String message, int user_id, int bought, boolean status_u, boolean status_m) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into good values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setDouble(2,price);
            pstmt.setInt(3,count);
            pstmt.setString(4,message);
            pstmt.setInt(5,user_id);
            pstmt.setInt(6,bought);
            pstmt.setBoolean(7,status_u);
            pstmt.setBoolean(8,status_m);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delById(int id) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from good where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByIdAfterBuy(int id, int count, int bought) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update good set count = ?, bought = ? where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,count);
            pstmt.setInt(2,bought);
            pstmt.setInt(3,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Good> findByNameAndOrder(String name, String order, String orderValue) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from good where name like ? order by " + order + " " + orderValue;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+name+"%");
            rs = pstmt.executeQuery();
            return ObjectUtils.goodsEncapsulation(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }
}
