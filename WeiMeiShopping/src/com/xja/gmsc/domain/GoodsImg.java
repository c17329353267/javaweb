package com.xja.gmsc.domain;

/**
 * 商品图片实体类
 * @author Administrator
 *
 */
public class GoodsImg {

	private Integer imgId;//图片大图id
	private Integer goodsId;//该大图对应的商品id
	private String imgpath;//图片id对应的路径
	private String imgtype;//图片类型  大图 中图 小图
	private String parentId; // 大图(中图1，中图2，中图3) 中图1(小图1，小图2，小图3)
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getImgtype() {
		return imgtype;
	}
	public void setImgtype(String imgtype) {
		this.imgtype = imgtype;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "GoodsImg [imgId=" + imgId + ", goodsId=" + goodsId + ", imgpath=" + imgpath + ", imgtype=" + imgtype
				+ ", parentId=" + parentId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((imgId == null) ? 0 : imgId.hashCode());
		result = prime * result + ((imgpath == null) ? 0 : imgpath.hashCode());
		result = prime * result + ((imgtype == null) ? 0 : imgtype.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
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
		GoodsImg other = (GoodsImg) obj;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (imgId == null) {
			if (other.imgId != null)
				return false;
		} else if (!imgId.equals(other.imgId))
			return false;
		if (imgpath == null) {
			if (other.imgpath != null)
				return false;
		} else if (!imgpath.equals(other.imgpath))
			return false;
		if (imgtype == null) {
			if (other.imgtype != null)
				return false;
		} else if (!imgtype.equals(other.imgtype))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		return true;
	}
	
}
