package gdut.QG.QGFish.dao.impl;

import gdut.QG.QGFish.dao.MessageDao;
import gdut.QG.QGFish.domain.Message;
import gdut.QG.QGFish.util.JDBCUtils;
import gdut.QG.QGFish.util.ObjectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public List<Message> findByToUserId(int to_uid) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from buymessage where to_uid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,to_uid);
            rs = pstmt.executeQuery();
            return ObjectUtils.messagesEncapsulation(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public void setMessage(int from_uid, int to_uid, int good_id, int count, boolean status_f, boolean status_t) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into buymessage values(?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, from_uid);
            pstmt.setInt(2, to_uid);
            pstmt.setInt(3, good_id);
            pstmt.setInt(4, count);
            pstmt.setBoolean(5,status_f);
            pstmt.setBoolean(6,status_t);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public Message findById(int id) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from buymessage where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            Message message = ObjectUtils.messageEncapsulation(rs);
            return message;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public void updateStatusById(int id, String statusName, boolean status) {
        try {
            conn = JDBCUtils.getConnection();

            String sql = null;
            if ("status_f".equals(statusName)) {
                sql = "update buymessage set Status_f = ? where id = ?";
            } else if ("status_t".equals(statusName)) {
                sql = "update buymessage set Status_t = ? where id = ?";
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1,status);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public List<Message> findByFromUserId(int from_uid) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from buymessage where from_uid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,from_uid);
            rs = pstmt.executeQuery();
            return ObjectUtils.messagesEncapsulation(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }

    @Override
    public void delById(int id) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from message where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
