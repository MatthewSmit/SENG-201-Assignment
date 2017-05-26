package seng201.assignment;

import java.util.ArrayList;

/**
 * Class used to contain the methods which generate the strings used
 * throughout the GUI.
 */
public final class GameStrings {
    private GameStrings() {
    }

    /**
     * Generates a string containing the information about a given species, such as the weight range, favourite toy,
     * favourite food, and playfulness range.
     * @param type - the type of a pet.
     * @return speciesInfo - a string containing the information for a given species, such as the weight range, favourite toy,
     * favourite food, and playfulness range.
     */
    public static String getSpeciesStats(final PetType type) {
        Pet pet = type.create("pet");
        String speciesInfo = "";
        speciesInfo += "Favourite toy(s): " + stringOfToys(type.getFavouriteToys()) + "\r\n";
        speciesInfo += "Favourite foods: " + stringOfFoods(type.getFavouriteFoods()) + "\r\n";
        speciesInfo += "Weight range: " + stringOfWeightRange(pet.getSpeciesWeightRange()) + "\r\n";
        speciesInfo += "Playfulness range: " + stringOfRange(pet.getSpeciesPlayfulnessRange()) + "\r\n";
        speciesInfo += "Roughness range: " + stringOfRange(pet.getSpeciesRoughnessRange()) + "\r\n";
        speciesInfo += "Hunger rate range: " + stringOfRange(pet.getSpeciesHungerRateRange()) + "\r\n";
        speciesInfo += "Tiredness rate range: " + stringOfRange(pet.getSpeciesTiredRateRange());
        return speciesInfo;
    }

    /**
     * Gets the species as a string given a petType.
     * @param type - the type of a pet.
     * @return name - the name of the species corresponding to the type.
     */
    public static String getTypeSpecies(final PetType type) {
        return type.getName();
    }

    /**
     * Gets the name of a pet.
     * @param pet - a pet.
     * @return name - the name of a pet.
     */
    public static String getPetName(final Pet pet) {
        return pet.getName();
    }


    /**
     * Generates a message string if the pet is dead.
     * @param pet - a pet.
     * @return deadString - empty string if the pet is alive, "\r\n(pet name) is dead!" if the pet is dead.
     */
    public static String getPetDeadString(final Pet pet) {
        String deadString = "";
        if (pet.isDead()) {
            deadString = String.format("\r\n%s is dead!", pet.getName());
        }
        return deadString;
    }

    /**
     * Generates a message string if the pet is sick.
     * @param pet - a pet.
     * @return sicknessString - empty string if pet isn't sick, "\r\n(pet name) is sick!" if the pet is sick.
     */
    public static String getPetSickString(final Pet pet) {
        String sicknessString = "";
        if (pet.isSick()) {
            sicknessString = String.format("\r\n%s is sick!", pet.getName());
        }
        return sicknessString;
    }

    /**
     * Generates a message string if the pet is misbehaving.
     * @param pet - a pet.
     * @return misbehavingString - empty string if pet isn't misbehaving, "\r\n(pet name) is misbehaving!" if the pet is misbehaving.
     */
    public static String getPetMisbehavingString(final Pet pet) {
        String misbehavingString = "";
        if (pet.isMisbehaving()) {
            misbehavingString = String.format("\r\n%s is misbehaving!", pet.getName());
        }
        return misbehavingString;
    }

    /**
     * Generates a string listing out toys given a list of toys.
     * @param toys - a list of toys.
     * @return toysString - the toys listed out in a string, of the form "(toy1), (toy2), (toy3)".
     */
    public static String stringOfToys(final Toy[] toys) {
        String toysString = toys[0].toString();

        for (int i = 1; i < toys.length; i++) {
            toysString += ", " + toys[i].toString();
        }
        return toysString;
    }

    /**
     * Generates a string listing out foods given a list of foods.
     * @param foods - a list of foods.
     * @return foodsString - the foods listed out in a string, of the form "(food1), (food2), (food3)".
     */
    public static String stringOfFoods(final Food[] foods) {
        String foodsString = foods[0].toString();

        for (int i = 1; i < foods.length; i++) {
            foodsString += ", " + foods[i].toString();
        }
        return foodsString;
    }


    /**
     * Generates a string representation of a weight range given two floats in a float[] list.
     * @param floats - list of two floats, representing the lower and upper bounds of the weight range respectively.
     * @return floatRange - String representation of the float range, of the form "(float1)kg - (float2)kg".
     */
    public static String stringOfWeightRange(final float[] floats) {
        return String.format("%.2fkg - %.2fkg", floats[0], floats[1]);
    }

    /**
     * Generates a string representation of a range given two integers in an int[] list.
     * @param ints - list of two integers, representing the lower and upper bounds respectively.
     * @return intsRange - String representation of the integers range, of the form "(int1) - (int2)".
     */
    public static String stringOfRange(final int[] ints) {
        return String.format("%d%% - %d%%", ints[0] * 10, ints[1] * 10);
    }


