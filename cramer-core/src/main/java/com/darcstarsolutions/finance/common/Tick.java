package com.darcstarsolutions.finance.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

import org.joda.time.Instant;

public class Tick implements Serializable, Comparable<Tick> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UUID id;

	private Instant timestamp;

	private BigInteger marketId;

	private BigInteger assetId;

	private BigDecimal assetPrice;

	public Tick(BigInteger marketId, Instant timestamp, BigInteger assetId,
			BigDecimal assetPrice) {
		super();
		this.id = UUID.randomUUID();
		this.timestamp = timestamp;
		this.marketId = marketId;
		this.assetId = assetId;
		this.assetPrice = assetPrice;
	}

	public UUID getId() {
		return id;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public BigInteger getMarketId() {
		return marketId;
	}

	public BigInteger getAssetId() {
		return assetId;
	}

	public BigDecimal getAssetPrice() {
		return assetPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result
				+ ((assetPrice == null) ? 0 : assetPrice.hashCode());
		result = prime * result
				+ ((marketId == null) ? 0 : marketId.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
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
		if (!(obj instanceof Tick)) {
			return false;
		}
		Tick other = (Tick) obj;
		if (assetId == null) {
			if (other.assetId != null) {
				return false;
			}
		} else if (!assetId.equals(other.assetId)) {
			return false;
		}
		if (assetPrice == null) {
			if (other.assetPrice != null) {
				return false;
			}
		} else if (!assetPrice.equals(other.assetPrice)) {
			return false;
		}
		if (marketId == null) {
			if (other.marketId != null) {
				return false;
			}
		} else if (!marketId.equals(other.marketId)) {
			return false;
		}
		if (timestamp == null) {
			if (other.timestamp != null) {
				return false;
			}
		} else if (!timestamp.equals(other.timestamp)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Tick o) {
		int result = 0;
		BigDecimal myPrice = getAssetPrice();
		BigDecimal otherPrice = o.getAssetPrice();
		result = myPrice.compareTo(otherPrice);
		return result;
	}

	@Override
	public String toString() {
		return "Tick [id=" + id + ", timestamp=" + timestamp + ", marketId="
				+ marketId + ", assetId=" + assetId + ", assetPrice="
				+ assetPrice + "]";
	}

}
