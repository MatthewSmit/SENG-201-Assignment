package seng201.assignment;

import java.lang.reflect.Constructor;

public enum PetType {
	Dog("Dog", "dog.png", Dog.class),
	Cat("Cat", "cat.png", Cat.class),
	Bird("Bird", "bird.png", Bird.class),
	Goldfish("Goldfish", "goldfish.png", Goldfish.class),
	Rabbit("Rabbit", "rabbit.png", Rabbit.class),
	GuineaPig("Guinea Pig", "guineapig.png", GuineaPig.class);

	private final String name;
	private final String imageFile;
	private final Class<? extends Pet> petClass;
	
	PetType(String name, String imageFile, Class<? extends Pet> petClass) {
		this.name = name;
        this.imageFile = imageFile;
        this.petClass = petClass;
	}
	
	public String getImageFile() {
		return imageFile;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<? extends Pet> getPetClass() {
	    return petClass;
	}
	
	public Pet create(String name) {
        try {
            Constructor<? extends Pet> constructor = petClass.getConstructor(String.class, PetType.class);
            constructor.setAccessible(true);
            return (Pet)constructor.newInstance(name, this);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
	}
}
