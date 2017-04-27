package seng201.assignment.test;

import static org.junit.Assert.*;

import org.junit.Test;

import seng201.assignment.*;

public class ToyTest {

	
	private Cat testCat = new Cat("testCat");
	
	@Test
	public void testDegrade() {

		Toy smallBall = Toy.SMALLBALL;
		
		smallBall.degrade(testCat);
		assertTrue(smallBall.getDurability() >= 3);
		try {
			smallBall.degrade(testCat);
			smallBall.degrade(testCat);
			smallBall.degrade(testCat);
		} catch (Exception exception) {
		    System.out.println(exception.getMessage());
		}
	}

	@Test
	public void testIsBroken() {
		
		Toy largeBall = Toy.LARGEBALL;
				
		largeBall.degrade(testCat);
		try {
			largeBall.degrade(testCat);
			largeBall.degrade(testCat);
			largeBall.degrade(testCat);
			largeBall.degrade(testCat);
		} catch (Exception e) {
			assertTrue(largeBall.isBroken());
		}
	}
	

	@Test
	public void testGetPrice() {
		
		assertEquals(Toy.SMALLBALL.getPrice(),3);
		assertEquals(Toy.LARGEBALL.getPrice(),5);
		assertEquals(Toy.SQUEAKYTOY.getPrice(),8);
		assertEquals(Toy.GUINEAPIGWHEEL.getPrice(),7);
		assertEquals(Toy.JUNGLEGYM.getPrice(),8);
		assertEquals(Toy.CARDBOARDBOX.getPrice(),1);
		
	}

	@Test
	public void testGetDurability() {
		
		assertEquals(Toy.SMALLBALL.getDurability(),8);
		assertEquals(Toy.LARGEBALL.getDurability(),9);
		assertEquals(Toy.SQUEAKYTOY.getDurability(),5);
		assertEquals(Toy.GUINEAPIGWHEEL.getDurability(),7);
		assertEquals(Toy.JUNGLEGYM.getDurability(),5);
		assertEquals(Toy.CARDBOARDBOX.getDurability(),2);

	}

}
