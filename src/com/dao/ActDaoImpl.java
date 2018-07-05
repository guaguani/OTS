package com.dao;

import com.bean.ActivityBean;
import com.bean.HallBean;
import com.bean.SeatBean;
import org.springframework.stereotype.Repository;

import java.sql.*;;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class ActDaoImpl implements ActDao{
    @Override
    public ActivityBean getByID(int id) {
        ActivityBean activityBean = new ActivityBean();
        Connection conn = JdbcPool.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> hallsId = new ArrayList<Integer>();
        try {
            String sql = "select * from Activity where id=" + id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                activityBean.setId(id);
                activityBean.setVid(rs.getInt(2));
                activityBean.setDes(rs.getString(3));
                activityBean.setType(rs.getString(4));
                activityBean.setName(rs.getString(5));
                activityBean.setVname(rs.getString(6));
                activityBean.setCity(rs.getString(7));
                activityBean.setPath(rs.getString(8));
                activityBean.setPrice(rs.getDouble(9));
                activityBean.setFirst(rs.getString(10));
                activityBean.setLast(rs.getString(11));
                activityBean.setState(rs.getString(12));
                activityBean.setApath(rs.getString(13));

                //获取展厅id列表
                String [] hallStr = rs.getString(14).split(",");
                for(int i = 0; i < hallStr.length; i ++){
                    hallsId.add(Integer.parseInt(hallStr[i]));
                }
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

        ArrayList<HallBean> halls = new ArrayList<HallBean>();
        for(int hallid: hallsId){
            halls.add(getHallById(hallid));
        }
        activityBean.setHalls(halls);
        return activityBean;
    }

    private ArrayList<ActivityBean> getListByIds(int [] idarray){
        ArrayList<ActivityBean> list = new ArrayList<ActivityBean>();
        Connection conn = JdbcPool.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            for(int i = 0; i < idarray.length; i ++){
                int id = idarray[i];
                ActivityBean activityBean = new ActivityBean();

                String sql = "select * from Activity where id=" + id;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    activityBean.setId(id);
                    activityBean.setVid(rs.getInt(2));
                    activityBean.setDes(rs.getString(3));
                    activityBean.setType(rs.getString(4));
                    activityBean.setName(rs.getString(5));
                    activityBean.setVname(rs.getString(6));
                    activityBean.setCity(rs.getString(7));
                    activityBean.setPath(rs.getString(8));
                    activityBean.setPrice(rs.getDouble(9));
                    activityBean.setFirst(rs.getString(10));
                    activityBean.setLast(rs.getString(11));
                    activityBean.setState(rs.getString(12));
                    activityBean.setApath(rs.getString(13));
                }
                list.add(activityBean);
            }
        }catch (SQLException e) {
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

    @Override
    public ArrayList<ActivityBean> advertiseAct() {
        int [] idarray = {5, 433, 749 , 844, 61,1429, 1380,1588 ,1770,2109};
        return getListByIds(idarray);
    }

    @Override
    public ArrayList<ActivityBean> hotAct() {
        int [] idarray = {1770, 1588, 749 , 61, 844,1429, 1380,433 ,5,2109};
        return getListByIds(idarray);
    }

    @Override
    public ArrayList<ActivityBean> selectByCond(String city, String type, int offset) {
        ArrayList<ActivityBean> list = new ArrayList<ActivityBean>();

        Connection conn = JdbcPool.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int pos = (offset - 1) * 8;
        try {
            String sql = "select * from Activity where city = ? and type = ? limit 8 offset " + pos;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,city);
            stmt.setString(2,type);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ActivityBean activityBean = new ActivityBean();
                activityBean.setId(rs.getInt(1));
                activityBean.setVid(rs.getInt(2));
                activityBean.setDes(rs.getString(3));
                activityBean.setType(rs.getString(4));
                activityBean.setName(rs.getString(5));
                activityBean.setVname(rs.getString(6));
                activityBean.setCity(rs.getString(7));
                activityBean.setPath(rs.getString(8));
                activityBean.setPrice(rs.getDouble(9));
                activityBean.setFirst(rs.getString(10));
                activityBean.setLast(rs.getString(11));
                activityBean.setState(rs.getString(12));
                activityBean.setApath(rs.getString(13));

                list.add(activityBean);
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
        //按时间顺序，时间早的在前
        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                ActivityBean stu1=(ActivityBean)o1;
                ActivityBean stu2=(ActivityBean)o2;
                return stu1.getFirst().compareTo(stu2.getFirst());
            }
        });
        return list;
    }

    @Override
    public ArrayList<ActivityBean> selectByNameOrVen(String input, int offset) {
        String [] token = input.split(" ");
        ArrayList<ActivityBean> list = new ArrayList<ActivityBean>();

        Connection conn = JdbcPool.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from Activity ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String des = rs.getString(3);
                String name = rs.getString(5);
                String vname = rs.getString(6);
                String build = des + " " + name + " " + vname;

                for(int i = 0; i < token.length; i ++){
                    if(build.contains(token[i])){
                        ActivityBean activityBean = new ActivityBean();
                        activityBean.setId(rs.getInt(1));
                        activityBean.setVid(rs.getInt(2));
                        activityBean.setDes(rs.getString(3));
                        activityBean.setType(rs.getString(4));
                        activityBean.setName(rs.getString(5));
                        activityBean.setVname(rs.getString(6));
                        activityBean.setCity(rs.getString(7));
                        activityBean.setPath(rs.getString(8));
                        activityBean.setPrice(rs.getDouble(9));
                        activityBean.setFirst(rs.getString(10));
                        activityBean.setLast(rs.getString(11));
                        activityBean.setState(rs.getString(12));
                        activityBean.setApath(rs.getString(13));

                        list.add(activityBean);
                        break;
                    }
                }


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

        //按时间顺序，时间早的在前
        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                ActivityBean stu1=(ActivityBean)o1;
                ActivityBean stu2=(ActivityBean)o2;
                return stu1.getFirst().compareTo(stu2.getFirst());
            }
        });

        int size = list.size();
        int head = (offset - 1) * 8;
        int tail = offset * 8;
        if(tail >= size){
            tail = size;
        }
        ArrayList<ActivityBean> newlist = new ArrayList<ActivityBean>();
        for(int i = head; i < tail; i ++){
            newlist.add(list.get(i));
        }
        return  newlist;
    }

    public ArrayList<ActivityBean> getAllActivity() {
        ArrayList<ActivityBean> list = new ArrayList<ActivityBean>();

        Connection conn = JdbcPool.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from Activity ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ActivityBean activityBean = new ActivityBean();
                activityBean.setId(rs.getInt(1));
                activityBean.setVid(rs.getInt(2));
                activityBean.setDes(rs.getString(3));
                activityBean.setType(rs.getString(4));
                activityBean.setName(rs.getString(5));
                activityBean.setVname(rs.getString(6));
                activityBean.setCity(rs.getString(7));
                activityBean.setPath(rs.getString(8));
                activityBean.setPrice(rs.getDouble(9));
                activityBean.setFirst(rs.getString(10));
                activityBean.setLast(rs.getString(11));
                activityBean.setState(rs.getString(12));
                activityBean.setApath(rs.getString(13));

                list.add(activityBean);
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

        //按时间顺序，时间早的在前
        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                ActivityBean stu1=(ActivityBean)o1;
                ActivityBean stu2=(ActivityBean)o2;
                return stu1.getFirst().compareTo(stu2.getFirst());
            }
        });


        return list;
    }

    public HallBean getHallById(int id){
        HallBean hallBean = new HallBean();
        Connection conn = JdbcPool.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        int rows = 0;       int col = 0;
        try {
            String sql = "select * from hall where id=" + id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                hallBean.setId(id);
                hallBean.setVid(rs.getInt(2));
                hallBean.setName(rs.getString(3));
                hallBean.setShowTime(rs.getString(4));
                hallBean.setPrices(doubleTolist(rs.getString(5)));
                hallBean.setTip(stringTolist(rs.getString(6)));
                rows = rs.getInt(7);
                col = rs.getInt(8);
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

        SeatBean[][] seats = getSeats(id, rows, col);
        hallBean.setSeats(seats);
        return hallBean;
    }

    /**
     *
     * @param hid   展厅id
     * @param row   座位总行
     * @param col   座位总列
     * @return
     */
    public SeatBean[][] getSeats(int hid, int row, int col){
        SeatBean[][] seats = new SeatBean[row][col];
        Connection conn = JdbcPool.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            for(int i = 1; i <= row; i ++){
                for(int j = 1; j <= col; j ++) {
                    String sql = "select * from seat_new where hid = ? and posRow = ? and posColum = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1,hid);
                    stmt.setInt(2,i);
                    stmt.setInt(3,j);
                    rs = stmt.executeQuery();

                    SeatBean seat = new SeatBean();
                    while (rs.next()) {
                        seat.setState(rs.getString(2));
                        seat.setPosRow(rs.getString(3));
                        seat.setPosColum(rs.getString(4));
                        seat.setPrice(rs.getDouble(5));
                        seat.setOid(rs.getInt(6));
                        seats[i-1][j-1] = seat;
                    }
                }
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
        return seats;
    }


    public void createSeat(int row, int col, int hid){
        PreparedStatement stmt = null;
        Connection conn = JdbcPool.getInstance().getConnection();
        try {

            for(int i = 1; i <= row; i ++){
                for(int j = 1; j <= col; j ++){
                    String sql = "insert into seat_new"
                            + "(hid, state, posRow, posColum) "
                            + "values(?, ?, ?, ?);";

                    stmt = conn.prepareStatement(sql);

                    stmt.setInt(1,hid);
                    stmt.setString(2,"空");
                    stmt.setInt(3,i);
                    stmt.setInt(4,j);
                    stmt.executeUpdate();
                }
            }
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
    private ArrayList<String> stringTolist(String str){
        ArrayList<String> list = new ArrayList<String>();
        String [] token = str.split(",");

        for(int i = 0; i < token.length; i ++){
            list.add(token[i]);
        }

        return list;
    }

    private ArrayList<Double> doubleTolist(String str){
        ArrayList<Double> list = new ArrayList<Double>();
        String [] token = str.split(",");

        for(int i = 0; i < token.length; i ++){
            list.add(Double.parseDouble(token[i]));
        }

        return list;
    }
}
