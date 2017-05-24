package seng201.assignment.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import seng201.assignment.Food;
import seng201.assignment.Game;
import seng201.assignment.Pet;
import seng201.assignment.PetType;
import seng201.assignment.Player;
import seng201.assignment.Toy;

/**
 * Runs the game using a console interface.
 */
public final class ConsoleRunner {
    private static InputStreamReader reader = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(reader);

    private ConsoleRunner() {
    }
    
    public static void main(final String[] args) {
        Game game = setupGame();

        while (game.isRunning()) {
            System.out.println();
            System.out.println(String.format("Player %s's turn, day %d/%d", game.getCurrentPlayer().getName(), game.getCurrentDay() + 1, game.getMaxDays()));
            System.out.println(String.format("Controlling pet %s, actions remaining: %d",
                                             game.getCurrentPet().getName(), game.getCurrentPet().getActionsLeft()));

            switch (game.getCurrentPet().getEventState()) {
                case NoEvent:
                    break;
                case Misbehaving:
                    System.out.println(String.format("Pet %s has started misbehaving!", game.getCurrentPet().getName()));
                    break;
                case Sick:
                    System.out.println(String.format("Pet %s has gotten sick!", game.getCurrentPet().getName()));
                    break;
                case Dead:
                    System.out.println(String.format("Pet %s has died!", game.getCurrentPet().getName()));
                    if (game.getCurrentPet().getDeathState() == Pet.DeathState.PERMANENTLY_DEAD) {
                        System.out.println("Your pet is now permenantly dead!");
                    } else {
                        //reviving?
                        System.out.println("You have revived your pet, you can only do this once!");
                    }
                    break;
                default:
                    assert false;
                    break;
            }



            System.out.println("(0): View pet status");
            System.out.println("(1): Visit store");
            System.out.println(String.format("(2): Feed %s", game.getCurrentPet().getName()));
            System.out.println(String.format("(3): Play with %s", game.getCurrentPet().getName()));
            System.out.println(String.format("(4): Put %s to sleep", game.getCurrentPet().getName()));
            System.out.println(String.format("(5): Let %s go toilet", game.getCurrentPet().getName()));
            System.out.println("(6): End Turn");

            switch (readInt("Choose an action: ", 0, 6)) {
                case 0:
                    displayPetStatus(game.getCurrentPet());
                    break;
                case 1:
                    displayStore(game.getCurrentPlayer());
                    break;
                case 2:
                    processFeed(game);
                    break;
                case 3:
                    processPlay(game);
                    break;
                case 4:
                    processSleep(game);
                    break;
                case 5:
                    processToilet(game);
                    break;
                case 6:
                    if (game.getCurrentPetIndex() + 1 == game.getCurrentPlayer().getPets().length) {
                        game.endTurn();
                        game.setCurrentPetIndex(0);
                    } else {
                        game.setCurrentPetIndex(game.getCurrentPetIndex() + 1);
                        System.out.println(String.format("Now controlling pet %s.", game.getCurrentPet().getName()));
                    }
                    break;
                default:
                    System.out.println("Invalid option");
                    System.exit(3);
                    break;
            }

        }

        System.out.println("Game has ended.");
    }

    private static void displayStore(final Player player) {

        System.out.println();
        System.out.println(String.format("Welcome to the store, you have $%d", player.getMoney()));

        int value = readInt("Do you want to buy (0) food or (1) toys?", 0, 1);
        System.out.println();

        if (value == 0) {
            while (true) {
                System.out.println("(0) Exit store");
                Food[] food = Food.values();
                for (int i = 0; i < food.length; i++) {
                    System.out.println(String.format("(%d) %s - $%d", i + 1, food[i].toString(), food[i].getPrice()));
                }

                value = readInt("Choose index of item: ", 0, food.length);
                if (value == 0) {
                    return;
                }

                Food wantedFood = food[value - 1];
                if (player.getMoney() < wantedFood.getPrice()) {
                    System.out.println("You don't have enough money!");
                } else {
                    player.purchase(wantedFood);
                    System.out.println();
                    System.out.println(String.format("You have $%d remaining", player.getMoney()));
                }
            }
        } else {
            while (true) {
                System.out.println("(0) Exit store");
                Toy[] toys = Toy.values();
                for (int i = 0; i < toys.length; i++) {
                    System.out.println(String.format("(%d) %s - $%d", i + 1, toys[i].toString(), toys[i].getPrice()));
                }

                value = readInt("Choose index of item: ", 0, toys.length);
                if (value == 0) {
                    return;
                }

                Toy toy = toys[value - 1];
                if (player.getMoney() < toy.getPrice()) {
                    System.out.println("You don't have enough money!");
                } else {
                    player.purchase(toy);
                    System.out.println();
                    System.out.println(String.format("You have $%d remaining", player.getMoney()));
                }
            }
        }
    }

