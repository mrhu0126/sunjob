package com.dao;

import com.pojo.Goods;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {

    //根据种类查
    public List<Goods> findbykind() {

        String sql = "select goodsid , goodsname , goodsprice , goodscount , goodspic , goodsdesc from goods limit 4";
        List<Goods> list = new ArrayList<>();
        ResultSet rs = DBUtil.query(sql);
        try {
            while (rs.next()) {
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

        return list;
    }

}
