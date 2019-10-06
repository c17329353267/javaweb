package com.xja.gmsc.domain;

/**
 * 订单实体类
 * @author Administrator
 *
 */
public class GoodsOrder {
	
	private Integer orderId;//订单id
	private String orderState;//订单状态
	private String tatalPrice;//订单总价格
	private String reveivePhone;//收货人电话
	private String receiveAddress;//收货人地址
	private String receiveName;//收货人姓名
	private String loginName;//登陆人姓名
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getTatalPrice() {
		return tatalPrice;
	}
	public void setTatalPrice(String tatalPrice) {
		this.tatalPrice = tatalPrice;
	}
	public String getReveivePhone() {
		return reveivePhone;
	}
	public void setReveivePhone(String reveivePhone) {
		this.reveivePhone = reveivePhone;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderState == null) ? 0 : orderState.hashCode());
		result = prime * result + ((receiveAddress == null) ? 0 : receiveAddress.hashCode());
		result = prime * result + ((receiveName == null) ? 0 : receiveName.hashCode());
		result = prime * result + ((reveivePhone == null) ? 0 : reveivePhone.hashCode());
		result = prime * result + ((tatalPrice == null) ? 0 : tatalPrice.hashCode());
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
		GoodsOrder other = (GoodsOrder) obj;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderState == null) {
			if (other.orderState != null)
				return false;
		} else if (!orderState.equals(other.orderState))
			return false;
		if (receiveAddress == null) {
			if (other.receiveAddress != null)
				return false;
		} else if (!receiveAddress.equals(other.receiveAddress))
			return false;
		if (receiveName == null) {
			if (other.receiveName != null)
				return false;
		} else if (!receiveName.equals(other.receiveName))
			return false;
		if (reveivePhone == null) {
			if (other.reveivePhone != null)
				return false;
		} else if (!reveivePhone.equals(other.reveivePhone))
			return false;
		if (tatalPrice == null) {
			if (other.tatalPrice != null)
				return false;
		} else if (!tatalPrice.equals(other.tatalPrice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GoodsOrder [orderId=" + orderId + ", orderState=" + orderState + ", tatalPrice=" + tatalPrice
				+ ", reveivePhone=" + reveivePhone + ", receiveAddress=" + receiveAddress + ", receiveName="
				+ receiveName + ", loginName=" + loginName + "]";
	}
	
}
