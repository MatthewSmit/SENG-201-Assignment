package seng201.assignment.gui;
import java.util.ArrayList;

import seng201.assignment.*;

public class GameStrings {

	
	public static String getSpeciesStatistics(Pet pet){
		String speciesInfo = "";
		speciesInfo +="Species name: " + pet.getSpecies() + "\r\n";
		speciesInfo +="Favourite toy: " + pet.getFavouriteToy() + "\r\n";
		speciesInfo +="Favourite food: " + pet.getFavouriteFood() + "\r\n";
		speciesInfo +="Weight range: " + pet.getSpeciesWeightRange() + "\r\n";
		speciesInfo +="Playfulness range: " + pet.getSpeciesPlayfulnessRange() + "\r\n";
		speciesInfo +="Roughness range: " + pet.getSpeciesRoughnessRange() + "\r\n";
		speciesInfo +="Hunger rate range: " + pet.getSpeciesHungerRateRange() + "\r\n";
		speciesInfo +="Tiredness rate range: " + pet.getSpeciesTiredRateRange(); //ad new line if extra added after
		
		return speciesInfo;
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
	
	public static String stringOfToys(ToyType[] toys){
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
	
	
	//ArrayList<Toy> toys = game.getCurrentPlayer().getToys();
	//ArrayList<Food> food = game.getCurrentPlayer().getFood();
	
	//list of lists for both foods and toys  - [["bloodworm", 1, -1],["tuna", 4, -1]]
	//[[SQUEAKY TOY, 2, 5], [SMALL BALL, 3, 4]]
	//if durability hits 0 on toy (or food consumed)
	//then get rid of item
	
	
	//ArrayList of items - contain both toys and foods
	//created listed out in order of bought
	//can create a list of names of items + number of each item ([[bloodworm, 5], [squeaky toy, 3]])
	//and modify durabilty of specific toys dependent on whether or not they've been used
	
	//[BLOODWORM, SQUEAKY TOY, STEAK, SQUEAKY TOY]
	
	public static ArrayList<ArrayList<String>> generateInventoryListofLists(ArrayList<Item> items){
		ArrayList<String> namesList = new ArrayList<String>();
		ArrayList<Integer> numberOfList = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < items.size(); i++){
			if (namesList.contains(items.get(i).toString())){
				numberOfList.set(i, numberOfList.get(i)+1);
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
	
	public static String getPetInfo(Pet pet){ //include status effect
		String petInfo = "";
		petInfo +="Name: " + getPetName(pet) + "\r\n";
		petInfo +="Species: " + pet.getSpecies() + "\r\n";
		petInfo +="Gender: " +pet.getGender() + "\r\n";
		petInfo +="Weight: " + String.format("%.2f", pet.getWeight()) + "\r\n";
		petInfo +="Favourite toy: " + stringOfToys(pet.getFavouriteToy()) + "\r\n"; //get favourite toy is list of toys
		petInfo +="Favourite food: " + stringOfFoods(pet.getFavouriteFood()) + "\r\n"; //get favourite food
		petInfo +="Hunger: " + pet.getHunger() + "\r\n";
		petInfo +="Tiredness: " + pet.getTiredness() + "\r\n";
		petInfo +="Playfulness: " + pet.getPlayfulness() + "\r\n";
		petInfo +="Roughness: " + pet.getRoughness();
		petInfo += getPetSickString(pet);
		petInfo += getPetMisbehavingString(pet);
		return petInfo;
	}
	
	public static void main(String args[]){
		Dog Snuffles = new Dog("Snuffles");
		System.out.println(getPetInfo(Snuffles));
	}
	
	//get species info (weight range, etc.)
	//get specific pet stats
	//get pet name
	//get list of items and prices
	//

}
