package seng201.assignment;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Matthew on 2017-05-23.
 */
public final class GameTest {
    @Test
    public void testCorrectRounds() {
        Pet[] pets = new Pet[] {
                PetType.Dog.create("testDog")
        };
        Game game = new Game(100, new Player[] {
                new Player("testPlayer", pets)
        });
        assertEquals(0, game.getCurrentDay());
        for (int i = 0; i < 100; i++) {
            game.endTurn();
        }
        
        assertFalse(game.isRunning());
    }
    
    @Test
    public void testCorrectRoundsMultiplePlayers() {
        Pet[] pets = new Pet[] {
                PetType.Dog.create("testDog")
        };
        Game game = new Game(100, new Player[] {
                new Player("testPlayer1", pets),
                new Player("testPlayer2", pets),
                new Player("testPlayer3", pets)
        });
        assertEquals(0, game.getCurrentDay());
        for (int i = 0; i < 300; i++) {
            game.endTurn();
        }
        
        assertFalse(game.isRunning());
    }
    
    @Test
    public void testChangingPets() {
        Pet[] pets = new Pet[] {
                PetType.Dog.create("testDog1"),
                PetType.Dog.create("testDog2"),
                PetType.Dog.create("testDog3"),
        };
        Game game = new Game(1, new Player[] {
                new Player("testPlayer", pets)
        });

        assertEquals(pets[0], game.getCurrentPet());
        game.setCurrentPetIndex(1);
        assertEquals(pets[1], game.getCurrentPet());
        game.setCurrentPetIndex(2);
        assertEquals(pets[2], game.getCurrentPet());
    }
}
