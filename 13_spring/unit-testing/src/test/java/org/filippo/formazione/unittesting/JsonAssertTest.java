package org.filippo.formazione.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {
	
	String controllerResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":3,\"quantity\":7}";
	@Test
	void JsonAssertStrictTrueTest() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":3,\"quantity\":7}";
		//Il terzo parametro è lo strict control => quindi gli oggetti devono essere identici
		JSONAssert.assertEquals(expectedResponse, controllerResponse, true);
	}
	
	@Test
	void JsonAssertStrictFalseTest() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":3}";
		//Il terzo parametro è lo strict control => quindi gli oggetti devono matchare i valori
		JSONAssert.assertEquals(expectedResponse, controllerResponse, false);
	}

}
