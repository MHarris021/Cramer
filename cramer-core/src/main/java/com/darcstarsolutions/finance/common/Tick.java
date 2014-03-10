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

	private BigDecimal assetQuantity;

	public Tick(BigInteger marketId, Instant timestamp, Asset asset) {
		this(marketId, timestamp, asset.getId(), asset.getPrice(), asset
				.getQuantity());
	}

	public Tick(BigInteger marketId, Instant timestamp, BigInteger assetId,
			BigDecimal assetPrice) {
		this(marketId, timestamp, assetId, assetPrice, BigDecimal.ONE);
	}

	public Tick(BigInteger marketId, Instant timestamp, BigInteger assetId,
			BigDecimal assetPrice, BigDecimal assetQuantity) {
		super();
		this.id = UUID.randomUUID();
		this.timestamp = timestamp;
		this.marketId = marketId;
		this.assetId = assetId;
		this.assetPrice = assetPrice;
		this.assetQuantity = assetQuantity;
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

	public BigDecimal getAssetQuantity() {
		return assetQuantity;
	}

	public boolean isAfter(Tick tick) {
		Instant myInstant = this.getTimestamp();
		Instant otherInstant = tick.getTimestamp();
		return myInstant.isAfter(otherInstant);
	}

	public boolean isBefore(Tick tick) {
		Instant myInstant = this.getTimestamp();
		Instant otherInstant = tick.getTimestamp();
		return myInstant.isBefore(otherInstant);
	}

	public BigDecimal getAssetValue() {
		BigDecimal price = this.getAssetPrice();
		BigDecimal quantity = this.getAssetQuantity();
		BigDecimal value = price.multiply(quantity);
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result
				+ ((assetPrice == null) ? 0 : assetPrice.hashCode());
		result = prime * result
				+ ((assetQuantity == null) ? 0 : assetQuantity.hashCode());
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
		if (assetQuantity == null) {
			if (other.assetQuantity != null) {
				return false;
			}
		} else if (!assetQuantity.equals(other.assetQuantity)) {
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
		Instant myInstant = this.getTimestamp();
		Instant otherInstant = o.getTimestamp();
		result = myInstant.compareTo(otherInstant);
		return result;
	}

	@Override
	public String toString() {
		return "Tick [id=" + id + ", timestamp=" + timestamp + ", marketId="
				+ marketId + ", assetId=" + assetId + ", assetPrice="
				+ assetPrice + ", assetQuantity=" + assetQuantity
				+ ", assetValue=" + getAssetValue() + "]";
	}

}
