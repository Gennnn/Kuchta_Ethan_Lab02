package me.ethan.productgenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String args[]) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String action = "";
        action = SafeInput.getRegExString(scanner, "Would you like to write a new Person Data file, or read an exisiting Person Data file?\n[Please enter either WRITE or READ]", "(?i)write|read");
        if (action.equalsIgnoreCase("write")) {
            PersonGen(scanner);
        } else if (action.equalsIgnoreCase("read")) {
            PersonReader.PersonReader();
        }
    }

    public static void PersonGen(Scanner scanner) throws IOException {
        ArrayList<Person> personArray = new ArrayList<>();

        boolean pass = true;
        int id;
        String firstName = "";
        String lastName = "";
        String title = "";
        int birthYear = 0000;
        String fullList = "";
        String fileName = "";
        fileName = SafeInput.getNonZeroLenString(scanner, "What would you like the written file to be called?");
        Path path = Paths.get( fileName + ".txt");
        do {

            firstName = SafeInput.getNonZeroLenString(scanner, "Enter the first name of your person");
            lastName = SafeInput.getNonZeroLenString(scanner, "Enter the last name of your person");
            title = SafeInput.getNonZeroLenString(scanner, "Enter the title of your person");
            birthYear = SafeInput.getInt(scanner, "Enter the birth year of your person");
            firstName = firstName.replaceAll(",", "<comma>");
            lastName = lastName.replaceAll(",", "<comma>");
            title = title.replaceAll(",", "<comma>");
            personArray.add(new Person(personArray.size() + 1, firstName, lastName, title, birthYear));
            pass = SafeInput.getYNConfirm(scanner, "Would you like to add another person?");
        } while (pass);

        for (int i = 0; i < personArray.size(); i++) {
            int numZeroes = 5 - ((Integer.toString(i + 1)).length());
            if (i != 0) {
                fullList = fullList + "\n";
            }

            for (int k = 0; k < numZeroes; k++) {
                fullList = fullList + "0";
            }
            fullList = fullList + personArray.get(i).toCSVDataRecord();
        }
        byte[] listToBytes = fullList.getBytes();
        Files.write(path, listToBytes);

    }


}


