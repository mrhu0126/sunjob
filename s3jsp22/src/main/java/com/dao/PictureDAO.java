package com.dao;

import com.pojo.Picture;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PictureDAO {

    //根据商品查图片
    public Set<Picture> findbygid(String gid){
        Set<Picture> set = new HashSet<Picture>();
        String sql= "select picid , picname , gid from pic where gid = ?";
        ResultSet rs = DBUtil.query(sql , gid);
        try {
            while(rs.next()){
                Picture picture = new Picture();
                picture.setPid(rs.getInt(1));
                picture.setPname(rs.getString(2));
                picture.setGid(rs.getInt(3));
                set.add(picture);
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


        return set ;


    }

}
