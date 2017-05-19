package seng201.assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayerTest {

	private Pet testCat = PetType.Cat.create("testCat");
	private Pet testDog = PetType.Dog.create("testDog");
	private Pet testBird = PetType.Bird.create("testBird");
	private Pet[] petList = new Pet[] {testCat, testDog, testBird};
	
	private Player testPlayer = new Player("test", petList);
	
	
	@Test
	public void testPlayer() {
		assertTrue(testPlayer.getName() == "test");
		assertTrue(testPlayer.getPets() == petList);
	}

	@Test
	public void testPurchaseToy() {
        assertTrue(testPlayer.getToys().size() == 0);

		testPlayer.purchase(ToyType.SMALLBALL);
        assertTrue(testPlayer.getToys().get(0).getType() == ToyType.SMALLBALL);
        assertTrue(testPlayer.getToys().size() == 1);

		testPlayer.purchase(ToyType.LARGEBALL);
        assertTrue(testPlayer.getToys().get(0).getType() == ToyType.SMALLBALL);
        assertTrue(testPlayer.getToys().get(1).getType() == ToyType.LARGEBALL);
        assertTrue(testPlayer.getToys().size() == 2);
	}

	@Test
	public void testPurchaseFood() {
		
		ArrayList<Food> foods = new ArrayList<>();
		assertEquals(testPlayer.getFood(), new ArrayList<>());
		
		foods.add(Food.CARROT);
		testPlayer.purchase(Food.CARROT);
		assertEquals(testPlayer.getFood(), foods);
		
		foods.add(Food.LETTUCE);
		testPlayer.purchase(Food.LETTUCE);
		assertEquals(testPlayer.getFood(), foods);

	}

	@Test
	public void testGetName() {
		assertTrue(testPlayer.getName() == "test");

	}

	@Test
	public void testGetPets() {
		assertTrue(testPlayer.getPets() == petList);
	}
	
	//no testGetFood and testGetToys as effectively tested in
	//testPurchaseToy and testPurchaseFood - would be similar or the same

	@Test
	public void testGetMoney() {
		assertEquals(testPlayer.getMoney(), 100);
		testPlayer.purchase(ToyType.SMALLBALL); //costs 3
		assertEquals(testPlayer.getMoney(), 97);
		testPlayer.purchase(Food.CARROT); //costs 2
		assertEquals(testPlayer.getMoney(), 95);
	}


}
