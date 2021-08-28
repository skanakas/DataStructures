package com.srk.idgenerator;

import java.security.SecureRandom;
import java.util.Random;

public class VoucherCodes {
	private static final Random RND = new SecureRandom();

	/**
	 * Generates a random code according to given config. 
	 * 
	 * @param config
	 * 
	 * @return Generated code.
	 */
	public static String generate(CodeConfig config) {
		StringBuilder sb = new StringBuilder();
		char[] chars = config.getCharset().toCharArray();
		char[] pattern = config.getPattern().toCharArray();

		if (config.getPrefix() != null) {
			sb.append(config.getPrefix());    
		}

		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == CodeConfig.PATTERN_PLACEHOLDER) {
				sb.append(chars[RND.nextInt(chars.length)]);
			} else {
				sb.append(pattern[i]);
			}
		}

		if (config.getPostfix() != null) {
			sb.append(config.getPostfix());    
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		CodeConfig config = new CodeConfig(10, null, "SRK", null, null);
		System.out.println(generate(config));
		
		Random rn = new SecureRandom();
		System.out.println(rn.nextInt(10));
	}
}
