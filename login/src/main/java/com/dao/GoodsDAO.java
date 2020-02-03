package com.dao;

import com.pojo.Goods;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {

    public List<Goods> findall(){
        String sql = "select goodsid , goodsname , goodspic , goodscount , goodsprice , goodsdesc from goods" ;
        ResultSet rs = DBUtil.query(sql);

        List<Goods> list = new ArrayList<Goods>();
        try {
            while(rs.next()){//遍历结果集   有一条记录就创建一个对象
                Goods goods = new Goods();
                goods.setGoodsid(rs.getInt(1));
                goods.setGoodsname(rs.getString(2));
                goods.setGoodspic(rs.getString(3));
                goods.setGoodscount(rs.getInt(4));
                goods.setGoodsprice(rs.getDouble(5));
                goods.setGoodsdesc(rs.getString(6));
                list.add(goods);//把创建好的对象加入集合种
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtil.releaseConnection(rs.getStatement().getConnection());
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return list ;

    }

}
