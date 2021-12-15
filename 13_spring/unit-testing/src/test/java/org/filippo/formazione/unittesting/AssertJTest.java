package org.filippo.formazione.unittesting;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;

class AssertJTest {

	@Test
	void test() {
		List<Integer> numbers = Arrays.asList(12,15,13);
		assertThat(numbers).hasSize(3)
							.contains(12)
							.allMatch((x) -> x > 10);
	}

}
