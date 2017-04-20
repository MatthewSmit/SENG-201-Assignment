package seng201.assignment;

import java.util.Random;

/**
 * Created by Matthew on 12/04/2017.
 */
public abstract class Pet {
    private int hunger;
    private int tiredness;
    private int toiletNeed;
    private int health;
    private boolean died;
    private String name;
    
    
    private int hungerRate;
    private int tiredRate;
    private int playfulness;
    private int roughness;
    private float weight; //float as actual kg representation - e.g. dog - 13.5kg weight

    
    protected static Random rn = new Random();
    
    
    //hunger = 0->10;
    //0 playfulness = low playfulness, 0 roughness = low roughness
    Pet(String name){
    	this.name = name;
    	hunger = 0;
    	tiredness = 0;
    	toiletNeed = 0;
    	health = 10;
    	died = false;
    	playfulness = getSpeciesPlayfulness();
    	roughness = getSpeciesRoughness();
    	hungerRate = getSpeciesHungerRate();
    	tiredRate = getSpeciesTiredRate();
    	weight = getSpeciesInitialWeight();
    	
    }
    
    
    public void feed(Food food) {
    //	System.out.println(this.name + " eats " + food.name);
    }

    public void play(Toy toy) {
    }

    public void sleep() {
    }

    public void toilet() {
    }

    public void misbehave() {
    }

    public void sickness() {
    }

    public void die() {
    }

    public int getHunger() {
        return hunger;
    }

    public int getTiredness() {
        return tiredness;
    }

    public int getPlayfulness() {
        return playfulness;
    }

    public int getRoughness() {
        return roughness;
    }

    public int getToiletNeed() {
        return toiletNeed;
    }

    public int getHealth() {
        return health;
    }
    
    private float getWeight() {
    	return weight;
    }

    public boolean hasDied() {
        return died;
    }

    public String getName() {
        return name;
    }
    

    protected abstract String getSpecies();
    
    protected abstract Toy[] getFavouriteToy();
    
    /*protected abstract int getSpeciesPlayfulness();
    
    protected abstract int getSpeciesRoughness();
    
    protected abstract int getSpeciesHungerRate();
    
    protected abstract int getSpeciesTiredRate();*/
    
    //protected abstract float getSpeciesInitialWeight();
    protected abstract float[] getSpeciesWeightRange();
    
    protected abstract int[] getSpeciesPlayfulnessRange();
    
    protected abstract int[] getSpeciesRoughnessRange();
    
    protected abstract int[] getSpeciesHungerRateRange();
    
    protected abstract int[] getSpeciesTiredRateRange();
    
    //random.nextInt(max - min + 1) + min
    private int getSpeciesPlayfulness(){
    	int[] playfulnessRange = getSpeciesPlayfulnessRange();
    	return rn.nextInt(playfulnessRange[1] - playfulnessRange[0] + 1) + playfulnessRange[0];
    }
    
    private int getSpeciesRoughness(){
    	int[] roughnessRange = getSpeciesRoughnessRange();
    	return rn.nextInt(roughnessRange[1] - roughnessRange[0] + 1) + roughnessRange[0];
    }
    
    private int getSpeciesHungerRate(){
    	int[] hungerRateRange = getSpeciesHungerRateRange();
    	return rn.nextInt(hungerRateRange[1] - hungerRateRange[0] + 1) + hungerRateRange[0];
    }
    
    private int getSpeciesTiredRate(){
    	int[] tiredRateRange = getSpeciesTiredRateRange();
    	return rn.nextInt(tiredRateRange[1] - tiredRateRange[0] + 1) + tiredRateRange[0];
    }
    
	private float getSpeciesInitialWeight(){
		float[] weightRange = getSpeciesWeightRange();
		float initialWeight = rn.nextFloat() * (weightRange[1] - weightRange[0]) + weightRange[0];
		return initialWeight;
	}
    
    
}
