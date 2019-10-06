package com.xja.gmsc.domain;
/**
 * 付款实体类
 * @author Administrator
 *
 */
public class GoodsPayMoney {
	
	private String goodsPayId;		//支付id
	private String goodsPayTime;	//支付时间
	private String goodsPayUsername;//支付用户
	private String goodsTotalMoney;	//支付总钱数
	private String goodsOrderName;	//支付订单名字
	private String goodsReceiveAddr;//收货地址
	private String goodsreceivePhone;//收货电话
	public String getGoodsPayId() {
		return goodsPayId;
	}
	public void setGoodsPayId(String goodsPayId) {
		this.goodsPayId = goodsPayId;
	}
	public String getGoodsPayTime() {
		return goodsPayTime;
	}
	public void setGoodsPayTime(String goodsPayTime) {
		this.goodsPayTime = goodsPayTime;
	}
	public String getGoodsPayUsername() {
		return goodsPayUsername;
	}
	public void setGoodsPayUsername(String goodsPayUsername) {
		this.goodsPayUsername = goodsPayUsername;
	}
	public String getGoodsTotalMoney() {
		return goodsTotalMoney;
	}
	public void setGoodsTotalMoney(String goodsTotalMoney) {
		this.goodsTotalMoney = goodsTotalMoney;
	}
	public String getGoodsOrderName() {
		return goodsOrderName;
	}
	public void setGoodsOrderName(String goodsOrderName) {
		this.goodsOrderName = goodsOrderName;
	}
	public String getGoodsReceiveAddr() {
		return goodsReceiveAddr;
	}
	public void setGoodsReceiveAddr(String goodsReceiveAddr) {
		this.goodsReceiveAddr = goodsReceiveAddr;
	}
	public String getGoodsreceivePhone() {
		return goodsreceivePhone;
	}
	public void setGoodsreceivePhone(String goodsreceivePhone) {
		this.goodsreceivePhone = goodsreceivePhone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsOrderName == null) ? 0 : goodsOrderName.hashCode());
		result = prime * result + ((goodsPayId == null) ? 0 : goodsPayId.hashCode());
		result = prime * result + ((goodsPayTime == null) ? 0 : goodsPayTime.hashCode());
		result = prime * result + ((goodsPayUsername == null) ? 0 : goodsPayUsername.hashCode());
		result = prime * result + ((goodsReceiveAddr == null) ? 0 : goodsReceiveAddr.hashCode());
		result = prime * result + ((goodsTotalMoney == null) ? 0 : goodsTotalMoney.hashCode());
		result = prime * result + ((goodsreceivePhone == null) ? 0 : goodsreceivePhone.hashCode());
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
		GoodsPayMoney other = (GoodsPayMoney) obj;
		if (goodsOrderName == null) {
			if (other.goodsOrderName != null)
				return false;
		} else if (!goodsOrderName.equals(other.goodsOrderName))
			return false;
		if (goodsPayId == null) {
			if (other.goodsPayId != null)
				return false;
		} else if (!goodsPayId.equals(other.goodsPayId))
			return false;
		if (goodsPayTime == null) {
			if (other.goodsPayTime != null)
				return false;
		} else if (!goodsPayTime.equals(other.goodsPayTime))
			return false;
		if (goodsPayUsername == null) {
			if (other.goodsPayUsername != null)
				return false;
		} else if (!goodsPayUsername.equals(other.goodsPayUsername))
			return false;
		if (goodsReceiveAddr == null) {
			if (other.goodsReceiveAddr != null)
				return false;
		} else if (!goodsReceiveAddr.equals(other.goodsReceiveAddr))
			return false;
		if (goodsTotalMoney == null) {
			if (other.goodsTotalMoney != null)
				return false;
		} else if (!goodsTotalMoney.equals(other.goodsTotalMoney))
			return false;
		if (goodsreceivePhone == null) {
			if (other.goodsreceivePhone != null)
				return false;
		} else if (!goodsreceivePhone.equals(other.goodsreceivePhone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GoodsPayMoney [goodsPayId=" + goodsPayId + ", goodsPayTime=" + goodsPayTime + ", goodsPayUsername="
				+ goodsPayUsername + ", goodsTotalMoney=" + goodsTotalMoney + ", goodsOrderName=" + goodsOrderName
				+ ", goodsReceiveAddr=" + goodsReceiveAddr + ", goodsreceivePhone=" + goodsreceivePhone + "]";
	}
}
