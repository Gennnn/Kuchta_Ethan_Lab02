package me.ethan.persongenerator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
        ArrayList<String> personArray = new ArrayList<>();

        boolean pass = true;
        int id;
        String firstName = "";
        String lastName = "";
        String title = "";
        String fullList = "";
        int yearOfBirth = 0;
        String fileName = "";
        fileName = SafeInput.getNonZeroLenString(scanner, "What would you like the written file to be called?");
        Path path = Paths.get( fileName + ".txt");
        do {

            firstName = SafeInput.getNonZeroLenString(scanner, "Enter the first name of your person");
            lastName = SafeInput.getNonZeroLenString(scanner, "Enter the last name of your person");
            title = SafeInput.getNonZeroLenString(scanner, "Enter the title of your person");
            yearOfBirth = SafeInput.getInt(scanner, "Enter the year of birth of your person");
            firstName = firstName.replaceAll(",", "<comma>");
            lastName = lastName.replaceAll(",", "<comma>");
            title = title.replaceAll(",", "<comma>");
            personArray.add(firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);
            pass = SafeInput.getYNConfirm(scanner, "Would you like to add another person?");
        } while (pass);

        for ( int i = 0; i < personArray.size(); i++) {
            int numZeroes = 5 - ((Integer.toString(i + 1)).length());
            if (i != 0) {
                fullList = fullList + "\n";
            }

            for (int k = 0; k < numZeroes; k++) {
                fullList = fullList + "0";
            }
            fullList = fullList + (i + 1) + ", " + personArray.get(i);
        }
        byte[] listToBytes = fullList.getBytes();
        Files.write(path, listToBytes);

    }


}


