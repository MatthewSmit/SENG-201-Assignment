package seng201.assignment.console;

import seng201.assignment.*;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Matthew on 20/04/17.
 */
public class ConsoleRunner {
    private static InputStreamReader reader = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(reader);

    public static void main(String[] args) {
        /*try {
            reader = new InputStreamReader(new FileInputStream("input.txt"));
            br = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }*/

        Game game = setupGame();

        while (game.isRunning()) {
            System.out.println(String.format("Player %s's turn, round %d/%d", game.getCurrentPlayer().getName(), game.getCurrentRound() + 1, game.getMaxRound()));
            System.out.println(String.format("Controlling pet %s, actions remaining: %d", game.getCurrentPet().getName(), game.getActionsLeft()));

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
                    game.endTurn();
                    break;
                default:
                    System.out.println("Invalid option");
                    System.exit(3);
                    break;
            }
        }
    }

    private static void displayStore(Player player) {
        System.out.println(String.format("Welcome to the store, you have $%d", player.getMoney()));

        int value = readInt("Do you want to buy (0) food or (1) toys?", 0, 1);

        if (value == 0) {
            while (true) {
                System.out.println("(0) Exit store");
                Food[] food = Food.values();
                for (int i = 0; i < food.length; i++) {
                    System.out.println(String.format("(%d) %s - $%d", i + 1, food[i].name(), food[i].getPrice()));
                }

                value = readInt("Choose index of item: ", 0, food.length);
                if (value == 0)
                    return;

                Food wantedFood = food[value - 1];
                if (player.getMoney() < wantedFood.getPrice()) {
                    System.out.println("You don't have enough money!");
                } else {
                    player.purchase(wantedFood);
                }
            }
        }
        else {
            while (true) {
                System.out.println("(0) Exit store");
                Toy[] toys = Toy.values();
                for (int i = 0; i < toys.length; i++) {
                    System.out.println(String.format("(%d) %s - $%d", i + 1, toys[i].name(), toys[i].getPrice()));
                }

                value = readInt("Choose index of item: ", 0, toys.length);
                if (value == 0)
                    return;

                Toy toy = toys[value - 1];
                if (player.getMoney() < toy.getPrice()) {
                    System.out.println("You don't have enough money!");
                } else {
                    player.purchase(toy);
                }
            }
        }
    }

    private static void processSleep(Game game) {
        if (game.getActionsLeft() == 0) {
            System.out.println("You have no actions left, end your turn!");
        }
        else {
            game.sleep();
        }
    }

    private static void processToilet(Game game) {
        if (game.getActionsLeft() == 0) {
            System.out.println("You have no actions left, end your turn!");
        }
        else {
            game.toilet();
        }
    }

    private static void processFeed(Game game) {
        ArrayList<Food> food = game.getCurrentPlayer().getFood();
        if (game.getActionsLeft() == 0) {
            System.out.println("You have no actions left, end your turn!");
        }
        else if (food.size() == 0) {
            System.out.println("You have no food, buy some first!");
        }
        else {
            System.out.println("What food do you want to feed your pet?");
            for (int i = 0; i < food.size(); i++) {
                System.out.println(String.format("(%d): %s", i, food.get(i).name()));
            }

            int value = readInt("Choose a food index: ", 0, food.size() - 1);
            game.feed(food.get(value));
            food.remove(value);
        }
    }

    private static void processPlay(Game game) {
        ArrayList<Toy> toys = game.getCurrentPlayer().getToys();
        if (game.getActionsLeft() == 0) {
            System.out.println("You have no actions left, end your turn!");
        }
        else if (toys.size() == 0) {
            System.out.println("You have no toys, buy some first!");
        }
        else {
            System.out.println("What toy do you want to play with your pet?");
            for (int i = 0; i < toys.size(); i++) {
                System.out.println(String.format("(%d): %s", i, toys.get(i).name()));
            }

            int value = readInt("Choose a toy index: ", 0, toys.size() - 1);
            game.play(toys.get(value));
            toys.remove(value);
        }
    }

    private static void displayPetStatus(Pet pet) {
        if (pet.getDeathState() == Pet.DeathState.PERMENANTLY_DEAD) {
            System.out.println(String.format("%s (%s) [DEAD]", pet.getName(), pet.getSpecies()));
        }
        else {
            System.out.println(String.format("%s (%s)", pet.getName(), pet.getSpecies()));
            System.out.println(String.format("Hunger: %d", pet.getHunger()));
            System.out.println(String.format("Tiredness: %d", pet.getTiredness()));
            System.out.println(String.format("Playfulness: %d", pet.getPlayfulness()));
            System.out.println(String.format("Toilet: %d", pet.getToiletNeed()));
            System.out.println(String.format("Weight: %d", pet.getWeight()));
            System.out.println(String.format("Has pet died: %s", pet.getDeathState() == Pet.DeathState.ALIVE ? "no" : "yes"));
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
                if (!ensureUniqueNames(players, null, name)) {
                    System.out.println("Name is already in use, try again");
                }
                else break;
            }
            int numberPets = readInt("Number of pets: ", 1, 3);

            Pet[] pets = new Pet[numberPets];
            players[i] = new Player(name, pets);

            for (int j = 0; j < numberPets; j++) {
                Class petType = choosePet();
                String petName;
                while (true) {
                    petName = readLine(String.format("Player %d's pet %d's name: ", i + 1, j + 1));
                    if (!ensureUniqueNames(players, pets, petName)) {
                        System.out.println("Name is already in use, try again");
                    }
                    else break;
                }

                try {
                    pets[j] = (Pet)petType.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(2);
                }
                pets[j].setName(petName);
            }
        }

        return new Game(days, players);
    }

    private static boolean ensureUniqueNames(Player[] players, Pet[] pets, String name) {
        if (players == null)
            return true;

        // Check if players or their pets have the same name
        for (Player player : players) {
            if (player != null) {
                String playerName = player.getName();
                if (playerName != null && playerName.equalsIgnoreCase(name))
                    return false;

                for (Pet pet : player.getPets()) {
                    if (pet != null) {
                        String petName = pet.getName();
                        if (petName != null && petName.equalsIgnoreCase(name))
                            return false;
                    }
                }
            }
        }

        // Check if player-less pets have the same name
        if (pets != null) {
            for (Pet pet : pets) {
                if (pet != null) {
                    String petName = pet.getName();
                    if (petName != null && petName.equalsIgnoreCase(name))
                        return false;
                }
            }
        }

        return true;
    }

    private static Class choosePet() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Game.getPetTypes().length; i++) {
            if (i > 0) {
                builder.append(", ");
            }

            builder.append('(');
            builder.append(i);
            builder.append(") ");
            builder.append(Game.getPetTypes()[i].getSimpleName());
        }

        System.out.print("Choose a pet, options are " + builder.toString() + ": ");

        while (true) {
            String value = readLine();
            for (int i = 0; i < Game.getPetTypes().length; i++) {
                if (Game.getPetTypes()[i].getSimpleName().equalsIgnoreCase(value)) {
                    return Game.getPetTypes()[i];
                }
            }

            try {
                int intValue = Integer.parseInt(value);
                if (intValue >= 0 && intValue < Game.getPetTypes().length) {
                    return Game.getPetTypes()[intValue];
                }
            }
            catch (Throwable ignored) {
            }

            System.out.println("Not a valid pet, try again");
            System.out.print("Choose a pet, options are " + builder.toString() + ": ");
        }
    }

    private static int readInt(String s, int lowest, int highest) {
        System.out.print(s);

        while (true) {
            String value = readLine();

            try {
                int intValue = Integer.parseInt(value);
                if (intValue < lowest) {
                    System.out.println(String.format("Number must be between %d and %d", lowest, highest));
                    System.out.print(s);
                }
                else if (intValue > highest) {
                    System.out.println(String.format("Number must be between %d and %d", lowest, highest));
                    System.out.print(s);
                }
                else return intValue;
            }
            catch (Throwable e) {
                System.out.println("Not a valid number, try again");
                System.out.print(s);
            }
        }
    }

    private static String readLine(String s) {
        System.out.print(s);

        while (true) {
            String value = readLine();
            if (value == null || value.trim().equals("")) {
                System.out.print("Please enter a value");
                System.out.print(s);
            }
            else {
                return value;
            }
        }
    }

    private static String readLine() {
        try
        {
            return br.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Unhandled exception: " + e.getLocalizedMessage());
            System.exit(1);
            return null;
        }
    }
}
