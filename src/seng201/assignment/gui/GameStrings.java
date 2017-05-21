package seng201.assignment.gui;
import java.util.ArrayList;

import seng201.assignment.*;

public class GameStrings {

	
	public static String getSpeciesStats(PetType type){
		Pet pet = type.create("pet");
		String speciesInfo = "";
		speciesInfo +="Favourite toy(s): " + stringOfToys(pet.getFavouriteToy()) + "\r\n";
		speciesInfo +="Favourite foods: " + stringOfFoods(pet.getFavouriteFood()) + "\r\n";
		speciesInfo +="Weight range: " + stringOfRange(pet.getSpeciesWeightRange()) + "\r\n";
		speciesInfo +="Playfulness range: " + stringOfRange(pet.getSpeciesPlayfulnessRange()) + "\r\n";
		speciesInfo +="Roughness range: " + stringOfRange(pet.getSpeciesRoughnessRange()) + "\r\n";
		speciesInfo +="Hunger rate range: " + stringOfRange(pet.getSpeciesHungerRateRange()) + "\r\n";
		speciesInfo +="Tiredness rate range: " + stringOfRange(pet.getSpeciesTiredRateRange()); //ad new line if extra added after
		return speciesInfo;
	}
	
	public static String getTypeSpecies(PetType type){
		return type.getName();
	}
	
	public static String getPetName(Pet pet){
		return pet.getName();
	}
	
	
	public static String getPetSickString(Pet pet){
		String sicknessString = "";
		if (pet.isSick()){
			sicknessString = String.format("\r\n%s is sick!", pet.getName());
		}
		return sicknessString;
	}
	
	public static String getPetMisbehavingString(Pet pet){
		String misbehavingString = "";
		if (pet.isMisbehaving()){
			misbehavingString = String.format("\r\n%s is misbehaving!", pet.getName());
		}
		return misbehavingString;
	}
	
	public static String stringOfToys(Toy[] toys){
		String toysString = toys[0].toString();
		
		for (int i = 1; i < toys.length; i++){
			toysString += ", " + toys[i].toString();
		}
		return toysString;
	}
	
	public static String stringOfFoods(Food[] foods){
		String foodsString = foods[0].toString();
		
		for (int i = 1; i < foods.length; i++){
			foodsString += ", " + foods[i].toString();
		}
		return foodsString;
	}
	
	
	public static String stringOfRange(float[] floats){
		return String.format("%.2fkg - %.2fkg", floats[0], floats[1]);
	}
	
	public static String stringOfRange(int[] ints){
		return String.format("%d%% - %d%%", ints[0] * 10, ints[1] * 10);
	}
	
	public static String getCurrentPlayerAndDay(Game game){
		return String.format("%s - Day %d of %d", game.getCurrentPlayer().getName(), game.getCurrentDay() + 1, game.getMaxDays());
	}
	
	
	
	public static ArrayList<ArrayList<String>> generateInventoryListofLists(ArrayList<Item> items){
		ArrayList<String> namesList = new ArrayList<String>();
		ArrayList<Integer> numberOfList = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < items.size(); i++){
			if (namesList.contains(items.get(i).toString())) {
			    int k = namesList.indexOf(items.get(i).toString());
				numberOfList.set(k, numberOfList.get(k) + 1);
			}
			else {
				namesList.add(j,items.get(i).toString());
				numberOfList.add(j, 1);
				j += 1;
			}
		}
		//new array - for ith value in names list pair it up with ith value in number list
		ArrayList<ArrayList<String>> finalList = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < namesList.size(); i++){
			ArrayList<String> temporaryArray = new ArrayList<String>();
			temporaryArray.add(namesList.get(i));
			temporaryArray.add(numberOfList.get(i).toString());
			finalList.add(temporaryArray);
		}
		
		
		return finalList;
		
	}
	
	
	/*public static String[][] generateInventoryList(Food[] foods){
		ArrayList<ArrayList<String>> foodsArrayList = new ArrayList<ArrayList<String>>();
		
		for (int i = 1; i < foods.length ; i++){
			if foods[i].toString() == 
		}
	}*/
	//public static String[][] generateInventoryList(String[] foods, ToyType[] toys){ //list of lists for both foods and toys [["bloodworm", 1],["tuna", "4"]]
	//	inventoryList
	//}
	
	public static String toPercent(int integer){
		integer*=10;
		if (integer > 100){
			integer = 100;
		}
		return String.format("%d%%", integer);
	}
	
	
	public static String getPetInfo(Pet pet){ //include status effect
		String petInfo = "";
		petInfo +="Species: " + pet.getSpecies() + "\r\n";
		petInfo +="Gender: " +pet.getGender() + "\r\n";
		petInfo +="Weight: " + String.format("%.2f", pet.getWeight()) + "\r\n";
		petInfo +="Favourite toy: " + stringOfToys(pet.getFavouriteToy()) + "\r\n"; //get favourite toy is list of toys
		petInfo +="Favourite food: " + stringOfFoods(pet.getFavouriteFood()) + "\r\n"; //get favourite food
		petInfo +="Hunger: " + toPercent(pet.getHunger()) + "\r\n";
		petInfo +="Toilet need: " + toPercent(pet.getToiletNeed()) + "\r\n";
		petInfo +="Tiredness: " + toPercent(pet.getTiredness()) + "\r\n";
		petInfo +="Healthiness: " + toPercent(pet.getHealth()) + "\r\n";
		petInfo +="Happiness: " + toPercent(pet.getHappiness()) + "\r\n";
		petInfo +="Playfulness: " + toPercent(pet.getPlayfulness()) + "\r\n";
		petInfo +="Roughness: " + toPercent(pet.getRoughness());
		petInfo += getPetSickString(pet);
		petInfo += getPetMisbehavingString(pet);
		return petInfo;
	}
	
	/*public static void main(String args[]){
		Dog Snuffles = new Dog("Snuffles", PetType.Dog);
		System.out.println(getPetInfo(Snuffles));
	}*/
	
	//get species info (weight range, etc.)
	//get specific pet stats
	//get pet name
	//get list of items and prices
	//

}
