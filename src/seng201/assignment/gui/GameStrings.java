package seng201.assignment.gui;

import java.util.ArrayList;

import seng201.assignment.*;
import seng201.assignment.Lists;


final class GameStrings {
    private GameStrings() {
    }

    public static String getSpeciesStats(PetType type){
        Pet pet = type.create("pet");
        String speciesInfo = "";
        speciesInfo += "Favourite toy(s): " + stringOfToys(type.getFavouriteToys()) + "\r\n";
        speciesInfo += "Favourite foods: " + stringOfFoods(type.getFavouriteFoods()) + "\r\n";
        speciesInfo += "Weight range: " + stringOfRange(pet.getSpeciesWeightRange()) + "\r\n";
        speciesInfo += "Playfulness range: " + stringOfRange(pet.getSpeciesPlayfulnessRange()) + "\r\n";
        speciesInfo += "Roughness range: " + stringOfRange(pet.getSpeciesRoughnessRange()) + "\r\n";
        speciesInfo += "Hunger rate range: " + stringOfRange(pet.getSpeciesHungerRateRange()) + "\r\n";
        speciesInfo += "Tiredness rate range: " + stringOfRange(pet.getSpeciesTiredRateRange()); //ad new line if extra added after
        return speciesInfo;
    }

    public static String getTypeSpecies(final PetType type) {
        return type.getName();
    }

    public static String getPetName(final Pet pet) {
        return pet.getName();
    }


    public static String getPetDeadString(final Pet pet) {
        String deadString = "";
        if (pet.isDead()) {
            deadString = String.format("\r\n%s is dead!", pet.getName());
        }
        return deadString;
    }

    public static String getPetSickString(final Pet pet) {
        String sicknessString = "";
        if (pet.isSick()) {
            sicknessString = String.format("\r\n%s is sick!", pet.getName());
        }
        return sicknessString;
    }

    public static String getPetMisbehavingString(final Pet pet) {
        String misbehavingString = "";
        if (pet.isMisbehaving()) {
            misbehavingString = String.format("\r\n%s is misbehaving!", pet.getName());
        }
        return misbehavingString;
    }

    public static String stringOfToys(final Toy[] toys) {
        String toysString = toys[0].toString();

        for (int i = 1; i < toys.length; i++) {
            toysString += ", " + toys[i].toString();
        }
        return toysString;
    }

    public static String stringOfFoods(final Food[] foods) {
        String foodsString = foods[0].toString();

        for (int i = 1; i < foods.length; i++) {
            foodsString += ", " + foods[i].toString();
        }
        return foodsString;
    }


    public static String stringOfRange(final float[] floats) {
        return String.format("%.2fkg - %.2fkg", floats[0], floats[1]);
    }

    public static String stringOfRange(final int[] ints) {
        return String.format("%d%% - %d%%", ints[0] * 10, ints[1] * 10);
    }

    public static String getCurrentPlayerAndDay(final Game game) {
        if (game.getCurrentDay() + 1 > game.getMaxDays()) {
            return "GAMEEND"; //number of days passed is more than max days
        } else {
            return String.format("%s - Day %d of %d", game.getCurrentPlayer().getName(), game.getCurrentDay() + 1, game.getMaxDays());
        }
    }

    /*public static String getMostLikedByAnimals(Food food){
    	String mostLikedBy = "Most liked by: - ";
    	for (PetType type : PetType.values()) {
    		if (type.getFavouriteFood()[0] == food){
        		mostLikedBy="Most liked by: " + type.getName() + "\r\n";
        		break;
        	}
    	}
    	return mostLikedBy;
    	
    }*/
    
    public static String getMostLikedByAnimals(Food food){
    	
    	ArrayList<String> mostLikedByList = new ArrayList<String>();
    	String mostLikedBy = "Most liked by: - ";
    	for (PetType type : PetType.values()) {
    		if (type.getFavouriteFoods()[0] == food){
    			mostLikedByList.add(type.getName());
        	}
    	}
    	if (mostLikedByList.size() > 0){
    		mostLikedBy = "Most liked by: " + mostLikedByList.get(0);
    		for (int i = 1; i < mostLikedByList.size(); i++){
    			mostLikedBy+=", " + mostLikedByList.get(i);
    		}
    	}
    	return mostLikedBy;
    	
    }
    
    public static String getMostLikedByAnimals (Toy toy){
    	ArrayList<String> mostLikedByList = new ArrayList<String>();
    	String mostLikedBy = "Most liked by: - ";
    	for (PetType type : PetType.values()) {
    		if (type.getFavouriteToys()[0] == toy){
    			mostLikedByList.add(type.getName());
        	}
    	} 
    	
    	if (mostLikedByList.size() > 0){
    		mostLikedBy = "Most liked by: " + mostLikedByList.get(0);
    		for (int i = 1; i < mostLikedByList.size(); i++){
    			mostLikedBy+=", " + mostLikedByList.get(i);
    		}
    	}
    	return mostLikedBy;
    }
    
