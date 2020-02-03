package com.dao;

import com.pojo.Goods;
import com.pojo.UserInfo;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public UserInfo login(String username, String password) {
        String sql = "select username , password from userinfo where username = ? and password = ?";
        ResultSet rs = DBUtil.query(sql, username, password);
        UserInfo userInfo = null;
        try {
            if (rs.next()) {
                userInfo = new UserInfo();
                userInfo.setUsername(rs.getString(1));
                userInfo.setPassword(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.releaseConnection(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userInfo;
    }

    //检查用户是否收藏
    public boolean check(String username , String goodsid){
        String sql = "select username , goodsid from collection where username = ? and goodsid = ?" ;
        ResultSet rs = DBUtil.query(sql , username , goodsid);
        try {
            if(rs.next()){
                return true ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.releaseConnection(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return false ;



    }

    //收藏
    public int addCollection(String username , String goodsid){
        String sql = "insert into collection(username , goodsid) values(?,?)" ;
        int n = DBUtil.zsg(sql , username , goodsid);
        return n ;
    }


    //查找收藏
    public List<Goods> findCollection(String username){
        String sql = "select goodsid , goodsname , goodsprice , goodscount , goodspic , goodsdesc from goods where goodsid in (select goodsid from collection where username = ?) ";

        ResultSet rs = DBUtil.query(sql , username);
        List<Goods> list = new ArrayList<Goods>();
        try {
            while(rs.next()){
                Goods goods = new Goods();
                goods.setGoodsid(rs.getInt(1));
                goods.setGoodsname(rs.getString(2));
                goods.setGoodsprice(rs.getDouble(3));
                goods.setGoodscount(rs.getInt(4));
                goods.setGoodspic(rs.getString(5));
                goods.setGoodsdesc(rs.getString(6));
                list.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.releaseConnection(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list ;


    }





}
