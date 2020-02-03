package com.dao;

import com.pojo.Goods;
import com.util.DBUtil;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {
    //分页
    public List<Goods> fenye(int page , int size , String name , String bottom , String top){
        List<Goods> list = new ArrayList<Goods>();
        StringBuffer  sb = new StringBuffer("select goodsid , goodsname , goodsprice , goodscount , goodspic , goodsdesc from goods where 1=1");

        List vlist = new ArrayList();

        if(name!=null && name.trim().length()>0){
            sb.append(" and goodsname like ? ");
            vlist.add("%"+name+"%");
        }

        if(bottom!=null && bottom.trim().length()>0){
            sb.append(" and goodsprice >= ? ");
            vlist.add(bottom);
        }

        if(top!=null && top.trim().length()>0){
            sb.append(" and goodsprice <= ? ");
            vlist.add(top);
        }

        sb.append(" limit ? ,?");
        vlist.add((page-1)*size);
        vlist.add(size);


        String sql = sb.toString();

        ResultSet rs = DBUtil.query(sql , vlist.toArray());
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

    //查找总条数
    public int getCount(String name , String bottom ,String top){
        StringBuffer sb = new StringBuffer("select count(*) from goods where 1=1 ");

        List list = new ArrayList();

        if(name!=null && name.trim().length()>0){
            sb.append(" and goodsname like ? ");
            list.add("%"+name+"%");
        }

        if(bottom!=null && bottom.trim().length()>0){
            sb.append(" and goodsprice >= ? ");
            list.add(bottom);
        }

        if(top!=null && top.trim().length()>0){
            sb.append(" and goodsprice <= ? ");
            list.add(top);
        }

        String sql = sb.toString();

        int n = DBUtil.uniqueQuery(sql , list.toArray());
        return n ;
    }

    //根据主键查找
    public Goods findbyid(String goodsid){
        String  sql = "select goodsid , goodsname , goodsprice , goodscount , goodspic , goodsdesc from goods where goodsid = ?" ;
        ResultSet rs = DBUtil.query(sql , goodsid);
        Goods goods =null;
        try {
            if(rs.next()){
                goods = new Goods();
                goods.setGoodsid(rs.getInt(1));
                goods.setGoodsname(rs.getString(2));
                goods.setGoodsprice(rs.getDouble(3));
                goods.setGoodscount(rs.getInt(4));
                goods.setGoodspic(rs.getString(5));
                goods.setGoodsdesc(rs.getString(6));
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

        return goods ;

    }



}
