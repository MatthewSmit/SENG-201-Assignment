package seng201.assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToyTest {
	private Pet testCat = PetType.Cat.create("testCat");
	
	@Test
	public void testDegrade() {

		Toy smallBall = new Toy(ToyType.SMALLBALL);
		
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
		
		Toy largeBall = new Toy(ToyType.LARGEBALL);
				
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
		
		assertEquals(ToyType.SMALLBALL.getPrice(),3);
		assertEquals(ToyType.LARGEBALL.getPrice(),5);
		assertEquals(ToyType.SQUEAKYTOY.getPrice(),8);
		assertEquals(ToyType.GUINEAPIGWHEEL.getPrice(),7);
		assertEquals(ToyType.JUNGLEGYM.getPrice(),8);
		assertEquals(ToyType.CARDBOARDBOX.getPrice(),1);
		
	}

	@Test
	public void testGetDurability() {
		
		assertEquals(ToyType.SMALLBALL.getDurability(),8);
		assertEquals(ToyType.LARGEBALL.getDurability(),9);
		assertEquals(ToyType.SQUEAKYTOY.getDurability(),5);
		assertEquals(ToyType.GUINEAPIGWHEEL.getDurability(),7);
		assertEquals(ToyType.JUNGLEGYM.getDurability(),5);
		assertEquals(ToyType.CARDBOARDBOX.getDurability(),2);

	}

}
