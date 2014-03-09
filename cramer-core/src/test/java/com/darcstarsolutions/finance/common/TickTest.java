package com.darcstarsolutions.finance.common;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.joda.time.Instant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TickTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TickTest.class);

	private Tick tick1, tick2, tick3;
	private BigInteger marketId1;
	private BigInteger marketId2;
	private Instant timestamp1;
	private Instant timestamp2;
	private BigInteger assetId1;
	private BigInteger assetId2;
	private BigDecimal assetPrice1;
	private BigDecimal assetPrice2;

	@Before
	public void setUp() throws Exception {
		marketId1 = BigInteger.ZERO;
		marketId2 = BigInteger.ONE;
		timestamp1 = Instant.now();
		timestamp2 = Instant.now();
		assetId1 = BigInteger.ZERO;
		assetId2 = BigInteger.ONE;
		assetPrice1 = BigDecimal.ONE;
		assetPrice2 = BigDecimal.TEN;
		tick1 = new Tick(marketId1, timestamp1, assetId1, assetPrice1);
		tick2 = new Tick(marketId1, timestamp1, assetId1, assetPrice1);
		tick3 = new Tick(marketId2, timestamp2, assetId2, assetPrice2);
	}

	@After
	public void tearDown() throws Exception {
		tick1 = null;
		tick2 = null;
		tick3 = null;
		marketId1 = null;
		marketId2 = null;
		timestamp1 = null;
		timestamp2 = null;
		assetId1 = null;
		assetId2 = null;
		assetPrice1 = null;
		assetPrice2 = null;
	}

	@Test
	public void testHashCode() {
		assertObjectExistence();
		assertEquals(tick1.hashCode(), tick2.hashCode());
		assertNotEquals(tick2.hashCode(), tick3.hashCode());
		assertNotEquals(tick1.hashCode(), tick3.hashCode());
		LOGGER.info("Tick1: " + tick1.hashCode());
		LOGGER.info("Tick2: " + tick2.hashCode());
		LOGGER.info("Tick3: " + tick3.hashCode());
	}

	@Test
	public void testGetId() {
		assertObjectExistence();
		assertNotEquals(tick1.getId(), tick2.getId());
		assertNotEquals(tick2.getId(), tick3.getId());
		assertNotEquals(tick1.getId(), tick3.getId());
		LOGGER.info("Tick1: " + tick1.getId().toString());
		LOGGER.info("Tick2: " + tick2.getId().toString());
		LOGGER.info("Tick3: " + tick3.getId().toString());
	}

	@Test
	public void testGetTimestamp() {
		assertObjectExistence();
		Instant now = Instant.now().plus(1);
		assertNotNull(now);
		assertTrue(tick1.getTimestamp().isBefore(now.getMillis()));
		assertTrue(tick2.getTimestamp().isBefore(now.getMillis()));
		assertTrue(tick3.getTimestamp().isBefore(now.getMillis()));
		LOGGER.info("Now: " + now.toString());
		LOGGER.info("Tick1: " + tick1.getTimestamp().toString());
		LOGGER.info("Tick2: " + tick2.getTimestamp().toString());
		LOGGER.info("Tick3: " + tick3.getTimestamp().toString());
	}

	@Test
	public void testGetMarketId() {
		assertObjectExistence();
		assertEquals(tick1.getMarketId(), tick2.getMarketId());
		assertNotEquals(tick2.getMarketId(), tick3.getMarketId());
		assertNotEquals(tick1.getMarketId(), tick3.getMarketId());
		LOGGER.info("Tick1: " + tick1.getMarketId().toString());
		LOGGER.info("Tick2: " + tick2.getMarketId().toString());
		LOGGER.info("Tick3: " + tick3.getMarketId().toString());
	}

	@Test
	public void testGetAssetId() {
		assertObjectExistence();
		assertEquals(tick1.getAssetId(), tick2.getAssetId());
		assertNotEquals(tick2.getAssetId(), tick3.getAssetId());
		assertNotEquals(tick1.getAssetId(), tick3.getAssetId());
		LOGGER.info("Tick1: " + tick1.getAssetId().toString());
		LOGGER.info("Tick2: " + tick2.getAssetId().toString());
		LOGGER.info("Tick3: " + tick3.getAssetId().toString());
	}

	@Test
	public void testGetAssetPrice() {
		assertObjectExistence();
		assertEquals(tick1.getAssetPrice(), tick2.getAssetPrice());
		assertEquals(tick1.getAssetPrice(), BigDecimal.ONE);
		assertNotEquals(tick2.getAssetPrice(), tick3.getAssetPrice());
		assertEquals(tick3.getAssetPrice(), BigDecimal.TEN);
		LOGGER.info("Tick1: " + tick1.getAssetPrice().toString());
		LOGGER.info("Tick2: " + tick2.getAssetPrice().toString());
		LOGGER.info("Tick3: " + tick3.getAssetPrice().toString());
	}

	@Test
	public void testEqualsObject() {
		assertObjectExistence();
		assertEquals(tick1, tick2);
		assertNotEquals(tick2, tick3);
		assertNotEquals(tick1, tick3);
		LOGGER.info("Tick1: " + tick1.toString());
		LOGGER.info("Tick2: " + tick2.toString());
		LOGGER.info("Tick3: " + tick3.toString());
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
		LOGGER.info("Tick1, Tick2: " + tick1.compareTo(tick2));
		LOGGER.info("Tick1, Tick3: " + tick1.compareTo(tick3));
		LOGGER.info("Tick3, Tick2: " + tick3.compareTo(tick2));
	}

	@Test
	public void testToString() {
		assertObjectExistence();
		LOGGER.info(tick1.toString());
		LOGGER.info(tick2.toString());
		LOGGER.info(tick3.toString());
	}

	private void assertObjectExistence() {
		assertNotNull(tick1);
		assertNotNull(tick2);
		assertNotNull(tick3);
	}

}