    private static void processSleep(final Game game) {
        System.out.println();
        System.out.println(String.format("%s goes to sleep.", game.getCurrentPet().getName()));
        if (game.getCurrentPet().getActionsLeft() == 0) {
            System.out.println("You have no actions left, end your turn!");
        } else {
            game.sleep();
        }
    }

    private static void processToilet(final Game game) {
        System.out.println();
        System.out.println(String.format("%s goes to the toilet.", game.getCurrentPet().getName()));
        if (game.getCurrentPet().getActionsLeft() == 0) {
            System.out.println("You have no actions left, end your turn!");
        } else {
            game.toilet();
        }
    }

    private static void processFeed(final Game game) {

        System.out.println();
        ArrayList<Food> food = game.getCurrentPlayer().getFood();
        if (game.getCurrentPet().getActionsLeft() == 0) {
            System.out.println("You have no actions left, end your turn!");
        } else if (food.size() == 0) {
            System.out.println("You have no food, buy some first!");
        } else {
            System.out.println("What food do you want to feed your pet?");
            for (int i = 0; i < food.size(); i++) {
                System.out.println(String.format("(%d): %s", i, food.get(i).toString()));
            }

            int value = readInt("Choose a food index: ", 0, food.size() - 1);
            game.feed(food.get(value));
            System.out.println(String.format("%s eats %s.", game.getCurrentPet().getName(), food.get(value).toString()));
            food.remove(value);
        }
    }

    private static void processPlay(final Game game) {

        System.out.println();
        ArrayList<Toy> toys = game.getCurrentPlayer().getToys();
        //System.out.println();
        if (game.getCurrentPet().getActionsLeft() == 0) {
            System.out.println("You have no actions left, end your turn!");
        } else if (toys.size() == 0) {
            System.out.println("You have no toys, buy some first!");
        } else {
            System.out.println(String.format("What toy do you want to play with %s?", game.getCurrentPet().getName()));
            //System.out.println("What toy do you want to play with your pet?");
            for (int i = 0; i < toys.size(); i++) {
                System.out.println(String.format("(%d): %s", i, toys.get(i).toString()));
            }

            int value = readInt("Choose a toy index: ", 0, toys.size() - 1);
            game.play(toys.get(value));
            System.out.println(String.format("%s plays with %s.", game.getCurrentPet().getName(), toys.get(value).toString()));
            if (toys.get(value).getDurability() <= 0) {
                toys.remove(value);
            }

        }
    }

    private static void displayPetStatus(final Pet pet) {
        if (pet.isDead()) {
            System.out.println(String.format("%s (%s) [DEAD]", pet.getName(), pet.getSpecies()));
        } else {
            System.out.println();
            System.out.println(String.format("%s (%s)", pet.getName(), pet.getSpecies()));
            System.out.println(String.format("Gender: %s", pet.getGender()));
            System.out.println(String.format("Hunger: %d", pet.getHunger()));
            System.out.println(String.format("Tiredness: %d", pet.getTiredness()));
            System.out.println(String.format("Toilet: %d", pet.getToiletNeed()));
            System.out.println(String.format("Happiness: %d", pet.getHappiness()));
            System.out.println(String.format("Health: %d", pet.getHealth()));
            System.out.println(String.format("Weight: %.2f", pet.getWeight()));
            System.out.println(String.format("Has pet died: %s", pet.getDeathState() == Pet.DeathState.ALIVE ? "no" : "yes"));
            //System.out.println();
        }
    }

