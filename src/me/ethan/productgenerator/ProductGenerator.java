package me.ethan.productgenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String args[]) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String action = "";
        action = SafeInput.getRegExString(scanner, "Would you like to write a new Product Data file, or read an exisiting Product Data file?\n[Please enter either WRITE or READ]", "(?i)write|read");
        if (action.equalsIgnoreCase("write")) {
            ProductGen(scanner);
        } else if (action.equalsIgnoreCase("read")) {
            ProductReader.ProductReader();
        }
    }

    public static void ProductGen(Scanner scanner) throws IOException {
        ArrayList<Product> productArray = new ArrayList<>();

        boolean pass = true;
        int id;
        String name = "";
        String description = "";
        double price = 0.0;
        String fullList = "";
        String fileName = "";
        fileName = SafeInput.getNonZeroLenString(scanner, "What would you like the written file to be called?");
        Path path = Paths.get( fileName + ".txt");
        do {

            name = SafeInput.getNonZeroLenString(scanner, "Enter the name of your product");
            description = SafeInput.getNonZeroLenString(scanner, "Enter the description of your product");
            price = SafeInput.getDouble(scanner, "Enter the price of your product");
            name = name.replaceAll(",", "<comma>");
            description = description.replaceAll(",", "<comma>");
            productArray.add(new Product(productArray.size() + 1, name, description, price));
            pass = SafeInput.getYNConfirm(scanner, "Would you like to add another product?");
        } while (pass);

        for ( int i = 0; i < productArray.size(); i++) {
            int numZeroes = 5 - ((Integer.toString(i + 1)).length());
            if (i != 0) {
                fullList = fullList + "\n";
            }

            for (int k = 0; k < numZeroes; k++) {
                fullList = fullList + "0";
            }
            fullList = fullList + productArray.get(i).toCSVDataRecord();
        }
        byte[] listToBytes = fullList.getBytes();
        Files.write(path, listToBytes);

    }


}