    /**
     * Generates a string for a game giving the player name, current day, max days and current score of that player.
     * @param game - the current game being played.
     * @return currentPlayerAndDayString - a string containing the name, current day, max days and current score for a player.
     */
    public static String getCurrentPlayerAndDay(final Game game) {
        return String.format("%s - Day %d of %d - Score: %d",
                game.getCurrentPlayer().getName(),
                game.getCurrentDay() + 1, game.getMaxDays(),
                game.getCurrentPlayer().getScore());
    }

    /**
     * Generates a string for a given food listing out the animals which like it the most out of the given foods.
     * @param food - a given food.
     * @return mostLikedBy - a string containing the animals which most 
     * like that food of the form "Most liked by: (species1), (species2), (species3)"
     */
    public static String getMostLikedByAnimals(final Food food) {

        ArrayList<String> mostLikedByList = new ArrayList<>();
        String mostLikedBy = "Most liked by: - ";
        for (PetType type : PetType.values()) {
            if (type.getFavouriteFoods()[0] == food) {
                mostLikedByList.add(type.getName());
            }
        }
        if (mostLikedByList.size() > 0) {
            mostLikedBy = "Most liked by: " + mostLikedByList.get(0);
            for (int i = 1; i < mostLikedByList.size(); i++) {
                mostLikedBy += ", " + mostLikedByList.get(i);
            }
        }
        return mostLikedBy;

    }

    /**
     * Generates a string for a given toy listing out the animals which like it the most out of the given toys.
     * @param toy - a given toy.
     * @return mostLikedBy - a string containing the animals which most 
     * like that toy of the form "Most liked by: (species1), (species2), (species3)"
     */
    public static String getMostLikedByAnimals(final Toy toy) {
        ArrayList<String> mostLikedByList = new ArrayList<>();
        String mostLikedBy = "Most liked by: - ";
        for (PetType type : PetType.values()) {
            if (type.getFavouriteToys()[0] == toy) {
                mostLikedByList.add(type.getName());
            }
        } 

        if (mostLikedByList.size() > 0) {
            mostLikedBy = "Most liked by: " + mostLikedByList.get(0);
            for (int i = 1; i < mostLikedByList.size(); i++) {
                mostLikedBy += ", " + mostLikedByList.get(i);
            }
        }
        return mostLikedBy;
    }

    /**
     * Generates a string for a given food listing out the animals which like the food, 
     * but do not like it the most out of the given foods.
     * @param food - a given food.
     * @return alsoLikedBy - a string containing the animals which 
     * like that food of the form "Also liked by: (species1), (species2), (species3)"
     */
    public static String getLikedByAnimals(final Food food) {

        ArrayList<String> alsoLikedByList = new ArrayList<>();
        String alsoLikedBy = "Also liked by: - ";
        for (PetType type : PetType.values()) {
            if (food != type.getFavouriteFoods()[0] && Lists.contains(type.getFavouriteFoods(), food)) {
                alsoLikedByList.add(type.getName());
            }
        }
        if (alsoLikedByList.size() > 0) {
            alsoLikedBy = "Also liked by: " + alsoLikedByList.get(0);
            for (int i = 1; i < alsoLikedByList.size(); i++) {
                alsoLikedBy += ", " + alsoLikedByList.get(i);
            }
        }
        return alsoLikedBy;

    }

    /**
     * Generates a string for a given toy listing out the animals which like the toy, 
     * but do not like it the most out of the given toys.
     * @param toy - a given toy.
     * @return alsoLikedBy - a string containing the animals which 
     * like that toy of the form "Also liked by: (species1), (species2), (species3)"
     */
    public static String getLikedByAnimals(final Toy toy) {

        ArrayList<String> alsoLikedByList = new ArrayList<>();
        String alsoLikedBy = "Also liked by: - ";
        for (PetType type : PetType.values()) {
            if (toy != type.getFavouriteToys()[0] && Lists.contains(type.getFavouriteToys(), toy)) {
                alsoLikedByList.add(type.getName());
            }
        }
        if (alsoLikedByList.size() > 0) {
            alsoLikedBy = "Also liked by: " + alsoLikedByList.get(0);
            for (int i = 1; i < alsoLikedByList.size(); i++) {
                alsoLikedBy += ", " + alsoLikedByList.get(i);
            }
        }
        return alsoLikedBy;

    }


