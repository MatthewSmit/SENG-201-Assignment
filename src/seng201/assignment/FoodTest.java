package seng201.assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public final class FoodTest {
    @Test
    public void testGetPrice() {
        assertEquals(Food.CARROT.getPrice(), 2);
        assertEquals(Food.TUNA.getPrice(), 6);
        assertEquals(Food.LETTUCE.getPrice(), 2);
        assertEquals(Food.STEAK.getPrice(), 8);
        assertEquals(Food.SEEDS.getPrice(), 4);
        assertEquals(Food.BLOODWORM.getPrice(), 5);
        assertEquals(Food.PEAS.getPrice(), 2);
    }

    @Test
    public void testGetNutrition() {
        assertEquals(Food.CARROT.getNutrition(), 3);
        assertEquals(Food.TUNA.getNutrition(), 5);
        assertEquals(Food.LETTUCE.getNutrition(), 2);
        assertEquals(Food.STEAK.getNutrition(), 7);
        assertEquals(Food.SEEDS.getNutrition(), 3);
        assertEquals(Food.BLOODWORM.getNutrition(), 2);
        assertEquals(Food.PEAS.getNutrition(), 3);
    }

    @Test
    public void testGetMealSize() {
        assertEquals(Food.CARROT.getMealSize(), 3);
        assertEquals(Food.TUNA.getMealSize(), 4);
        assertEquals(Food.LETTUCE.getMealSize(), 3);
        assertEquals(Food.STEAK.getMealSize(), 6);
        assertEquals(Food.SEEDS.getMealSize(), 3);
        assertEquals(Food.BLOODWORM.getMealSize(), 2);
        assertEquals(Food.PEAS.getMealSize(), 2);
    }

    @Test
    public void testGetTastiness() {
        assertEquals(Food.CARROT.getTastiness(), 3);
        assertEquals(Food.TUNA.getTastiness(), 5);
        assertEquals(Food.LETTUCE.getTastiness(), 2);
        assertEquals(Food.STEAK.getTastiness(), 6);
        assertEquals(Food.SEEDS.getTastiness(), 4);
        assertEquals(Food.BLOODWORM.getTastiness(), 3);
        assertEquals(Food.PEAS.getTastiness(), 2);
    }
    
    @Test
    public void testToString() {
        for (Food food : Food.values()) {
            assertNotNull(food.toString());
        }
    }
}
