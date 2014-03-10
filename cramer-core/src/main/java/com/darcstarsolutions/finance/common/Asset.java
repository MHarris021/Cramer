package com.darcstarsolutions.finance.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyMismatchException;

public abstract class Asset implements Serializable, Comparable<Asset> {

	private static final long serialVersionUID = 1L;

	private BigInteger id;
	private BigMoney value;
	private String name;
	private String description;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigMoney getValue() {
		return value;
	}

	public void setValue(BigMoney value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Asset)) {
			return false;
		}
		Asset other = (Asset) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Asset o) {
		int result = 0;
		if (!this.getId().equals(o.getId())) {
			BigMoney myValue = getValue();
			BigMoney otherValue = o.getValue();
			if (myValue.isSameCurrency(otherValue)) {
				result = myValue.compareTo(otherValue);
			} else {
				throw new CurrencyMismatchException(myValue.getCurrencyUnit(),
						otherValue.getCurrencyUnit());
			}
		}
		return result;
	}

	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getQuantity() {
		// TODO Auto-generated method stub
		return null;
	}
}
