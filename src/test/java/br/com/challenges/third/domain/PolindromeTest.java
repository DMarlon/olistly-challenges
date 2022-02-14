package br.com.challenges.third.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PolindromeTest {

	@Test
	public void is_null_value() {
		assertFalse(Palindrome.is(null));
	}

	@Test
	public void is_empt_value() {
		assertFalse(Palindrome.is(""));
	}

	@Test
	public void is_more_words_value() {
		assertFalse(Palindrome.is("racecar racecar"));
	}

	@Test
	public void is_trim_value() {
		assertTrue(Palindrome.is("   racecar   "));
	}

	@Test
	public void is_camelcase_value() {
		assertTrue(Palindrome.is("Racecar"));
	}

	@Test
	public void is_value() {
		assertTrue(Palindrome.is("redivider"));
		assertTrue(Palindrome.is("deified"));
		assertTrue(Palindrome.is("civic"));
		assertTrue(Palindrome.is("radar"));
		assertTrue(Palindrome.is("level"));
		assertTrue(Palindrome.is("rotor"));
		assertTrue(Palindrome.is("kayak"));
		assertTrue(Palindrome.is("reviver"));
		assertTrue(Palindrome.is("racecar"));
		assertTrue(Palindrome.is("madam"));
		assertTrue(Palindrome.is("refer"));
	}

}