    /**
     * Generates an arrayList of ArrayLists, with each sub-ArrayList containing a string 
     * for the name of an item and a string for the number of that item which the player owns.
     * @param items - an arrayList of the items which the player owns, 
     * which may contain duplicates of items if more than one is owned by the player.
     * @return nameAndNumberArrayList - an ArrayList containing sub-ArrayLists of size 2, each containing a string for the name
     * of an item and a string for the non-zero number of that item which the player owns.
     */
    public static ArrayList<ArrayList<String>> generateInventoryListofLists(final ArrayList<Item> items) {

        ArrayList<String> namesList = new ArrayList<>();
        ArrayList<Integer> numberOfList = new ArrayList<>();
        ArrayList<ArrayList<String>> nameAndNumberArrayList = new ArrayList<ArrayList<String>>();

        int j = 0;

        for (int i = 0; i < items.size(); i++) {
            if (namesList.contains(items.get(i).toString())) {
                int k = namesList.indexOf(items.get(i).toString());
                numberOfList.set(k, numberOfList.get(k) + 1);
            } else {
                namesList.add(j, items.get(i).toString());
                numberOfList.add(j, 1);
                j += 1;
            }
        }

        for (int i = 0; i < namesList.size(); i++) {
            ArrayList<String> temporaryArray = new ArrayList<>();
            temporaryArray.add(namesList.get(i));
            temporaryArray.add(numberOfList.get(i).toString());
            nameAndNumberArrayList.add(temporaryArray);
        }


        return nameAndNumberArrayList;

    }

    /**
     * Converts 0 to 10 integer values into percentages, limited from 0% to 100%. Used for the private
     * attributes in the pet and food classes.  
     * @param integer - an integer from 0 to 10.
     * @return percentString - a string representation of a percentage.
     */
    public static String toPercent(final int integer) {
        int percentage = integer * 10;
        if (percentage > 100) {
            percentage = 100;
        }
        return String.format("%d%%", percentage);
    }


    /**
     * Generate a string containing the information about a given pet.
     * @param pet - a pet.
     * @return petInfo - a string containing information on the attributes of a given pet, 
     * such as the species, weight, happiness and favourite toy.
     */
    public static String getPetInfo(final Pet pet) {
        String petInfo = "";
        petInfo += "Species: " + pet.getSpecies() + "\r\n";
        petInfo += "Gender: " + pet.getGender() + "\r\n";
        petInfo += "Weight: " + String.format("%.2f", pet.getWeight()) + "kg\r\n";
        petInfo += "Hunger: " + toPercent(pet.getHunger()) + "\r\n";
        petInfo += "Toilet need: " + toPercent(pet.getToiletNeed()) + "\r\n";
        petInfo += "Tiredness: " + toPercent(pet.getTiredness()) + "\r\n";
        petInfo += "Healthiness: " + toPercent(pet.getHealth()) + "\r\n";
        petInfo += "Happiness: " + toPercent(pet.getHappiness()) + "\r\n";
        petInfo += "Playfulness: " + toPercent(pet.getPlayfulness()) + "\r\n";
        petInfo += "Roughness: " + toPercent(pet.getRoughness())  + "\r\n";
        petInfo += "Favourite toy: " + stringOfToys(pet.getType().getFavouriteToys()) + "\r\n";
        petInfo += "Favourite food: " + stringOfFoods(pet.getType().getFavouriteFoods());
        if (pet.isDead()) {
            petInfo += getPetDeadString(pet);
        } else {
            petInfo += getPetSickString(pet);
            petInfo += getPetMisbehavingString(pet);
        }
        return petInfo;
    }

    /**
     * Generates a string containing the information for a given item.
     * @param item - an item.
     * @return itemInfo - a string containing information on a given item, such as nutrition,
     * tastiness and meal size for a food, or durability for a toy.
     */
    public static String getItemInfo(final Item item) {
        if (item instanceof Food) {
            return getItemInfo((Food)item);
        } else {
            return getItemInfo((Toy)item);
        }
    }

    /**
     * Generates a string containing the information for a given food.
     * @param food - a food.
     * @return itemInfo - a string containing the information for a food, such as nutrition,
     * tastiness and meal size.
     */
    public static String getItemInfo(final Food food) {
        String itemInfo = "";
        itemInfo += "Food: " + food.toString() + "\r\n";
        if (food.toString() == "Medicine") {
            itemInfo += "Used to cure a pet if they become sick." + "\r\n"
                    + "Doesn't use up any actions.";
            return itemInfo;
        } else if (food.toString() == "Revival Medicine") {
            itemInfo += "Used to revive a pet if they die." + "\r\n" 
                    + "Can only be used to revive a pet once!";
            return itemInfo;
        }
        itemInfo += "Nutrition: " + toPercent(food.getNutrition()) + "\r\n";
        itemInfo += "Meal size: " + toPercent(food.getMealSize()) + "\r\n";
        itemInfo += "Tastiness: " + toPercent(food.getTastiness()) + "\r\n";
        itemInfo += getMostLikedByAnimals(food) + "\r\n";
        itemInfo += getLikedByAnimals(food);
        return itemInfo;
    }

    /**
     * Generates a string containing the information for a given toy.
     * @param toy - a toy.
     * @return itemInfo - a string containing the information for a toy, such as the name,
     * durability and the animals which like it the most.
     */
    public static String getItemInfo(final Toy toy) {
        String itemInfo = "";
        itemInfo += "Toy: " + toy.toString() + "\r\n";
        itemInfo += "Durability: " + toPercent(toy.getMaxDurability()) + "\r\n";
        itemInfo += getMostLikedByAnimals(toy) + "\r\n";
        itemInfo += getLikedByAnimals(toy);
        return itemInfo;
    }

}
