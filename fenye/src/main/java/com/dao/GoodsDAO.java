package com.dao;

import com.pojo.Goods;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {

    public int getCount(){
        String sql = "select count(*) from goods" ;
        int n = DBUtil.uniqueQuery(sql);
        return n ;
    }

    //分页
    public List<Goods> fenye(int page, int size) {
        String sql = "select goodsid , goodsname , goodsprice , goodscount , goodsdesc , goodspic from goods limit ?, ?";
        ResultSet rs = DBUtil.query(sql , (page-1)*size , size);
        List<Goods> list = new ArrayList<Goods>();

        try {
            while(rs.next()){
                Goods goods = new Goods();
                goods.setGoodsid(rs.getInt(1));
                goods.setGoodsname(rs.getString(2));
                goods.setGoodsprice(rs.getDouble(3));
                goods.setGoodscount(rs.getInt(4));
                goods.setGoodsdesc(rs.getString(5));
                goods.setGoodspic(rs.getString(6));
                list.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放连接
            try {
                DBUtil.releaseConnection(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list ;

    }
}
