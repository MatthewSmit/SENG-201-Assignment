package seng201.assignment;

/**
 * Created by Programmdude on 27/04/2017.
 */
public class Toy extends Item {
    //price, durability = 1->10 (1 lowest, 10 highest)
    public static final Toy SMALLBALL     = new Toy("small ball", 3, 8);
    public static final Toy LARGEBALL     = new Toy("large ball", 5, 9);
    public static final Toy SQUEAKYTOY    = new Toy("squeaky toy", 8, 5);
    public static final Toy GUINEAPIGWHEEL= new Toy("guinea pig wheel", 7, 7);
    public static final Toy JUNGLEGYM     = new Toy("jungle gym", 8, 5);
    public static final Toy CARDBOARDBOX  = new Toy("cardboard box", 1, 2);
    
    private static final Toy[] values = new Toy[]{
            SMALLBALL,
            LARGEBALL,
            SQUEAKYTOY,
            GUINEAPIGWHEEL,
            JUNGLEGYM,
            CARDBOARDBOX
    };
    
    private final String toyName;
    private final int price;
    private final int maxDurability;

    private int durability;

    private Toy(String name, int price, int maxDurability) {
        this.toyName = name;
        this.price = price;
        this.maxDurability = maxDurability;
        durability = maxDurability;
    }

    public void degrade(Pet pet) {
        if (this.durability <= 0) {
            throw new UnsupportedOperationException("Can't play with a broken toy!");
        }

        else if (this.durability - pet.getRoughness() < 0) {
            this.durability = 0;
        }

        else {
            this.durability = durability-pet.getRoughness();
        }
    }

    public boolean isBroken() {
        return durability <= 0;
    }

    @Override
    public Toy clone() {
        return new Toy(toyName, price, maxDurability);
    }

    @Override
    public int getPrice(){
        return price;
    }

    public int getDurability(){
        return durability;
    }

    public int getMaxDurability(){
        return maxDurability;
    }
    
    @Override
    public String toString(){
        return toyName;
    }
    
    public static Toy[] values() {
        return values;
    }
}