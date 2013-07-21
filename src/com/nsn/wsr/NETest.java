package com.nsn.wsr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NETest {

	@Test
	public void testUpgradeSucc1() {
		Boolean successful = Boolean.TRUE;
		NE ne = new NE(null);
		String version = "1.0";
		String newVersion = "2.0";
		ne.setSwVersion(version);
		Boolean isUpgradeSuccessful = ne.upgradeSwVersion(newVersion);
		assertEquals("Upgrade must be Successful!", successful, isUpgradeSuccessful);
	}
	
	@Test
	public void testUpgradeSucc2() {
		Boolean successful = Boolean.TRUE;
		NE ne = new NE(null);
		ne.setSwVersion("1.1.1");
		Boolean isUpgradeSuccessful = ne.upgradeSwVersion("1.2");
		assertEquals("Upgrade must be Successful!", successful, isUpgradeSuccessful);
	}

	@Test
	public void testUpgradeSucc3() {
		Boolean successful = Boolean.TRUE;
		NE ne = new NE(null);
		ne.setSwVersion("1.1.1");
		Boolean isUpgradeSuccessful = ne.upgradeSwVersion("2.0");
		assertEquals("Upgrade must be Successful!", successful, isUpgradeSuccessful);
	}
	
	@Test
	public void testUpgradeSucc4() {
		Boolean successful = Boolean.TRUE;
		NE ne = new NE(null);
		ne.setSwVersion("");
		Boolean isUpgradeSuccessful = ne.upgradeSwVersion("1.0");
		assertEquals("Upgrade must be Successful!", successful, isUpgradeSuccessful);
	}
	
	@Test
	public void testUpgradeFail1() {
		Boolean failed = Boolean.FALSE;
		NE ne = new NE(null);
		ne.setSwVersion("2.1.2");
		Boolean isUpgradeSuccessful = ne.upgradeSwVersion("2.0.3");
		assertEquals("Upgrade should have failed!", failed, isUpgradeSuccessful);
	}
	
	@Test
	public void testUpgradeFail2() {
		Boolean failed = Boolean.FALSE;
		NE ne = new NE(null);
		ne.setSwVersion("2.1.2");
		Boolean isUpgradeSuccessful = ne.upgradeSwVersion("2.1");
		assertEquals("Upgrade should have failed!", failed, isUpgradeSuccessful);
	}
}