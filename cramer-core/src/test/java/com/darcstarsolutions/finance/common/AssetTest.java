package com.darcstarsolutions.finance.common;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssetTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AssetTest.class);

	private Asset asset1, asset2, asset3, asset4;
	private Identifier identifier1;
	private Identifier identifier2;
	private String name1;
	private String name2;
	private BigDecimal price1;
	private BigDecimal price2;
	private BigDecimal quantity1;
	private BigDecimal quantity2;

	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {
		name1 = "Asset Name 1";
		name2 = "Asset Name 2";
		identifier1 = new Identifier("id1", name1) {

			@Override
			protected boolean valid(String value) {
				return true;
			}
		};
		identifier1.setId(BigInteger.valueOf(1));
		identifier2 = new Identifier("id2", name2) {

			@Override
			protected boolean valid(String value) {
				return true;
			}
		};
		identifier2.setId(BigInteger.valueOf(2));
		price1 = BigDecimal.ONE;
		price2 = BigDecimal.TEN;
		quantity1 = BigDecimal.ONE;
		quantity2 = BigDecimal.TEN;
		asset1 = new Asset(identifier1, price1, quantity1);
		asset1.setId(BigInteger.valueOf(1));
		asset2 = new Asset(identifier1, price1, quantity1);
		asset2.setId(BigInteger.valueOf(2));
		asset3 = new Asset(identifier2, price2, quantity1);
		asset3.setId(BigInteger.valueOf(3));
		asset4 = new Asset(identifier2, price2, quantity2);
		asset4.setId(BigInteger.valueOf(4));

	}

	@After
	public void tearDown() throws Exception {
		asset1 = null;
		asset2 = null;
		asset3 = null;
		asset4 = null;
		identifier1 = null;
		identifier2 = null;
		name1 = null;
		name2 = null;
		price1 = null;
		price2 = null;
		quantity1 = null;
		quantity2 = null;
	}

	@Test
	public void testHashCode() {
		assertObjectsExist();
		assertThat(asset1.hashCode(), is(equalTo(asset2.hashCode())));
		assertThat(asset2.hashCode(), is(equalTo(asset1.hashCode())));
		assertThat(asset1.hashCode(), is(not(equalTo(asset3.hashCode()))));
		assertThat(asset1.hashCode(), is(not(equalTo(asset4.hashCode()))));
		assertThat(asset2.hashCode(), is(not(equalTo(asset3.hashCode()))));
		assertThat(asset2.hashCode(), is(not(equalTo(asset4.hashCode()))));
		assertThat(asset3.hashCode(), is(not(equalTo(asset4.hashCode()))));
		LOGGER.info("Asset1 Hashcode: " + asset1.hashCode());
		LOGGER.info("Asset2 Hashcode: " + asset2.hashCode());
		LOGGER.info("Asset3 Hashcode: " + asset3.hashCode());
		LOGGER.info("Asset4 Hashcode: " + asset4.hashCode());
	}

	@Test
	public void testGetId() {
		assertObjectsExist();
		assertThat(asset1.getId(), is(equalTo(BigInteger.valueOf(1))));
		assertThat(asset2.getId(), is(equalTo(BigInteger.valueOf(2))));
		assertThat(asset3.getId(), is(equalTo(BigInteger.valueOf(3))));
		assertThat(asset4.getId(), is(equalTo(BigInteger.valueOf(4))));
		LOGGER.info("Asset1 Id: " + asset1.getId());
		LOGGER.info("Asset2 Id: " + asset2.getId());
		LOGGER.info("Asset3 Id: " + asset3.getId());
		LOGGER.info("Asset4 Id: " + asset4.getId());
	}

	@Test
	public void testGetIdentifier() {
		assertObjectsExist();
		assertThat(asset1.getIdentifier(), is(equalTo(identifier1)));
		assertThat(asset2.getIdentifier(), is(equalTo(identifier1)));
		assertThat(asset3.getIdentifier(), is(equalTo(identifier2)));
		assertThat(asset4.getIdentifier(), is(equalTo(identifier2)));
		LOGGER.info("Asset1 Identifier: " + asset1.getIdentifier());
		LOGGER.info("Asset2 Identifier: " + asset2.getIdentifier());
		LOGGER.info("Asset3 Identifier: " + asset3.getIdentifier());
		LOGGER.info("Asset4 Identifier: " + asset4.getIdentifier());
	}

	@Test
	public void testGetName() {
		assertObjectsExist();
		assertThat(asset1.getName(), is(equalTo(name1)));
		assertThat(asset2.getName(), is(equalTo(name1)));
		assertThat(asset3.getName(), is(equalTo(name2)));
		assertThat(asset4.getName(), is(equalTo(name2)));
		LOGGER.info("Asset1 name: " + asset1.getName());
		LOGGER.info("Asset2 name: " + asset2.getName());
		LOGGER.info("Asset3 name: " + asset3.getName());
		LOGGER.info("Asset4 name: " + asset4.getName());
	}

	@Test
	public void testGetPrice() {
		assertObjectsExist();
		assertThat(asset1.getPrice(), is(equalTo(BigDecimal.valueOf(1))));
		assertThat(asset2.getPrice(), is(equalTo(BigDecimal.valueOf(1))));
		assertThat(asset3.getPrice(), is(equalTo(BigDecimal.valueOf(10))));
		assertThat(asset4.getPrice(), is(equalTo(BigDecimal.valueOf(10))));
		LOGGER.info("Asset1 price: " + asset1.getPrice());
		LOGGER.info("Asset2 price: " + asset2.getPrice());
		LOGGER.info("Asset3 price: " + asset3.getPrice());
		LOGGER.info("Asset4 price: " + asset4.getPrice());
	}

	@Test
	public void testGetQuantity() {
		assertObjectsExist();
		assertThat(asset1.getQuantity(), is(equalTo(BigDecimal.valueOf(1))));
		assertThat(asset2.getQuantity(), is(equalTo(BigDecimal.valueOf(1))));
		assertThat(asset3.getQuantity(), is(equalTo(BigDecimal.valueOf(1))));
		assertThat(asset4.getQuantity(), is(equalTo(BigDecimal.valueOf(10))));
		LOGGER.info("Asset1 quantity: " + asset1.getQuantity());
		LOGGER.info("Asset2 quantity: " + asset2.getQuantity());
		LOGGER.info("Asset3 quantity: " + asset3.getQuantity());
		LOGGER.info("Asset4 quantity: " + asset4.getQuantity());
	}

	@Test
	public void testGetValue() {
		assertObjectsExist();
		assertThat(asset1.getValue(), is(equalTo(BigDecimal.valueOf(1))));
		assertThat(asset2.getValue(), is(equalTo(BigDecimal.valueOf(1))));
		assertThat(asset3.getValue(), is(equalTo(BigDecimal.valueOf(10))));
		assertThat(asset4.getValue(), is(equalTo(BigDecimal.valueOf(100))));
		LOGGER.info("Asset1 value: " + asset1.getValue());
		LOGGER.info("Asset2 value: " + asset2.getValue());
		LOGGER.info("Asset3 value: " + asset3.getValue());
		LOGGER.info("Asset4 value: " + asset4.getValue());
	}

	@Test
	public void testCompareTo() {
		assertObjectsExist();
		assertThat(asset1.compareTo(asset2), is(equalTo(0)));
		assertThat(asset2.compareTo(asset1), is(equalTo(0)));
		assertThat(asset1.compareTo(asset3), is(equalTo(-1)));
		assertThat(asset3.compareTo(asset1), is(equalTo(1)));
		assertThat(asset1.compareTo(asset4), is(equalTo(-1)));
		assertThat(asset4.compareTo(asset1), is(equalTo(1)));
		assertThat(asset2.compareTo(asset3), is(equalTo(-1)));
		assertThat(asset3.compareTo(asset2), is(equalTo(1)));
		assertThat(asset2.compareTo(asset4), is(equalTo(-1)));
		assertThat(asset4.compareTo(asset2), is(equalTo(1)));
		assertThat(asset3.compareTo(asset4), is(equalTo(0)));
		LOGGER.info("Asset1 compare to Asset2: " + asset1.compareTo(asset2));
		LOGGER.info("Asset2 compare to Asset1: " + asset2.compareTo(asset1));
		LOGGER.info("Asset1 compare to Asset3: " + asset1.compareTo(asset3));
		LOGGER.info("Asset1 compare to Asset4: " + asset1.compareTo(asset4));
		LOGGER.info("Asset2 compare to Asset3: " + asset2.compareTo(asset3));
		LOGGER.info("Asset2 compare to Asset4: " + asset2.compareTo(asset3));
		LOGGER.info("Asset3 compare to Asset4: " + asset3.compareTo(asset4));
	}

	@Test
	public void testEqualsObject() {
		assertObjectsExist();
		assertTrue(asset1.equals(asset2));
		assertTrue(asset2.equals(asset1));
		assertTrue(!asset1.equals(asset3));
		assertTrue(!asset1.equals(asset4));
		assertTrue(!asset2.equals(asset3));
		assertTrue(!asset2.equals(asset4));
		assertTrue(!asset3.equals(asset4));
		LOGGER.info("Asset1 equals Asset2: " + asset1.equals(asset2));
		LOGGER.info("Asset2 equals Asset1: " + asset2.equals(asset1));
		LOGGER.info("Asset1 not equals Asset3: " + !asset1.equals(asset3));
		LOGGER.info("Asset1 not equals Asset4: " + !asset1.equals(asset4));
		LOGGER.info("Asset2 not equals Asset3: " + !asset2.equals(asset3));
		LOGGER.info("Asset2 not equals Asset4: " + !asset2.equals(asset4));
		LOGGER.info("Asset3 not equals Asset4: " + !asset3.equals(asset4));
	}

	@Test
	public void testToString() {
		assertObjectsExist();
		LOGGER.info("Asset1: " + asset1.toString());
		LOGGER.info("Asset2: " + asset2.toString());
		LOGGER.info("Asset3: " + asset3.toString());
		LOGGER.info("Asset4: " + asset4.toString());
	}

	private void assertObjectsExist() {
		assertNotNull(asset1);
		assertNotNull(asset2);
		assertNotNull(asset3);
		assertNotNull(asset4);
		assertNotNull(LOGGER);
	}

}
