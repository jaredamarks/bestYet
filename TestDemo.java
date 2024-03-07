package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
	}
	public int anyMethod(int z) {
		return z;
}
	public int addNumbers(int i, int j) {
		return i + j;
	}
	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}