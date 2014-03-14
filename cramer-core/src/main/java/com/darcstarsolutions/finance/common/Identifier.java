package com.darcstarsolutions.finance.common;

import java.io.Serializable;
import java.math.BigInteger;

public abstract class Identifier implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String INVALID = "Invalid";

	private BigInteger id;
	private String value;
	private String name;

	public Identifier(String value) {
		this(value, "");
	}

	public Identifier(String value, String name) {
		setValue(value);
		this.name = name;
	}

	public BigInteger getId() {
		return id;
	}

	protected void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	protected abstract boolean valid(String value);

	public String getValue() {
		return value;
	}

	private void setValue(String value) {
		if (valid(value)) {
			this.value = value;
		} else {
			this.value = INVALID;
		}
	}

	public boolean isInvalid() {
		if (this.value.equals(INVALID)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (!(obj instanceof Identifier)) {
			return false;
		}
		Identifier other = (Identifier) obj;
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
	public String toString() {
		return "Identifier [id=" + id + ", value=" + value + ", name=" + name
				+ "]";
	}

}
