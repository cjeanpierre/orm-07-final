package com.puthisastra.first;

public class MultipleUtil {

	public boolean isMultipleOf3Or5(int value) {
		if ((value % 3) == 0 || (value % 5) == 0) {
			return true;
		}
		return false;
	}
	
}
