package gdut.QG.QGFish.dao.impl;

import gdut.QG.QGFish.dao.UserDao;
import gdut.QG.QGFish.domain.User;
import gdut.QG.QGFish.util.JDBCUtils;
import gdut.QG.QGFish.util.ObjectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/*
    user表的dao层接口实现类
 */
public class UserDaoImpl implements UserDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public User login(String username, String password) {

        try {
            String sql = "select * from user where username = ? and password = ?";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return ObjectUtils.userEncapsulation(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }

    }

    @Override
    public boolean register(User user) {

        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into user values(null,?,?,?,?,null,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getName());
            pstmt.setString(4,user.getEmail());
            pstmt.setDouble(5,user.getBalance());
            int i = pstmt.executeUpdate();
            if (i == 1) return true;
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtils.close(null,pstmt,conn);
        }
    }

    @Override
    public User selectByUsername(String username) {

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return ObjectUtils.userEncapsulation(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public User selectById(int id) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = ObjectUtils.userEncapsulation(rs);
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public User updateInfo(Map<String, String[]> map) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update user set name = ?, password = ?, email = ?, where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,map.get("name")[0]);
            pstmt.setString(2,map.get("password")[0]);
            pstmt.setString(3,map.get("email")[0]);
            pstmt.setInt(3,Integer.parseInt(map.get("id")[0]));
            int i = pstmt.executeUpdate();
            if (i == 1) {
                return selectById(Integer.parseInt(map.get("id")[0]));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public boolean deal(User buyer, User seller, double money) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update user set balance = ? where id = ?";
            //开启事务
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,buyer.getBalance() - money);
            pstmt.setInt(2,buyer.getId());
            int flag = pstmt.executeUpdate();

            if (flag != 1) {
                conn.rollback();//回滚
                return false;
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,seller.getBalance() + money);
            pstmt.setInt(2,seller.getId());
            flag = pstmt.executeUpdate();

            if (flag != 1) {
                conn.rollback();//回滚
                return false;
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public ArrayList<Integer> findByName(String name) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where name like ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+name+"%");
            rs = pstmt.executeQuery();
            return ObjectUtils.userIdsEncapsulation(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
