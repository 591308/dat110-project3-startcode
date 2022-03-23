package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		try {
			
			// we use MD5 with 128 bits digest
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			// compute the hash of the input 'entity'
			byte[] digest = md.digest(entity.getBytes());
			
			// convert the hash into hex format
			String hashValue = toHex(digest);
			
			// convert the hex into BigInteger
			hashint = new BigInteger(hashValue, 16);
			
		} catch (NoSuchAlgorithmException e) {	e.printStackTrace();}
		
		// return the BigInteger
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		int digestLength = 0;
		// Task: compute the address size of MD5
		
		// get the digest length
		
		try {
			digestLength = MessageDigest.getInstance("MD5").getDigestLength();
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		// compute the number of bits = digest length * 8
		BigInteger StorInteger = new BigInteger("2");
		int BigBits = digestLength *8;
		
		// compute the address size = 2 ^ number of bits
		BigInteger addSize = StorInteger.pow(BigBits);
		// return the address size
		
		return addSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		try {
			
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
