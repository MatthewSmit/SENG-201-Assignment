package seng201.assignment;

public enum PetType {
	Dog("Dog", "dog.png"),
	Cat("Cat", "cat.png"),
	Bird("Bird", "bird.png"),
	Goldfish("Goldfish", "goldfish.png"),
	Rabbit("Rabbit", "rabbit.png"),
	GuineaPig("Guinea Pig", "guineapig.png");

	private final String name;
	private final String imageFile;
	
	PetType(String name, String imageFile) {
		this.name = name;
		this.imageFile = imageFile;
	}
	
	public String getImageFile() {
		return imageFile;
	}
	public String getName() {
		return name;
	}
}
