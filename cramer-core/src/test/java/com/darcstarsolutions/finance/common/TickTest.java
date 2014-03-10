package com.darcstarsolutions.finance.common;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.easymock.EasyMock;
import org.joda.time.Instant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TickTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TickTest.class);

	private Tick tick1, tick2, tick3, tick4, tick5;
	private BigInteger marketId1;
	private BigInteger marketId2;
	private Instant timestamp1;
	private Instant timestamp2;
	private BigInteger assetId1;
	private BigInteger assetId2;
	private BigDecimal assetPrice1;
	private BigDecimal assetPrice2;
	private BigDecimal assetQuantity1;
	private BigDecimal assetQuantity2;
	private Asset mockAsset;

	@Before
	public void setUp() throws Exception {
		marketId1 = BigInteger.ZERO;
		marketId2 = BigInteger.ONE;
		timestamp1 = Instant.now();
		timestamp2 = Instant.now().plus(1);
		assetId1 = BigInteger.ZERO;
		assetId2 = BigInteger.ONE;
		assetPrice1 = BigDecimal.ONE;
		assetPrice2 = BigDecimal.TEN;
		assetQuantity1 = BigDecimal.TEN;
		assetQuantity2 = BigDecimal.valueOf(20);
		tick1 = new Tick(marketId1, timestamp1, assetId1, assetPrice1);
		tick2 = new Tick(marketId1, timestamp1, assetId1, assetPrice1);
		tick3 = new Tick(marketId2, timestamp2, assetId2, assetPrice2);
		tick4 = new Tick(marketId2, timestamp2, assetId2, assetPrice2,
				assetQuantity1);
		tick5 = new Tick(marketId2, timestamp2, assetId2, assetPrice2,
				assetQuantity2);
		mockAsset = setupMockAsset();
	}

	private Asset setupMockAsset() {
		Asset asset = EasyMock.createMock(Asset.class);
		EasyMock.expect(asset.getId()).andReturn(BigInteger.TEN);
		EasyMock.expect(asset.getPrice()).andReturn(BigDecimal.TEN);
		EasyMock.expect(asset.getQuantity()).andReturn(BigDecimal.valueOf(20));
		return asset;

	}

	@After
	public void tearDown() throws Exception {
		tick1 = null;
		tick2 = null;
		tick3 = null;
		tick4 = null;
		tick5 = null;
		marketId1 = null;
		marketId2 = null;
		timestamp1 = null;
		timestamp2 = null;
		assetId1 = null;
		assetId2 = null;
		assetPrice1 = null;
		assetPrice2 = null;
		assetQuantity1 = null;
		assetQuantity2 = null;
		mockAsset = null;
	}

	@Test
	public void testTickAsset() {
		EasyMock.replay(mockAsset);
		Tick tick = new Tick(marketId1, timestamp1, mockAsset);
		assertNotNull(tick);
		assertEquals(marketId1, tick.getMarketId());
		assertEquals(timestamp1, tick.getTimestamp());
		assertEquals(BigInteger.TEN, tick.getAssetId());
		assertEquals(BigDecimal.TEN, tick.getAssetPrice());
		assertEquals(BigDecimal.valueOf(20), tick.getAssetQuantity());
		LOGGER.info("Tick: " + tick);
	}

	@Test
	public void testHashCode() {
		assertObjectExistence();
		assertEquals(tick1.hashCode(), tick2.hashCode());
		assertNotEquals(tick1.hashCode(), tick3.hashCode());
		assertNotEquals(tick1.hashCode(), tick4.hashCode());
		assertNotEquals(tick1.hashCode(), tick5.hashCode());
		assertNotEquals(tick2.hashCode(), tick3.hashCode());
		assertNotEquals(tick2.hashCode(), tick4.hashCode());
		assertNotEquals(tick2.hashCode(), tick5.hashCode());
		assertNotEquals(tick3.hashCode(), tick4.hashCode());
		assertNotEquals(tick3.hashCode(), tick5.hashCode());
		assertNotEquals(tick4.hashCode(), tick5.hashCode());
		LOGGER.info("Tick1 Hashcode: " + tick1.hashCode());
		LOGGER.info("Tick2 Hashcode: " + tick2.hashCode());
		LOGGER.info("Tick3 Hashcode: " + tick3.hashCode());
		LOGGER.info("Tick4 Hashcode: " + tick4.hashCode());
		LOGGER.info("Tick5 Hashcode: " + tick5.hashCode());
	}

	@Test
	public void testGetId() {
		assertObjectExistence();
		assertNotEquals(tick1.getId(), tick2.getId());
		assertNotEquals(tick1.getId(), tick3.getId());
		assertNotEquals(tick1.getId(), tick4.getId());
		assertNotEquals(tick1.getId(), tick5.getId());
		assertNotEquals(tick2.getId(), tick3.getId());
		assertNotEquals(tick2.getId(), tick4.getId());
		assertNotEquals(tick2.getId(), tick5.getId());
		assertNotEquals(tick3.getId(), tick4.getId());
		assertNotEquals(tick3.getId(), tick5.getId());
		assertNotEquals(tick4.getId(), tick5.getId());
		LOGGER.info("Tick1 Id: " + tick1.getId().toString());
		LOGGER.info("Tick2 Id: " + tick2.getId().toString());
		LOGGER.info("Tick3 Id: " + tick3.getId().toString());
		LOGGER.info("Tick4 Id: " + tick4.getId().toString());
		LOGGER.info("Tick5 Id: " + tick5.getId().toString());
	}

	@Test
	public void testGetTimestamp() {
		assertObjectExistence();
		Instant now = Instant.now().plus(10);
		assertNotNull(now);
		assertTrue(tick1.getTimestamp().isBefore(now));
		assertTrue(tick2.getTimestamp().isBefore(now));
		assertTrue(tick1.getTimestamp().isEqual(tick2.getTimestamp()));
		assertTrue(tick2.getTimestamp().isBefore(tick3.getTimestamp()));
		assertTrue(tick3.getTimestamp().isBefore(now));
		assertTrue(tick4.getTimestamp().isBefore(now));
		assertTrue(tick5.getTimestamp().isBefore(now));
		LOGGER.info("Now: " + now.toString());
		LOGGER.info("Tick1 Timestamp: " + tick1.getTimestamp().toString());
		LOGGER.info("Tick2 Timestamp: " + tick2.getTimestamp().toString());
		LOGGER.info("Tick3 Timestamp: " + tick3.getTimestamp().toString());
		LOGGER.info("Tick4 Timestamp: " + tick4.getTimestamp().toString());
		LOGGER.info("Tick5 Timestamp: " + tick5.getTimestamp().toString());
	}

	@Test
	public void testGetMarketId() {
		assertObjectExistence();
		assertEquals(tick1.getMarketId(), tick2.getMarketId());
		assertNotEquals(tick2.getMarketId(), tick3.getMarketId());
		assertNotEquals(tick1.getMarketId(), tick3.getMarketId());
		assertNotEquals(tick2.getMarketId(), tick5.getMarketId());
		assertEquals(tick3.getMarketId(), tick4.getMarketId());
		assertEquals(tick3.getMarketId(), tick5.getMarketId());
		LOGGER.info("Tick1 Market Id: " + tick1.getMarketId().toString());
		LOGGER.info("Tick2 Market Id: " + tick2.getMarketId().toString());
		LOGGER.info("Tick3 Market Id: " + tick3.getMarketId().toString());
		LOGGER.info("Tick4 Market Id: " + tick4.getMarketId().toString());
		LOGGER.info("Tick5 Market Id: " + tick5.getMarketId().toString());
	}

	@Test
	public void testGetAssetId() {
		assertObjectExistence();
		assertEquals(tick1.getAssetId(), tick2.getAssetId());
		assertNotEquals(tick2.getAssetId(), tick3.getAssetId());
		assertNotEquals(tick1.getAssetId(), tick3.getAssetId());
		assertEquals(tick3.getAssetId(), tick4.getAssetId());
		assertEquals(tick3.getAssetId(), tick5.getAssetId());
		assertEquals(tick4.getAssetId(), tick5.getAssetId());
		LOGGER.info("Tick1 Asset Id: " + tick1.getAssetId().toString());
		LOGGER.info("Tick2 Asset Id: " + tick2.getAssetId().toString());
		LOGGER.info("Tick3 Asset Id: " + tick3.getAssetId().toString());
		LOGGER.info("Tick4 Asset Id: " + tick4.getAssetId().toString());
		LOGGER.info("Tick5 Asset Id: " + tick5.getAssetId().toString());
	}

	@Test
	public void testGetAssetPrice() {
		assertObjectExistence();
		assertEquals(tick1.getAssetPrice(), tick2.getAssetPrice());
		assertEquals(tick1.getAssetPrice(), BigDecimal.ONE);
		assertNotEquals(tick2.getAssetPrice(), tick3.getAssetPrice());
		assertEquals(tick3.getAssetPrice(), BigDecimal.TEN);
		assertEquals(tick3.getAssetPrice(), tick4.getAssetPrice());
		assertEquals(tick3.getAssetPrice(), tick5.getAssetPrice());
		LOGGER.info("Tick1 Asset Price: " + tick1.getAssetPrice().toString());
		LOGGER.info("Tick2 Asset Price: " + tick2.getAssetPrice().toString());
		LOGGER.info("Tick3 Asset Price: " + tick3.getAssetPrice().toString());
		LOGGER.info("Tick4 Asset Price: " + tick4.getAssetPrice().toString());
		LOGGER.info("Tick5 Asset Price: " + tick5.getAssetPrice().toString());
	}

	@Test
	public void testGetAssetQuantity() {
		assertObjectExistence();
		assertEquals(tick1.getAssetQuantity(), tick2.getAssetQuantity());
		assertEquals(tick1.getAssetQuantity(), BigDecimal.ONE);
		assertEquals(tick2.getAssetQuantity(), tick3.getAssetQuantity());
		assertEquals(tick4.getAssetQuantity(), BigDecimal.TEN);
		assertEquals(tick5.getAssetQuantity(), BigDecimal.valueOf(20));
		LOGGER.info("Tick1 Asset Quantity: "
				+ tick1.getAssetQuantity().toString());
		LOGGER.info("Tick2 Asset Quantity: "
				+ tick2.getAssetQuantity().toString());
		LOGGER.info("Tick3 Asset Quantity: "
				+ tick3.getAssetQuantity().toString());
		LOGGER.info("Tick4 Asset Quantity: "
				+ tick4.getAssetQuantity().toString());
		LOGGER.info("Tick5 Asset Quantity: "
				+ tick5.getAssetQuantity().toString());
	}

	@Test
	public void testGetAssetValue() {
		assertObjectExistence();
		assertEquals(tick1.getAssetValue(), tick2.getAssetValue());
		assertEquals(tick1.getAssetValue(), BigDecimal.ONE);
		assertEquals(tick3.getAssetValue(), BigDecimal.TEN);
		assertEquals(tick4.getAssetValue(), BigDecimal.valueOf(100));
		assertEquals(tick5.getAssetValue(), BigDecimal.valueOf(200));
		LOGGER.info("Tick1 Asset Value: " + tick1.getAssetValue().toString());
		LOGGER.info("Tick2 Asset Value: " + tick2.getAssetValue().toString());
		LOGGER.info("Tick3 Asset Value: " + tick3.getAssetValue().toString());
		LOGGER.info("Tick4 Asset Value: " + tick4.getAssetValue().toString());
		LOGGER.info("Tick5 Asset Value: " + tick5.getAssetValue().toString());
	}

	@Test
	public void testEqualsObject() {
		assertObjectExistence();
		assertEquals(tick1, tick2);
		assertNotEquals(tick1, tick3);
		assertNotEquals(tick1, tick4);
		assertNotEquals(tick1, tick5);
		assertNotEquals(tick2, tick3);
		assertNotEquals(tick2, tick4);
		assertNotEquals(tick2, tick5);
		assertNotEquals(tick3, tick4);
		assertNotEquals(tick3, tick5);
		assertNotEquals(tick4, tick5);
		LOGGER.info("Tick1: " + tick1.toString());
		LOGGER.info("Tick2: " + tick2.toString());
		LOGGER.info("Tick3: " + tick3.toString());
		LOGGER.info("Tick4: " + tick4.toString());
		LOGGER.info("Tick5: " + tick5.toString());
	}

	@Test
	public void testIsBefore() {
		assertObjectExistence();
		assertEquals(tick1.getTimestamp(), tick2.getTimestamp());
		assertFalse(tick1.isBefore(tick2));
		assertFalse(tick2.isBefore(tick1));
		assertTrue(tick1.isBefore(tick3));
		assertTrue(tick2.isBefore(tick3));
		assertFalse(tick3.isBefore(tick1));
		assertFalse(tick3.isBefore(tick2));
		LOGGER.info("Tick1 is before Tick2: " + tick1.isBefore(tick2));
		LOGGER.info("Tick1 is before Tick3: " + tick1.isBefore(tick3));
		LOGGER.info("Tick3 is before Tick2: " + tick3.isBefore(tick2));
	}

	@Test
	public void testIsAfter() {
		assertObjectExistence();
		assertEquals(tick1.getTimestamp(), tick2.getTimestamp());
		assertFalse(tick1.isAfter(tick2));
		assertFalse(tick2.isAfter(tick1));
		assertTrue(tick3.isAfter(tick1));
		assertTrue(tick3.isAfter(tick2));
		assertFalse(tick1.isAfter(tick3));
		assertFalse(tick2.isAfter(tick3));
		LOGGER.info("Tick1 is after Tick2: " + tick1.isAfter(tick2));
		LOGGER.info("Tick1 is after Tick3: " + tick1.isAfter(tick3));
		LOGGER.info("Tick3 is after Tick2: " + tick3.isAfter(tick2));
	}

	@Test
	public void testCompareTo() {
		assertObjectExistence();
		assertEquals(tick1, tick2);
		assertNotEquals(tick2, tick3);
		assertNotEquals(tick1, tick3);
		assertThat(tick1.compareTo(tick2), is(equalTo(0)));
		assertThat(tick1.compareTo(tick3) < 0, is(true));
		assertThat(tick3.compareTo(tick2) > 0, is(true));
		LOGGER.info("Tick1 compare to Tick2: " + tick1.compareTo(tick2));
		LOGGER.info("Tick1 compare to Tick3: " + tick1.compareTo(tick3));
		LOGGER.info("Tick3 compare to Tick2: " + tick3.compareTo(tick2));
	}

	@Test
	public void testToString() {
		assertObjectExistence();
		LOGGER.info("Tick1: " + tick1.toString());
		LOGGER.info("Tick2: " + tick2.toString());
		LOGGER.info("Tick3: " + tick3.toString());
		LOGGER.info("Tick4: " + tick4.toString());
		LOGGER.info("Tick5: " + tick5.toString());
	}

	private void assertObjectExistence() {
		assertNotNull(tick1);
		assertNotNull(tick2);
		assertNotNull(tick3);
		assertNotNull(tick4);
		assertNotNull(tick5);
	}

}
