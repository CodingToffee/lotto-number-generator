package com.lotto;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String filename = "badLuckNumbers.ser";
        File storageFile = new File(filename);
        BadLuckNumberHandler badLuckNumberHandler = null;

        // Deserialize bad luck numbers
        if (storageFile.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
                badLuckNumberHandler = (BadLuckNumberHandler) in.readObject();
                System.out.println("Object has been deserialized!");
                System.out.println("Data: " + badLuckNumberHandler);
            } catch (IOException | ClassNotFoundException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
        else {
            try {
                badLuckNumberHandler = new BadLuckNumberHandler(args);
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }

        // Get user input for choosing which numbers to generate
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose which numbers to be generated. Type in \"6outof49\" or \"Eurojackpot\"");
        String lottoParameter = scanner.nextLine();

        // Generate numbers based on user input
        if (lottoParameter.equals("6outof49") || lottoParameter.equals("")) {
            SixOutOfFortyNine sixOutOfFortyNine = new SixOutOfFortyNine(badLuckNumberHandler.getBadLuckNumbers());
            System.out.println("Generated tipping numbers for 6 out of 49:" + sixOutOfFortyNine.getTippingNumbers());
        } else if (lottoParameter.equals("Eurojackpot")) {
            EuroJackpot euroJackpot = new EuroJackpot(badLuckNumberHandler.getBadLuckNumbers());
            System.out.println("Generated tipping numbers for Eurojackpot (2 out of 10): " + euroJackpot.getTwoOutOfTen());
            System.out.println("Generated tipping numbers for Eurojackpot (5 out of 50): " + euroJackpot.getFiveOutOfFifty());
        } else {
            logger.log(Level.WARNING, "No valid input for kind of game.");
            System.out.println("Error: Please use \"6outof49\" or \"Eurojackpot\" as input parameter.");
        }

        // Serialize bad luck numbers
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(badLuckNumberHandler);
            System.out.println("Object has been serialized to " + filename);
            logger.log(Level.INFO, "Object has been serialized to " + filename);
        } catch (IOException e) {
            logger.log(Level.INFO, e.getMessage());
        }
    }
}
