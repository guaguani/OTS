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
                userBean.setGender(rs.getString(4));

                String province = rs.getString(5);
                String city = rs.getString(6);
                String district = rs.getString(7);
                String detail = rs.getString(8);
                AddressBean addressBean = new AddressBean();
                addressBean.setProvince(province);
                addressBean.setCity(city);
                addressBean.setDistrict(district);
                addressBean.setDetail(detail);
                userBean.setAddress(addressBean);

                userBean.setPayID(rs.getString(9));
                userBean.setB_year(rs.getInt(10));
                userBean.setB_month(rs.getInt(11));
                userBean.setB_day(rs.getInt(12));

                String interest = rs.getString(13);
                userBean.setInterest(stringTolist(interest));

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
            String sql = "update user_new set name=?, pwd=?, gender=?, province=?, city=?, district=?, " +
                         "detail=?, b_year=?, b_month=?, b_day=?,interest=? where id = ?;";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2,user.getPwd());
            stmt.setString(3,user.getGender());
            stmt.setString(4,user.getAddress().getProvince());
            stmt.setString(5,user.getAddress().getCity());
            stmt.setString(6,user.getAddress().getDistrict());
            stmt.setString(7,user.getAddress().getDetail());
            stmt.setInt(8,user.getB_year());
            stmt.setInt(9,user.getB_month());
            stmt.setInt(10,user.getB_day());
            stmt.setString(11,listToString(user.getInterest()));
            stmt.setString(12,user.getId());

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

    private String listToString(ArrayList<String> list){
        String str = "";

        for(int i = 0; i < list.size(); i ++){
            str += (list.get(i)+",");
        }
        str = str.substring(0,str.length() - 1);
        return str;
    }
}
