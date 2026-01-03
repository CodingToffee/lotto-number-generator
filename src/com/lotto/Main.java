package com.lotto;

import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //convert

        System.out.println("Please choose which numbers to be generated. Type in \"6outof49\" or \"Eurojackpot\"");
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.println("Enter your name:");
        String lottoParameter = scanner.nextLine(); // Read user input (String)

        if (lottoParameter.equals("6outof49") || lottoParameter.equals("")) {
            //call class
        } else if (lottoParameter.equals("Eurojackpot")) {
            //call other class
        } else {
            System.out.println("Error: Please use \"6outof49\" or \"Eurojackpot\" as input parameter.");
        }
    }
}
