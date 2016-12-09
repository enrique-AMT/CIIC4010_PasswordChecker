import static org.junit.Assert.*;

import org.junit.Test;


/**
 * PasswordTest
 * JUnit class designed to test a Password class used to validate the safety levels of passwords
 * 
 * @author Bienvenido.Velez@upr.edu
 *
 */
public class PasswordTest {
		
	@Test
	public void testLongEnough() {
		// boolean longEnough(n) - returns true iff password has at least n chars
		assertTrue("longEnough(n): Incorrect result", new Password("hello").longEnough(5));
		assertFalse("longEnough(n): Incorrect result", new Password("hello").longEnough(6));
		assertFalse("longEnough(n): Incorrect result", new Password("").longEnough(6));
		assertFalse("longEnough(n): Incorrect result", new Password("!@#^&").longEnough(6));
	}
	
	@Test
	public void testContainsOneOf() {
		// boolean containsOneOf(String chars) - returns true iff password contains at least one of the chars in the given String
		assertTrue("containsOneOf: Incorrect result", new Password("Hello World").containsOneOf("abcdefgh"));
		assertFalse("containsOneOf: Incorrect result", new Password("Hello World").containsOneOf("123456789"));
		assertFalse("containsOneOf: Incorrect result", new Password("Hello World").containsOneOf("!@#$%^&"));
	}

	@Test
	public void testContainsNoneOf() {
		// boolean containsNoneOf(String chars) - returns true iff password does not contain any of the chars in the given String
		assertTrue("containsNoneOf: Incorrect result", new Password("Hello World").containsNoneOf("123456789_"));
		assertFalse("containsNoneOf: Incorrect result", new Password("Hello World").containsNoneOf("1234 56789"));
		assertFalse("containsNoneOf: Incorrect result", new Password("Hello World").containsNoneOf("!@#$H%^&"));
	}
	
	@Test
	public void testContainsUpperCase() {
		// boolean containsUpperCase() - returns true iff password contains at least one upper case letter
		assertTrue("containsUpperCase: Incorrect result", new Password("Hello World").containsUpperCase());
		assertFalse("containsUpperCase: Incorrect result", new Password("").containsUpperCase());
		assertFalse("containsUpperCase: Incorrect result", new Password("hello world").containsUpperCase());
	}
	

	@Test
	public void testContainsLowerCase() {
		// boolean containsUpperCase() - returns true iff password contains at least one lower case letter
		assertTrue("containsLowerCase: Incorrect result", new Password("Hello World").containsLowerCase());
		assertFalse("containsLowerCase: Incorrect result", new Password("").containsLowerCase());
		assertFalse("containsLowerCase: Incorrect result", new Password("HELLO WORLD").containsLowerCase());
	}
	
	@Test
	public void testSafetyLevel() {
		// safetyLevel() - Returns:
		//                 Password.STRONG (int 1) if password has at least 10 chars, at least one upper and one lower case letter, at least one digit and at least one of "!@#$%^&*()"
		//                 Password.MEDIUM (int 2) if password has at least 8 chars, at least one upper and one lower case letter, and at least one digit
		//                 Password.WEAK (int 3) if password has at least 8 chars, at least one upper and one lower case letter, and at least one digit
		//                 Password.INVALID (int 4) if password has less than 8 chars OR at least of of the chars '.' or '/'
		assertEquals("safetyLevel: Incorrect result", Password.WEAK, new Password("Hello World").safetyLevel());
		assertEquals("safetyLevel: Incorrect result", Password.WEAK, new Password("hello1234").safetyLevel());
		assertEquals("safetyLevel: Incorrect result", Password.INVALID, new Password("Qwerty").safetyLevel());
		assertEquals("safetyLevel: Incorrect result", Password.INVALID, new Password("Hello/World").safetyLevel());
		assertEquals("safetyLevel: Incorrect result", Password.MEDIUM, new Password("HelloWorld1").safetyLevel());
		assertEquals("safetyLevel: Incorrect result", Password.MEDIUM, new Password("HelloWorld1").safetyLevel());
		assertEquals("safetyLevel: Incorrect result", Password.STRONG, new Password("HelloWorld1!").safetyLevel());
	}
}
