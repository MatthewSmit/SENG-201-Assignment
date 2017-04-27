package seng201.assignment.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import seng201.assignment.*;

public class PlayerTest {

	private Cat testCat = new Cat("testCat");
	private Dog testDog = new Dog("testDog");
	private Bird testBird = new Bird("testBird");
	private Pet[] petList = new Pet[] {testCat, testDog, testBird};
	
	private Player testPlayer = new Player("test", petList);
	
	
	@Test
	public void testPlayer() {
		assertTrue(testPlayer.getName() == "test");
		assertTrue(testPlayer.getPets() == petList);
	}

	@Test
	public void testPurchaseToy() {
		
		
		ArrayList<Toy> toys = new ArrayList<>();
		assertEquals(testPlayer.getToys(), new ArrayList<>());
		
		toys.add(Toy.SMALLBALL);
		testPlayer.purchase(Toy.SMALLBALL);
		assertEquals(testPlayer.getToys(), toys);
		
		toys.add(Toy.LARGEBALL);
		testPlayer.purchase(Toy.LARGEBALL);
		assertEquals(testPlayer.getToys(), toys);

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
		testPlayer.purchase(Toy.SMALLBALL); //costs 3
		assertEquals(testPlayer.getMoney(), 97);
		testPlayer.purchase(Food.CARROT); //costs 2
		assertEquals(testPlayer.getMoney(), 95);
	}


}
