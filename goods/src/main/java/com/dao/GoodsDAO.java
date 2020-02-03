package com.dao;

import com.pojo.Goods;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {

    public List<Goods> findall(){
                String sql = "select goodsid ,goodsname , goodspic , goodscount,goodsdesc , goodsprice from goods" ;
        ResultSet rs = DBUtil.query(sql);
        List<Goods> list = new ArrayList<Goods>();
        try {
            while(rs.next()){
                Goods goods = new Goods();
                goods.setGoodsid(rs.getInt(1));
                goods.setGoodsname(rs.getString(2));
                goods.setGoodspic(rs.getString(3));
                goods.setGoodscount(rs.getInt(4));
                goods.setGoodsdesc(rs.getString(5));
                goods.setGoodsprice(rs.getDouble(6));
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

    //查找详情的 方法
    public Goods findbyid(String goodsid){
        String sql = "select goodsid ,goodsname , goodspic , goodscount,goodsdesc , goodsprice from goods where goodsid = ? " ;
        ResultSet rs = DBUtil.query(sql , goodsid);
        Goods goods = null ;
        try {
            if(rs.next()){
                goods = new Goods();
                goods.setGoodsid(rs.getInt(1));
                goods.setGoodsname(rs.getString(2));
                goods.setGoodspic(rs.getString(3));
                goods.setGoodscount(rs.getInt(4));
                goods.setGoodsdesc(rs.getString(5));
                goods.setGoodsprice(rs.getDouble(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBUtil.releaseConnection(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return goods;
    }

}
