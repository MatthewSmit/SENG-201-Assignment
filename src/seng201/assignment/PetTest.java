package seng201.assignment;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by programmdude on 27/04/17.
 */
public class PetTest {
    @Test
    public void feedGood() throws Exception {
        Pet pet = PetType.Dog.create("dogName");

        pet.dayPassed();

        int happiness = pet.getHappiness();
        float weight = pet.getWeight();
        int toiletNeed = pet.getToiletNeed();
        int hunger = pet.getHunger();

        pet.feed(Food.STEAK);

        assertTrue(pet.getHappiness() > happiness);
        assertTrue(pet.getWeight() > weight);
        assertTrue(pet.getToiletNeed() > toiletNeed);
        assertTrue(pet.getHunger() < hunger);
    }

    @Test
    public void feedNormal() throws Exception {
        Pet pet = PetType.Dog.create("dogName");

        // Pet needs to get hungry first
        pet.dayPassed();

        int happiness = pet.getHappiness();
        float weight = pet.getWeight();
        int toiletNeed = pet.getToiletNeed();
        int hunger = pet.getHunger();

        pet.feed(Food.CARROT);

        assertTrue(pet.getHappiness() == happiness);
        assertTrue(pet.getWeight() > weight);
        assertTrue(pet.getToiletNeed() > toiletNeed);
        assertTrue(pet.getHunger() < hunger);
    }

    @Test
    public void play() throws Exception {
        Pet pet = PetType.Dog.create("dogName");

        int happiness = pet.getHappiness();

        Toy toy = Toy.LARGEBALL.clone();
        int durability = toy.getDurability();
        pet.play(toy);
        assertTrue(pet.getHappiness() > happiness);
        assertTrue(toy.getDurability() < durability);
    }

    @Test
    public void sleep() throws Exception {
        Pet pet = PetType.Dog.create("dogName");

        // Pet needs to get tired first
        pet.dayPassed();

        int tiredness = pet.getTiredness();
        pet.sleep();
        assertTrue(pet.getTiredness() < tiredness);
    }

    @Test
    public void toilet() throws Exception {
        Pet pet = PetType.Dog.create("dogName");

        // Pet needs to get poopy first
        pet.feed(Food.STEAK);

        int toiletNeed = pet.getToiletNeed();
        pet.toilet();
        assertTrue(pet.getToiletNeed() < toiletNeed);
    }

    @Test
    public void misbehave() throws Exception {
        Pet pet = PetType.Dog.create("dogName");
        assertFalse(pet.isMisbehaving());
        pet.startMisbehaving();
        assertTrue(pet.isMisbehaving());
    }

    @Test
    public void sickness() throws Exception {
        Pet pet = PetType.Dog.create("dogName");
        assertFalse(pet.isSick());
        pet.startBeingSick();
        assertTrue(pet.isSick());

        int health = pet.getHealth();
        pet.dayPassed();
        assertTrue(pet.getHealth() < health);
        assertTrue(pet.isSick());
    }

    @Test
    public void getPlayfulness() throws Exception {
        // Pet has valid playfulness
        Pet pet = PetType.Dog.create("dogName");
        assertTrue(pet.getPlayfulness() > 0);
    }

    @Test
    public void getRoughness() throws Exception {
        // Pet has valid roughness
        Pet pet = PetType.Dog.create("dogName");
        assertTrue(pet.getRoughness() > 0);
    }

    @Test
    public void getHealth() throws Exception {
        // Pet has valid health
        Pet pet = PetType.Dog.create("dogName");
        assertTrue(pet.getHealth() > 0);
    }

    @Test
    public void getWeight() throws Exception {
        // Pet has valid weight
        Pet pet = PetType.Dog.create("dogName");
        assertTrue(pet.getWeight() > 0);
    }

    @Test
    public void getDeathState() throws Exception {
        // Pet starts alive
        Pet pet = PetType.Dog.create("dogName");
        assertEquals(Pet.DeathState.ALIVE, pet.getDeathState());

        // Pet can be revived once
        pet.die();
        assertEquals(Pet.DeathState.DEAD_ONCE, pet.getDeathState());

        // Afterwards its permenantly dead
        pet.die();
        assertEquals(Pet.DeathState.PERMANENTLY_DEAD, pet.getDeathState());
    }

    @Test
    public void getName() throws Exception {
        // Make sure pet has the right name
        Pet pet = PetType.Dog.create("dogName");
        assertEquals("dogName", pet.getName());
    }

    @Test
    public void getSpecies() throws Exception {
        Pet[] pets = createPets();

        // Make sure each pet has a species with a valid string
        for (int i = 0; i < pets.length; i++) {
            String species = pets[i].getSpecies();
            assertNotNull(species);
            assertNotEquals(0, species.length());
        }
    }

    /*@Test
    public void getFavouriteToy() throws Exception {
        for (int i = 0; i < pets.length; i++) {
            Toy[] toys = pets[i].getFavouriteToy();
            throw new UnsupportedOperationException();
        }
    }*/
    private static Pet[] createPets() {
        return new Pet[]{
                PetType.Bird.create("bird"),
                PetType.Cat.create("cat"),
                PetType.Dog.create("dog"),
                PetType.Goldfish.create("goldfish"),
                PetType.GuineaPig.create("guinea pig"),
                PetType.Rabbit.create("rabbit")
        };
    }
}