package org.filippo.formazione;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


//Ogni volta che viene lanciato un test viene creata una NUOVA istanza della classe MathUtilsTest
//Questo esalta l'indipendenza reciproca di ogni test.....

//Supponiamo di NON volere che venga creata una nuova istanza della classe di test per ogni
//esecuzione di un nuovo test, posso modificare il comportamento usando....
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //Così viene creata l'istanza una sola volta
@DisplayName("When running MathUtils")
class MathUtilisTest {
	
	MathUtils mathUtils;
	
	TestInfo testInfo;
	TestReporter testReporter;
	
	
	//Se avessi bisogno di eseguire istruzioni prima che tutti i tests siano eseguiti
	//Questo metodo viene eseguito prima che listanza MAthUtilsTest sia creata
	//Quidni i metodi annotati con @Before/AfterALL DEVONO essere STATICI
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all");
	}
	
	//Se ho bisogno di ripetere istruzioni prima di ogni test...
	@BeforeEach
	//Uso DInj per ottenere due classi di logging di JU
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
	}
	
	//Se avessi bisogno di eseguire istruzioni dopo aver eseguito un test...
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up....");
	}
	
	//Questa annotation dice all'engine di JU che deve lanciare questo metodo come test
	@Test
	@DisplayName("Testing add Method") //Rinomino il test nella console di esecuzione
	@Tag("Math")
	void testAdd() {
		
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual);
	}
	
	//Se volessi organizzare i tests per uno stesso metodo ma in diversi scenari posso usare @Nested
	@Nested
	@DisplayName("add method")
	class addTest {
		
		@Test
		@DisplayName("when adding two Positive Numbers")
		@Tag("Math") //Tagga i tuoi test e lanciali by tag
		void testAddPositive() {
			
			int expected = 2;
			int actual = mathUtils.add(1, 1);
			assertEquals(expected, actual, "Should return the right sum");
			
		}
		
		
		@Test
		@DisplayName("When adding two  Negative Numbers")
		@Tag("Math")
		void testAddNegative() {
			
			int expected = -2;
			int actual = mathUtils.add(-1, -1);
			//Il messaggio viene computato ogni volta che il test viene eseguito, anche se passa.
			//In realtà è necessario sia computato SOLO se il test fallisce, per ottenere questo
			//Al posto di passare una stringa direttamente si può passare una lambda expr => 
			//In questo modo siamo certi che la stringa venga computata SOLO SE il test fallisce
			assertEquals(expected, actual, () -> "Should return the right sum " + expected + " but it is " + actual);
			
		}
		
		
		
	}
	
	@RepeatedTest(value = 3) //Ripeti lo stesso test per k volte
	@Tag("Circle") //Qui posso inj il parametro RepetitionInfo
	void testComputeCircleArea(RepetitionInfo repetition) {
		//Se volessi fare cose diverse per la ripetizione x
		if(repetition.getCurrentRepetition() == 2)
			fail();
		
		assertEquals(314.15926535897933, mathUtils.computeCircleArea(10), "Should return the right circle area");	
	}
	
	
	@Test
	@EnabledOnOs(OS.LINUX) //Esempio di esecuzione Condizionale ne esistono molte altre.....
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp); //Assumptions per verificare precondizioni PRIMA dell'esecuzione di un test
		//Se le precondizioni non vengono superate il test non viene eseguito
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide By Zero shoud throw!");
		
	}
	
	@Test
	@DisplayName("When multiplying two numbers")
	@Tag("Math")
	void testMultiply() {
		//System.out.println("Running " + this.testInfo.getDisplayName() + " with tags " +this.testInfo.getTags());
		//Usa testReporter per loggare l'out
		this.testReporter.publishEntry("Running " + this.testInfo.getDisplayName() + " with tags " +this.testInfo.getTags());
		
		//Supponiamo di avere una serie di asserzioni per vari casi di test....Può essere utile usare
		//AssertAll prende una collezione di lambdas che esegue.
		//I singoli assert sono in AND tra loro
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2)),
				() -> assertEquals(0, mathUtils.multiply(2 ,0)),
				() -> assertEquals(-2, mathUtils.multiply(2, -1))
				);
	}
	
	
	@Test
	@DisplayName("TDD method should not run")
	@Disabled //disabilito l'esecuzione del test utile in TDD dev e sto ancora sviluppando la feature da testare
	void testDisabled() {
		
		fail("This test shoud be disabled!");
	}
	
	
	

}
