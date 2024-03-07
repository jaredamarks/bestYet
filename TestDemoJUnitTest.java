package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;
	
	@BeforeEach
	public void setUp() throws Exception {
		testDemo = new TestDemo(); // Create TestDemo object before each test
	}
	@Test
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	private void assertThatTwoPositivieNumbersAreAddedCorrectly(int a, int b, int expected, 
			boolean expectException) {
		if(!expectException) {
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
				 assertThatThrownBy(() -> testDemo.addPositive(a, b))
	                .isInstanceOf(IllegalArgumentException.class);
		}
	}
	@Test
	private void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		TestDemo testDemo = TestDemo();
		
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(9, 60)).isEqualTo(69);
	}
	private TestDemo TestDemo() {
				return null;
	}
	@Test
	private void addNumbers() {
		TestDemo testDemo = new TestDemo();
		int result = testDemo.addNumbers(6, 9);
		assertThat(result).isEqualTo(15);
	}
	@Test
    void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();
        int fiveSquared = mockDemo.randomNumberSquared();
        assertThat(fiveSquared).isEqualTo(25);
    }
	@Test
	private int anyMethod(int i) { // anyMethod returns a single variable
		testDemo = new TestDemo();
		i = anyMethod(5);
		return i;
				
	}
	public static Stream<Arguments> addPositive() {
		return Stream.of(
				Arguments.arguments(2, 4, 6, false),
				Arguments.arguments(5, 3, 8, false),
				Arguments.arguments(10, 15, 25, false),
				
				Arguments.arguments(0, 5, 0, true),
				Arguments.arguments(2, 0, 0, true),
				Arguments.arguments(-2, 0, 0, true));
	}	
	}

