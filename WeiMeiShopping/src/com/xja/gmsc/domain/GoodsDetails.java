package com.xja.gmsc.domain;

/**
 * 购物详情实体类
 * @author Administrator
 *
 */
public class GoodsDetails {
	
	private Integer detailsId;	//购物详情id
	private Integer GoodsId;	//购买商品id
	private String buyNum;		//购买数量
	private String singlePrice;	//商品单价
	private String totalPrice;	//商品总价  ： 单价*购买数量
	private String loginName;	//登陆人姓名
	private String buystate;	//购买状态
	private String receivePhone;//收货人电话
	private String receiveAddress;//收货人地址
	private String receiveName;
	
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public Integer getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}
	public Integer getGoodsId() {
		return GoodsId;
	}
	public void setGoodsId(Integer goodsId) {
		GoodsId = goodsId;
	}
	public String getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(String buyNum) {
		this.buyNum = buyNum;
	}
	public String getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(String singlePrice) {
		this.singlePrice = singlePrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getBuystate() {
		return buystate;
	}
	public void setBuystate(String buystate) {
		this.buystate = buystate;
	}
	public String getReceivePhone() {
		return receivePhone;
	}
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((GoodsId == null) ? 0 : GoodsId.hashCode());
		result = prime * result + ((buyNum == null) ? 0 : buyNum.hashCode());
		result = prime * result + ((buystate == null) ? 0 : buystate.hashCode());
		result = prime * result + ((detailsId == null) ? 0 : detailsId.hashCode());
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((receiveAddress == null) ? 0 : receiveAddress.hashCode());
		result = prime * result + ((receivePhone == null) ? 0 : receivePhone.hashCode());
		result = prime * result + ((singlePrice == null) ? 0 : singlePrice.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
		GoodsDetails other = (GoodsDetails) obj;
		if (GoodsId == null) {
			if (other.GoodsId != null)
				return false;
		} else if (!GoodsId.equals(other.GoodsId))
			return false;
		if (buyNum == null) {
			if (other.buyNum != null)
				return false;
		} else if (!buyNum.equals(other.buyNum))
			return false;
		if (buystate == null) {
			if (other.buystate != null)
				return false;
		} else if (!buystate.equals(other.buystate))
			return false;
		if (detailsId == null) {
			if (other.detailsId != null)
				return false;
		} else if (!detailsId.equals(other.detailsId))
			return false;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (receiveAddress == null) {
			if (other.receiveAddress != null)
				return false;
		} else if (!receiveAddress.equals(other.receiveAddress))
			return false;
		if (receivePhone == null) {
			if (other.receivePhone != null)
				return false;
		} else if (!receivePhone.equals(other.receivePhone))
			return false;
		if (singlePrice == null) {
			if (other.singlePrice != null)
				return false;
		} else if (!singlePrice.equals(other.singlePrice))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GoodsDetails [detailsId=" + detailsId + ", GoodsId=" + GoodsId + ", buyNum=" + buyNum + ", singlePrice="
				+ singlePrice + ", totalPrice=" + totalPrice + ", loginName=" + loginName + ", buystate=" + buystate
				+ ", receivePhone=" + receivePhone + ", receiveAddress=" + receiveAddress + "]";
	}
}
