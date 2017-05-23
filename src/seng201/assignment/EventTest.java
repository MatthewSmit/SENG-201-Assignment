package seng201.assignment;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Matthew on 2017-05-23.
 */
public final class EventTest {
    @Test
    public void testSickness() {
        SicknessEvent event = new SicknessEvent();
        Event.setRandomSeed(0);
        Pet pet = PetType.Dog.create("dogName");
        
        // Pets cannot get sick when starting out, their stats are too high
        for (int i = 0; i < 100; i++) {
            event.processPet(pet);
            assertFalse(pet.isSick());
        }
        
        // Abandon the pet so the stats are the worst
        for (int i = 0; i < 100; i++) {
            pet.dayPassed();
        }
        
        for (int i = 0; i < 100; i++) {
            event.processPet(pet);
            if (pet.isSick()) {
                break;
            }
        }

        // Probability pet won't be sick after 100 days of abandonment then 100 days of sickness testing is 1.6E-40
        assertTrue(pet.isSick());
    }

    @Test
    public void testMisbehaving() {
        MisbehaveEvent event = new MisbehaveEvent();
        Event.setRandomSeed(0);
        Pet pet = PetType.Dog.create("dogName");
        
        // Pets cannot misbehave when starting out, their stats are too high
        for (int i = 0; i < 100; i++) {
            event.processPet(pet);
            assertFalse(pet.isMisbehaving());
        }
        
        // Abandon the pet so the stats are the worst
        for (int i = 0; i < 100; i++) {
            pet.dayPassed();
        }
        
        for (int i = 0; i < 100; i++) {
            event.processPet(pet);
            if (pet.isMisbehaving()) {
                break;
            }
        }

        // Probability pet won't be misbehaving after 100 days of abandonment then 100 days of misbehaving testing is 3.2E-13
        assertTrue(pet.isMisbehaving());
    }

    @Test
    public void testDeath() {
        DeadEvent deadEvent = new DeadEvent();
        SicknessEvent sickEvent = new SicknessEvent();
        Event.setRandomSeed(0);
        Pet pet = PetType.Dog.create("dogName");
        
        // Pets cannot die when starting out, their stats are too high
        for (int i = 0; i < 100; i++) {
            deadEvent.processPet(pet);
            assertFalse(pet.isDead());
        }
        
        // Abandon the pet so the stats are the worst
        for (int i = 0; i < 100; i++) {
            pet.dayPassed();
        }
        
        for (int i = 0; i < 100; i++) {
            sickEvent.processPet(pet);
            if (pet.isSick()) {
                break;
            }
        }
        
        // Abandon the pet more so its health is 0
        for (int i = 0; i < 10; i++) {
            pet.dayPassed();
        }
        
        for (int i = 0; i < 100; i++) {
            deadEvent.processPet(pet);
            if (pet.isDead()) {
                break;
            }
        }

        // Probability pet won't be dead after 100 days of abandonment then 100 days of death testing is 6.5E-23
        assertTrue(pet.isDead());
    }
}
