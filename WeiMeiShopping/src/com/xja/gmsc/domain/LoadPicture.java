package com.xja.gmsc.domain;

public class LoadPicture {

	private Integer lunboId;
	private String lunboUrl;
	private String lunboType;
	public Integer getLunboId() {
		return lunboId;
	}
	public void setLunboId(Integer lunboId) {
		this.lunboId = lunboId;
	}
	public String getLunboUrl() {
		return lunboUrl;
	}
	public void setLunboUrl(String lunboUrl) {
		this.lunboUrl = lunboUrl;
	}
	public String getLunboType() {
		return lunboType;
	}
	public void setLunboType(String lunboType) {
		this.lunboType = lunboType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lunboId == null) ? 0 : lunboId.hashCode());
		result = prime * result + ((lunboType == null) ? 0 : lunboType.hashCode());
		result = prime * result + ((lunboUrl == null) ? 0 : lunboUrl.hashCode());
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
		LoadPicture other = (LoadPicture) obj;
		if (lunboId == null) {
			if (other.lunboId != null)
				return false;
		} else if (!lunboId.equals(other.lunboId))
			return false;
		if (lunboType == null) {
			if (other.lunboType != null)
				return false;
		} else if (!lunboType.equals(other.lunboType))
			return false;
		if (lunboUrl == null) {
			if (other.lunboUrl != null)
				return false;
		} else if (!lunboUrl.equals(other.lunboUrl))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoadPicture [lunboId=" + lunboId + ", lunboUrl=" + lunboUrl + ", lunboType=" + lunboType + "]";
	}
	
}
