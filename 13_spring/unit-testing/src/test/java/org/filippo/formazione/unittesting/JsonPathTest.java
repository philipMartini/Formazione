package org.filippo.formazione.unittesting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

class JsonPathTest {

	@Test
	void test() {
		String responseFromService = "["
				+ "{\"id\": 1000, \"name\":\"Pencil\", \"quantity\":5},"
				+ "{\"id\": 1001, \"name\":\"Eraser\", \"quantity\":7},"
				+ "{\"id\": 1002, \"name\":\"Pen\", \"quantity\":13}"
				+ "]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		
		int length = context.read("$.length()"); //Dammi il root element
		assertThat(length).isEqualTo(3);
		
		//Dammi tutti gli ids
				List<Integer> ids = context.read("$..id");
				System.out.println(ids.toString());
				assertThat(ids).containsExactly(1000, 1001, 1002);
				
				//Dammi il primo elemento
				System.out.println(context.read("$.[1]").toString());
				//Posso anche definire delle condizioni
				System.out.println(context.read("$.[@.name == 'Eraser']").toString());
		
	}

}