    private static Game setupGame() {
        int numberPlayers = readInt("Number of Players: ", 1, 3);
        int days = readInt("Days to play for: ", 1, Integer.MAX_VALUE);

        Player[] players = new Player[numberPlayers];
        for (int i = 0; i < numberPlayers; i++) {
            String name;
            while (true) {
                name = readLine(String.format("Player %d's name: ", i + 1));
                if (detectNameConflicts(players, null, name)) {
                    System.out.println("Name is already in use, try again");
                } else {
                    break;
                }
            }
            int numberPets = readInt("Number of pets: ", 1, 3);

            Pet[] pets = new Pet[numberPets];
            players[i] = new Player(name, pets);

            for (int j = 0; j < numberPets; j++) {
                PetType petType = choosePet();
                String petName;
                while (true) {
                    petName = readLine(String.format("Player %d's pet %d's name: ", i + 1, j + 1));
                    if (detectNameConflicts(players, pets, petName)) {
                        System.out.println("Name is already in use, try again");
                    } else {
                        break;
                    }
                }

                pets[j] = petType.create(petName);
            }
        }

        return new Game(days, players);
    }

    private static boolean detectNameConflicts(final Player[] players, final Pet[] pets, final String name) {
        if (players == null) {
            return false;
        }

        // Check if players or their pets have the same name
        for (Player player : players) {
            if (player != null) {
                String playerName = player.getName();
                if (playerName != null && playerName.equalsIgnoreCase(name)) {
                    return true;
                }

                for (Pet pet : player.getPets()) {
                    if (pet != null) {
                        String petName = pet.getName();
                        if (petName != null && petName.equalsIgnoreCase(name)) {
                            return true;
                        }
                    }
                }
            }
        }

        // Check if player-less pets have the same name
        if (pets != null) {
            for (Pet pet : pets) {
                if (pet != null) {
                    String petName = pet.getName();
                    if (petName != null && petName.equalsIgnoreCase(name)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static PetType choosePet() {
        PetType[] petTypes = PetType.values();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < petTypes.length; i++) {
            if (i > 0) {
                builder.append(", ");
            }

            builder.append('(');
            builder.append(i);
            builder.append(") ");
            builder.append(petTypes[i].getName());
        }

        System.out.print("Choose a pet, options are " + builder.toString() + ": ");

        while (true) {
            String value = readLine();
            for (PetType type : petTypes) {
                if (type.getName().equalsIgnoreCase(value)) {
                    return type;
                }
            }

            try {
                int intValue = Integer.parseInt(value);
                if (intValue >= 0 && intValue < petTypes.length) {
                    return petTypes[intValue];
                }
            } catch (Throwable ignored) {
            }

            System.out.println("Not a valid pet, try again");
            System.out.print("Choose a pet, options are " + builder.toString() + ": ");
        }
    }

    private static int readInt(final String s, final int lowest, final int highest) {
        System.out.print(s);

        while (true) {
            String value = readLine();

            try {
                int intValue = Integer.parseInt(value);
                if (intValue < lowest) {
                    System.out.println(String.format("Number must be between %d and %d", lowest, highest));
                    System.out.print(s);
                } else if (intValue > highest) {
                    System.out.println(String.format("Number must be between %d and %d", lowest, highest));
                    System.out.print(s);
                } else {
                    return intValue;
                }
            } catch (Throwable e) {
                System.out.println("Not a valid number, try again");
                System.out.print(s);
            }
        }
    }

    private static String readLine(final String s) {
        System.out.print(s);

        while (true) {
            String value = readLine();
            if (value == null || value.trim().equals("")) {
                System.out.print("");
                System.out.print(s);
            } else {
                return value;
            }
        }
    }

    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("Unhandled exception: " + e.getLocalizedMessage());
            System.exit(1);
            return null;
        }
    }
}
