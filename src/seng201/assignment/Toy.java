package seng201.assignment;

/**
 * Created by Programmdude on 27/04/2017.
 */
public class Toy extends Item {
    private ToyType type;
    private int durability;

    public Toy(ToyType type) {
        this.type = type;
        durability = type.getDurability();
    }

    public void degrade(Pet pet) {

        if (this.durability <= 0){
            throw new UnsupportedOperationException("Can't play with a broken toy!");
        }

        else if (this.durability - pet.getRoughness() < 0){
            this.durability = 0;
        }

        else {
            this.durability = durability-pet.getRoughness();
        }

        System.out.println(type.name().toLowerCase() + " has degraded to " + getDurability() + " durability.");
    }

    public boolean isBroken() {
        if (durability <= 0){
            System.out.println(type.name()  + " is broken!");
        }
        return durability <= 0;
    }

    public int getDurability(){
        return durability;
    }
    
    @Override
    public int getPrice() {
        return type.getPrice();
    }
    
    @Override
    public String toString() {
        return type.toString();
    }

    public ToyType getType() { return type; }
}