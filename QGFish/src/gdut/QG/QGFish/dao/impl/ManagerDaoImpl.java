package gdut.QG.QGFish.dao.impl;

import gdut.QG.QGFish.dao.ManagerDao;
import gdut.QG.QGFish.domain.Manager;
import gdut.QG.QGFish.util.JDBCUtils;
import gdut.QG.QGFish.util.ObjectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDaoImpl implements ManagerDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public Manager login(String username, String password) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from manager where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return ObjectUtils.managerEncapsulation(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
