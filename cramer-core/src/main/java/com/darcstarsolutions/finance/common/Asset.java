package com.darcstarsolutions.finance.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Asset implements Serializable, Comparable<Asset> {

	private static final long serialVersionUID = 1L;

	private BigInteger id;
	private Identifier identifier;
	private BigDecimal price;
	private BigDecimal quantity;

	public Asset(Identifier identifier, BigDecimal price,
			BigDecimal quantity) {
		this.identifier = identifier;
		this.price = price;
		this.quantity = quantity;
	}

	public BigInteger getId() {
		return id;
	}

	protected void setId(BigInteger id) {
		this.id = id;
	}

	public Identifier getIdentifier() {
		return this.identifier;
	}

	public String getName() {
		return getIdentifier().getName();
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public BigDecimal getValue() {
		BigDecimal value = price.multiply(quantity);
		return value;
	}

	/***
	 * Natural Order Comparison based on price of asset and not value;
	 */
	@Override
	public int compareTo(Asset o) {
		int result = 0;
		BigDecimal myPrice = getPrice();
		BigDecimal otherPrice = o.getPrice();
		result = myPrice.compareTo(otherPrice);
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
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
		if (identifier == null) {
			if (other.identifier != null) {
				return false;
			}
		} else if (!identifier.equals(other.identifier)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (quantity == null) {
			if (other.quantity != null) {
				return false;
			}
		} else if (!quantity.equals(other.quantity)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", identifier="
				+ identifier + ", price=" + price + ", quantity=" + quantity
				+ ", value=" + getValue() + "]";
	}

}
