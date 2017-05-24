package seng201.assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public final class PlayerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    private Pet testCat = PetType.Cat.create("testCat");
    private Pet testDog = PetType.Dog.create("testDog");
    private Pet testBird = PetType.Bird.create("testBird");
    private Pet[] petList = new Pet[] {testCat, testDog, testBird};

    private Player testPlayer = new Player("test", petList);

    @Test
    public void testPlayer() {
        assertTrue(testPlayer.getName().equals("test"));
        assertTrue(testPlayer.getPets() == petList);
    }

    @Test
    public void testPurchaseToy() {
        assertTrue(testPlayer.getToys().size() == 0);

        testPlayer.purchase(Toy.SMALLBALL);
        assertTrue(testPlayer.getToys().get(0).toString().equals(Toy.SMALLBALL.toString()));
        assertTrue(testPlayer.getToys().size() == 1);

        testPlayer.purchase(Toy.LARGEBALL);
        assertTrue(testPlayer.getToys().get(0).toString().equals(Toy.SMALLBALL.toString()));
        assertTrue(testPlayer.getToys().get(1).toString().equals(Toy.LARGEBALL.toString()));
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
    public void testPurchaseFailsWhenBroke() {
        thrown.expect(UnsupportedOperationException.class);
        testPlayer.addMoney(-testPlayer.getMoney());
        testPlayer.purchase(Food.BLOODWORM);
    }

    @Test
    public void testGetName() {
        assertTrue(testPlayer.getName().equals("test"));
    }

    @Test
    public void testGetPets() {
        assertArrayEquals(petList, testPlayer.getPets());
    }

    //no testGetFood and testGetToys as effectively tested in
    //testPurchaseToy and testPurchaseFood - would be similar or the same

    @Test
    public void testGetMoney() {
        assertEquals(testPlayer.getMoney(), 100);
        testPlayer.purchase(Toy.SMALLBALL);
        assertEquals(testPlayer.getMoney(), 100 - Toy.SMALLBALL.getPrice());
        testPlayer.purchase(Food.CARROT);
        assertEquals(testPlayer.getMoney(), 100 - Toy.SMALLBALL.getPrice() - Food.CARROT.getPrice());
    }
}
