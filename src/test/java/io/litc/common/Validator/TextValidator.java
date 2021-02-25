package io.litc.common.Validator;

import java.util.HashMap;
import java.util.Map;

public class TextValidator {

	private Map<String, String> originalValue = new HashMap<String, String>();
	private Map<String, String> cartValue = new HashMap<String, String>();

	public void setOriginalValue(Map<String, String> map) {
		this.originalValue = map;
	}

	public Map<String, String> getoriginalValue() {
		return this.originalValue;
	}
	
	public void setCartValue(Map<String, String> map) {
		this.cartValue = map;
	}

	public Map<String, String> getCartValue() {
		return this.cartValue;
	}
}
