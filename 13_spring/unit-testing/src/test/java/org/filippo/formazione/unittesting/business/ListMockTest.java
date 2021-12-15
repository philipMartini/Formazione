package org.filippo.formazione.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ListMockTest {
	
	List mock = mock(List.class);

	@Test
	void sizeBasicTest() {
		
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	void sizeReturnDifferentValuesTest() {
		
		//Alla prima chiamata restituisci 5 e alla seconda 7
		when(mock.size()).thenReturn(5).thenReturn(7);
		assertEquals(5, mock.size());
		assertEquals(7, mock.size());
	}
	
	@Test
	void sizeReturnWithParametersTest() {
		//Quando viene chiamata la get con il parametro 0 restituisci la stringa
		//Attenzione vale SOLO per la chiamata get(0) get(1) restituisce null
		when(mock.get(0)).thenReturn("In18mins");
		assertEquals("In18mins", (String) mock.get(0));
		assertEquals(null, mock.get(1));
		
	}
	
	@Test
	void sizeReturnWithGenericParametersTest() {
		//Quando viene chiamata la get con un qualsiasi intero restituisci la stringa
		when(mock.get(anyInt())).thenReturn("In18mins");
		assertEquals("In18mins", (String)mock.get(0));
		assertEquals("In18mins", (String)mock.get(1));
		assertEquals("In18mins", (String)mock.get(71));
		
	}
	
	@Test
	public void verificationBasics() {
		//Simuliamo che voglia verificare che il metodo get contenuto nel mock venga invocato 
		//SUT code
		String value = (String) mock.get(0);
		String value2 = (String) mock.get(7);
		
		//Per uno specifico calore
		verify(mock).get(0);
		//Oppure usando un'espressione generica
		//verify(mock).get(anyInt());
		//Posso anche verificare che venga chiamato k volte.....
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
	}
	
	@Test
	public void argumentCapturing() {
		//SUT code
		mock.add("SomeString");
		
		//Come faccio a catturare l'argomento che viene passato al mock?
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		//Verifichiamo che il metodo add venga chiamato con l'argomento catturato ossia SomeString
		verify(mock).add(captor.capture());
		assertEquals("SomeString", captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		//SUT code
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//Come faccio a catturare l'argomento che viene passato al mock?
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		//Verifichiamo che il metodo add venga chiamato 2 volte
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues(); 
		//E qui controllo che gli argomenti passati siano davvero quelli desiderati
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
	}
	
	@Test
	public void mocking() {
		//Creo un mock di arraylist
		ArrayList arrayListMock = mock(ArrayList.class);
		//Anche chiamando metodi sul mock come ad esempio
		System.out.println(arrayListMock.get(0)); //Null
		System.out.println(arrayListMock.size()); //0
		
		arrayListMock.add("Test");
		arrayListMock.add("Test1");
		
		//I valori restano SEMPRE quelli di default
		System.out.println(arrayListMock.get(0)); //Null
		System.out.println(arrayListMock.size()); //0
		
	}
	
	//Se voglio che il comportamento originale della classe venga mantenuto
	//Devo creare una spy e non un mock
	@Test
	public void spying() {
		//Creo uno spy di arraylist
		ArrayList arrayListSpy = spy(ArrayList.class);
		//System.out.println(arrayListMock.get(0)); //Null
		System.out.println(arrayListSpy.size()); //0
		
		arrayListSpy.add("Test");
		arrayListSpy.add("Test1");
		
		//La classe si comporta come mi aspetterei
		System.out.println(arrayListSpy.get(0)); //Test
		System.out.println(arrayListSpy.size()); //2
		
	}
	
}
