package com.pojo;

public class Goods {
    private int goodsid;
    private String goodsname ;
    private String goodsdesc ;
    private Double goodsprice ;
    private String goodspic ;
    private int goodscount ;


    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc;
    }

    public Double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodspic() {
        return goodspic;
    }

    public void setGoodspic(String goodspic) {
        this.goodspic = goodspic;
    }

    public int getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(int goodscount) {
        this.goodscount = goodscount;
    }

    @Override
    public int hashCode() {
        return goodsid;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Goods){
           if( ((Goods)obj).getGoodsid()==this.goodsid){
               return true ;
           }
        }
        return false ;
    }
}
