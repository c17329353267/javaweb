package com.xja.gmsc.domain;

public class Goods {
	
	private Integer goodsId;//商品id
	private String goodsName;//商品名称
	private String typeId;//商品类型 家用电器类 --》 手机电脑--》联想电脑
	private String goodsPrice;//商品价格
	private String goodsCurprice;//商品当前价格
	private String goodsRepertory;//商品库存数量
	private String goodsImg;//商品图片(id)
	private String goodsState;//商品状态  正常，热卖，售空
	private String goodsIntroduce;//商品介绍
	private String goodsLinkman;//商品介绍  -->该商品的所属店铺的客服
	private String imgpath;//图片路径
	
	public String getGoodsIntroduce() {
		return goodsIntroduce;
	}
	public void setGoodsIntroduce(String goodsIntroduce) {
		this.goodsIntroduce = goodsIntroduce;
	}
	public String getGoodsLinkman() {
		return goodsLinkman;
	}
	public void setGoodsLinkman(String goodsLinkman) {
		this.goodsLinkman = goodsLinkman;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsCurprice() {
		return goodsCurprice;
	}
	public void setGoodsCurprice(String goodsCurprice) {
		this.goodsCurprice = goodsCurprice;
	}
	public String getGoodsRepertory() {
		return goodsRepertory;
	}
	public void setGoodsRepertory(String goodsRepertory) {
		this.goodsRepertory = goodsRepertory;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getGoodsState() {
		return goodsState;
	}
	public void setGoodsState(String goodsState) {
		this.goodsState = goodsState;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsCurprice == null) ? 0 : goodsCurprice.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((goodsImg == null) ? 0 : goodsImg.hashCode());
		result = prime * result + ((goodsIntroduce == null) ? 0 : goodsIntroduce.hashCode());
		result = prime * result + ((goodsLinkman == null) ? 0 : goodsLinkman.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((goodsPrice == null) ? 0 : goodsPrice.hashCode());
		result = prime * result + ((goodsRepertory == null) ? 0 : goodsRepertory.hashCode());
		result = prime * result + ((goodsState == null) ? 0 : goodsState.hashCode());
		result = prime * result + ((imgpath == null) ? 0 : imgpath.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (goodsCurprice == null) {
			if (other.goodsCurprice != null)
				return false;
		} else if (!goodsCurprice.equals(other.goodsCurprice))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (goodsImg == null) {
			if (other.goodsImg != null)
				return false;
		} else if (!goodsImg.equals(other.goodsImg))
			return false;
		if (goodsIntroduce == null) {
			if (other.goodsIntroduce != null)
				return false;
		} else if (!goodsIntroduce.equals(other.goodsIntroduce))
			return false;
		if (goodsLinkman == null) {
			if (other.goodsLinkman != null)
				return false;
		} else if (!goodsLinkman.equals(other.goodsLinkman))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (goodsPrice == null) {
			if (other.goodsPrice != null)
				return false;
		} else if (!goodsPrice.equals(other.goodsPrice))
			return false;
		if (goodsRepertory == null) {
			if (other.goodsRepertory != null)
				return false;
		} else if (!goodsRepertory.equals(other.goodsRepertory))
			return false;
		if (goodsState == null) {
			if (other.goodsState != null)
				return false;
		} else if (!goodsState.equals(other.goodsState))
			return false;
		if (imgpath == null) {
			if (other.imgpath != null)
				return false;
		} else if (!imgpath.equals(other.imgpath))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", typeId=" + typeId + ", goodsPrice="
				+ goodsPrice + ", goodsCurprice=" + goodsCurprice + ", goodsRepertory=" + goodsRepertory + ", goodsImg="
				+ goodsImg + ", goodsState=" + goodsState + ", goodsIntroduce=" + goodsIntroduce + ", goodsLinkman="
				+ goodsLinkman + ", imgpath=" + imgpath + "]";
	}
}
