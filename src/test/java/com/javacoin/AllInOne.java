package com.javacoin;

import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.javacoin.model.Block;
import com.javacoin.model.GetInfo;
import com.javacoin.model.MiningInfo;
import com.javacoin.model.PeerInfo;
import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;


@FixMethodOrder(MethodSorters.DEFAULT)
public class AllInOne {

	private JavacoinRpc javacoinRpc = new JavacoinRpcImpl("phoenix1", "java1", "localhost", 26302);

	
	@Test
	public void testGetInfo() {
		GetInfo result = javacoinRpc.getInfo();
		assertEquals(new BigDecimal("0E-8"), result.getBalance());
		assertEquals("", result.getErrors());
	}

	@Test
	public void testGetAccountAddress() {
		String result = javacoinRpc.getAccountAddress("");
		assertThat(result, startsWith("J"));

	}

	@Test
	public void testGetAddressesByAccount() {

		String account = UUID.randomUUID().toString();

		String address1 = javacoinRpc.getNewAddress(account);
		String address2 = javacoinRpc.getNewAddress(account);

		List<String> result = javacoinRpc.getAddressesByAccount(account);

		assertEquals(2, result.size());
		assertTrue(result.contains(address1));
		assertTrue(result.contains(address2));
	}

	@Test
	public void testBalance() {
		BigDecimal result = javacoinRpc.getBalance();
		assertEquals(new BigDecimal("0E-8"), result);
	}

	@Test
	public void testGetBlock() {
		String blockHash = "f53ce360cdcb4a1ad539c7431bf94f6d1cd24a3722df738b7e1fdad83b2ff105";
		Block result = javacoinRpc.getBlock(blockHash);
		assertEquals(blockHash, result.getHash());
		assertEquals(5000, result.getHeight());
	}

	@Test
	public void testBlockCount() {
		int result = javacoinRpc.getBlockCount();
		assertTrue(result > 1500000);

	}

	@Test
	public void testBlockHash() {
		String result = javacoinRpc.getBlockHash(5000);
		assertEquals("f53ce360cdcb4a1ad539c7431bf94f6d1cd24a3722df738b7e1fdad83b2ff105", result);

	}

	@Test
	public void testDifficulty() {
		BigDecimal result = javacoinRpc.getDifficulty();
		assertTrue(result.doubleValue() > 0.0);

	}
	

	@Test
	public void testMiningInfo() {
		MiningInfo result = javacoinRpc.getMiningInfo();
		assertTrue(result.getBlocks() > 1500000);
	}
	
	
	@Test
	public void testGetNwetworkHashps() {
		BigInteger result = javacoinRpc.getNetworkHashps();
		assertTrue(result.intValue() > 0);

	}
	

	@Test
	public void testGetNewAddress() {
		String result = javacoinRpc.getNewAddress();
		assertThat(result, startsWith("J"));
		assertTrue(result.length() > 10);
	}
	

	@Test
	public void testGetPeerInfo() {
		List<PeerInfo> result = javacoinRpc.getPeerInfo();
		assertTrue(result.size() > 0);
	}
	
	@Test
	public void testhelp() {
		List<String> result = javacoinRpc.help();
		assertTrue(result.size() == 59);
	}
	
	@Test
	public void testListAccounts() {
		Map<String,BigDecimal> result = javacoinRpc.listAccounts();
		assertTrue(result.size() > 0);
	}	
	
	@Test
	public void testValidateAddress() {
		boolean result = javacoinRpc.validateAddress("JcYpxnXzd929ds6utyP2kmBb945yRqWUsn");
		assertEquals(result,true);

	}


}
