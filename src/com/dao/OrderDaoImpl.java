package com.dao;


import com.bean.AddressBean;
import com.bean.OrderBean;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class OrderDaoImpl implements OrderDao  {
    @Override
    public ArrayList<OrderBean> getOrder(int offset,String userid, String type) {
        ArrayList<OrderBean> list = new ArrayList<OrderBean>();

        Connection conn = JdbcPool.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            int pos = (offset-1)*8;
            String sql = "select * from ticketorder where userid = " + userid + " and state = " + "\"" + type + "\"" +
                        "  limit 8 offset " + pos;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                OrderBean orderBean = new OrderBean();
                orderBean.setId(rs.getInt(1));
                orderBean.setUserid(userid);
                orderBean.setPath(rs.getString(3));
                orderBean.setActid(rs.getInt(4));
                orderBean.setVenueid(rs.getInt(5));
                orderBean.setState(type);
                orderBean.setSum(rs.getDouble(7));
                orderBean.setActName(rs.getString(8));
                orderBean.setActTime(rs.getString(9));
                orderBean.setVenueName(rs.getString(10));
                orderBean.setRoom(rs.getString(11));
                orderBean.setSeatX(stringTolist(rs.getString(12)));
                orderBean.setSeatY(stringTolist(rs.getString(13)));
                orderBean.setPayDate(rs.getDate(14));
                orderBean.setCreateDate(rs.getDate(15));
                orderBean.setPay_id(rs.getString(16));

                list.add(orderBean);
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

        return list;
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
    public void addOrder(OrderBean order) {
        PreparedStatement stmt = null;
        Connection conn = JdbcPool.getInstance().getConnection();
        try {

            String sql = "insert into ticketorder"
                    + "(id, userid, path, actid, venueid, state, sum, actName, actTime, venueName, room, seatX, seatY, payDate, createDate, pay_id) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1,order.getId());
            stmt.setString(2,order.getUserid());
            stmt.setString(3,order.getPath());
            stmt.setInt(4,order.getActid());
            stmt.setInt(5,order.getVenueid());
            stmt.setString(6,order.getState());
            stmt.setDouble(7,order.getSum());
            stmt.setString(8,order.getActName());
            stmt.setString(9,order.getActTime());
            stmt.setString(10,order.getVenueName());
            stmt.setString(11,order.getRoom());
            stmt.setString(12,listToString(order.getSeatX()));
            stmt.setString(13,listToString(order.getSeatY()));
            stmt.setString(14,order.getPayDate().toString());
            stmt.setString(15,order.getCreateDate().toString());
            stmt.setString(16,order.getPay_id());


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


    @Override
    public void modOrder(OrderBean order) {
        Connection conn = JdbcPool.getInstance().getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "update ticketorder set userid=?, path=?, actid=?, venueid=?, state=?, sum=?, " +
                    "actName=?, actTime=?, venueName=?, room=?, seatX=?, seatY=?, payDate=?, createDate=?, pay_id=? where id = ?;";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, order.getUserid());
            stmt.setString(2,order.getPath());
            stmt.setInt(3,order.getActid());
            stmt.setInt(4,order.getVenueid());
            stmt.setString(5,order.getState());
            stmt.setDouble(6,order.getSum());
            stmt.setString(7,order.getActName());
            stmt.setString(8,order.getActTime());
            stmt.setString(9,order.getVenueName());
            stmt.setString(10,order.getRoom());
            stmt.setString(11,listToString(order.getSeatX()));
            stmt.setString(12,listToString(order.getSeatY()));
            stmt.setString(13,order.getPayDate().toString());
            stmt.setString(14,order.getCreateDate().toString());
            stmt.setString(15,order.getPay_id());
            stmt.setInt(16,order.getId());

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
    public OrderBean getOrderByID(int id) {
        Connection conn = JdbcPool.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        OrderBean orderBean = new OrderBean();
        try {
            String sql = "select * from ticketorder where id = " + id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                orderBean.setId(rs.getInt(1));
                orderBean.setUserid(rs.getString(2));
                orderBean.setPath(rs.getString(3));
                orderBean.setActid(rs.getInt(4));
                orderBean.setVenueid(rs.getInt(5));
                orderBean.setState(rs.getString(6));
                orderBean.setSum(rs.getDouble(7));
                orderBean.setActName(rs.getString(8));
                orderBean.setActTime(rs.getString(9));
                orderBean.setVenueName(rs.getString(10));
                orderBean.setRoom(rs.getString(11));
                orderBean.setSeatX(stringTolist(rs.getString(12)));
                orderBean.setSeatY(stringTolist(rs.getString(13)));
                orderBean.setPayDate(rs.getDate(14));
                orderBean.setCreateDate(rs.getDate(15));
                orderBean.setPay_id(rs.getString(16));

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

        return orderBean;
    }
}
