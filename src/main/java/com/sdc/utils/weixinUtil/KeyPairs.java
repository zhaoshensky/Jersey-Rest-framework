package com.sdc.utils.weixinUtil;

import java.util.List;

public class KeyPairs {

	private String key;
	private String value;
	private List<KeyPairs> keyPairs;

	public KeyPairs(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public List<KeyPairs> getKeyPairs() {
		return keyPairs;
	}

	public void setKeyPairs(List<KeyPairs> keyPairs) {
		this.keyPairs = keyPairs;
	}

	
}
