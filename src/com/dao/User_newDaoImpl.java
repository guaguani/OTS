package com.dao;

import com.bean.AddressBean;
import com.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class User_newDaoImpl implements User_newDao {

    @Override
    public UserBean getUserInfo(String userid) {
        UserBean userBean = new UserBean();
        Connection conn = JdbcPool.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from user_new where id=" + userid;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                userBean.setId(userid);
                userBean.setName(rs.getString(2));
                userBean.setPwd(rs.getString(3));
                userBean.setPayID(rs.getString(9));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                rs.close();
                stmt.close();
                JdbcPool.getInstance().releaseConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userBean;
    }

    private ArrayList<String> stringTolist(String str){
        ArrayList<String> list = new ArrayList<String>();
        String [] token = str.split(",");

        for(int i = 0; i < token.length; i ++){
            list.add(token[i]);
        }

        return list;
    }

    @Override
    public void modUser(UserBean user) {
        Connection conn = JdbcPool.getInstance().getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "update user_new set name=?, pwd=?, payID=?" +
                         " where id = ?;";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2,user.getPwd());
            stmt.setString(3,user.getPayID());

            stmt.setString(4,user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                stmt.close();
                JdbcPool.getInstance().releaseConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String isUserExist(String userid) {
        String result = "FALSE";
        Connection conn = JdbcPool.getInstance().getConnection();
        PreparedStatement stmt = null;

        ResultSet rs = null;
        try {
            String sql = "select id from user_new where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,userid);
            rs = stmt.executeQuery();

            while (rs.next()) {
                result = "TRUE";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                rs.close();
                stmt.close();
                JdbcPool.getInstance().releaseConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void addUser(String id, String name, String ps) {
        PreparedStatement stmt = null;
        Connection conn = JdbcPool.getInstance().getConnection();
        try {

            String sql = "insert into user_new"
                    + "(id, name, pwd) "
                    + "values(?, ?, ?);";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1,id);
            stmt.setString(2,name);
            stmt.setString(3,ps);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                stmt.close();
                JdbcPool.getInstance().releaseConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String listToString(ArrayList<String> list){
        String str = "";

        for(int i = 0; i < list.size(); i ++){
            str += (list.get(i)+",");
        }
        str = str.substring(0,str.length() - 1);
        return str;
    }
}