    public static String getLikedByAnimals(Food food){
    	
    	ArrayList<String> alsoLikedByList = new ArrayList<String>();
    	String alsoLikedBy = "Also liked by: - ";
    	for (PetType type : PetType.values()) {
    		if (food != type.getFavouriteFoods()[0] && Lists.contains(type.getFavouriteFoods(), food)){
        		alsoLikedByList.add(type.getName());
        	}
    	}
    	if (alsoLikedByList.size() > 0){
    		alsoLikedBy = "Also liked by: " + alsoLikedByList.get(0);
    		for (int i = 1; i < alsoLikedByList.size(); i++){
    			alsoLikedBy+=", " + alsoLikedByList.get(i);
    		}
    	}
    	return alsoLikedBy;
    	
    }
    
    public static String getLikedByAnimals(Toy toy){
    	
    	ArrayList<String> alsoLikedByList = new ArrayList<String>();
    	String alsoLikedBy = "Also liked by: - ";
    	for (PetType type : PetType.values()) {
    		if (toy != type.getFavouriteToys()[0] && Lists.contains(type.getFavouriteToys(), toy)){
        		alsoLikedByList.add(type.getName());
        	}
    	}
    	if (alsoLikedByList.size() > 0){
    		alsoLikedBy = "Also liked by: " + alsoLikedByList.get(0);
    		for (int i = 1; i < alsoLikedByList.size(); i++){
    			alsoLikedBy+=", " + alsoLikedByList.get(i);
    		}
    	}
    	return alsoLikedBy;
    	
    }


    public static ArrayList<ArrayList<String>> generateInventoryListofLists(final ArrayList<Item> items) {
        ArrayList<String> namesList = new ArrayList<String>();
        ArrayList<Integer> numberOfList = new ArrayList<Integer>();
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
        //new array - for ith value in names list pair it up with ith value in number list
        ArrayList<ArrayList<String>> finalList = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < namesList.size(); i++) {
            ArrayList<String> temporaryArray = new ArrayList<String>();
            temporaryArray.add(namesList.get(i));
            temporaryArray.add(numberOfList.get(i).toString());
            finalList.add(temporaryArray);
        }


        return finalList;

    }

    public static String toPercent(int integer) {
        integer *= 10;
        if (integer > 100) {
            integer = 100;
        }
        return String.format("%d%%", integer);
    }


	public static String getPetInfo(Pet pet){ //include status effect
		String petInfo = "";
		petInfo +="Species: " + pet.getSpecies() + "\r\n";
		petInfo +="Gender: " +pet.getGender() + "\r\n";
		petInfo +="Weight: " + String.format("%.2f", pet.getWeight()) + "kg\r\n";
		petInfo +="Hunger: " + toPercent(pet.getHunger()) + "\r\n";
		petInfo +="Toilet need: " + toPercent(pet.getToiletNeed()) + "\r\n";
		petInfo +="Tiredness: " + toPercent(pet.getTiredness()) + "\r\n";
		petInfo +="Healthiness: " + toPercent(pet.getHealth()) + "\r\n";
		petInfo +="Happiness: " + toPercent(pet.getHappiness()) + "\r\n";
		petInfo +="Playfulness: " + toPercent(pet.getPlayfulness()) + "\r\n";
		petInfo +="Roughness: " + toPercent(pet.getRoughness())  + "\r\n";
		petInfo +="Favourite toy: " + stringOfToys(pet.getType().getFavouriteToys()) + "\r\n"; //get favourite toy is list of toys
		petInfo +="Favourite food: " + stringOfFoods(pet.getType().getFavouriteFoods()); //get favourite food
        if (pet.isDead()) {
            petInfo += getPetDeadString(pet);
        } else {
            petInfo += getPetSickString(pet);
            petInfo += getPetMisbehavingString(pet);
        }
        return petInfo;
    }
	
	
	public static String getItemInfo(Item item){
		if (item instanceof Food){
			return getItemInfo((Food) item);
		}
		else {
			return getItemInfo((Toy) item);
		}
	}
	
	
	public static String getItemInfo(Food food){
		String itemInfo = "";
		itemInfo += "Food: " + food.toString() + "\r\n";
		if (food.toString() == "medicine"){
			itemInfo+= "Used to cure a pet if they become sick." + "\r\n" + 
						"Doesn't use up any actions.";
			return itemInfo;
		}
		else if (food.toString() == "revival medicine"){
			itemInfo+="Used to revive a pet if they die." + "\r\n" +
					  "Can only be used to revive a pet once!";
			return itemInfo;
		}
		itemInfo += "Nutrition: " + toPercent(food.getNutrition()) + "\r\n";
		itemInfo += "Meal size: " + toPercent(food.getMealSize()) + "\r\n";
		itemInfo += "Tastiness: " + toPercent(food.getTastiness())+ "\r\n";
		itemInfo += getMostLikedByAnimals(food) + "\r\n";
		itemInfo += getLikedByAnimals(food);
		return itemInfo;
	}
	
	
	public static String getItemInfo(Toy toy){
		String itemInfo = "";
		itemInfo += "Food: " + toy.toString() + "\r\n";
		itemInfo += "Durability: " + toPercent(toy.getMaxDurability()) + "\r\n";
		itemInfo += getMostLikedByAnimals(toy) + "\r\n";
		itemInfo += getLikedByAnimals(toy);
		return itemInfo;
	}
	
	/*public static String getItemInfo(Toy toy){
		
	}*/
}
