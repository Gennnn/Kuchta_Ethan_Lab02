package me.ethan.productgenerator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductReader {

    public static void ProductReader() throws IOException, InterruptedException {
        System.out.println("Please select the file you'd like to read from:");
        Thread.sleep(1000);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files", "txt");
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File (System.getProperty("user.dir")));
        ArrayList<String> readArray = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.00");
        int result = chooser.showOpenDialog(null);
        if (result == chooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println("File Selected: " + file);
            Path path = Paths.get(file.getAbsolutePath());

            List lines = Files.readAllLines(path);
            String display[][] = new String[5][lines.size()];
            ArrayList<Product> productArray = new ArrayList<>();
            int cellLength = 0;
            int rowLargestCell = 0;
            int colLargestCell = 0;
            for (int i = 0; i < lines.size(); i++) {
                String fullLine = (String) lines.get(i);
                String splitLine[] = fullLine.split(", ", 4);

                for (int j = 0; j < 4; j++) {

                    splitLine[j] = splitLine[j].replaceAll("<comma>", ",");
                    if (splitLine[j].length() > cellLength) {
                        cellLength = splitLine[j].length();
                    }
                }
                productArray.add(new Product(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2], Double.parseDouble(splitLine[3])));
            }
            if (cellLength < 5) {
                cellLength = 5;
            }
            int rowLength = ("| " + " | " + " | " + " | " + " |").length() + ( cellLength*4 );
            for (int i = 0; i < rowLength; i++) {
                System.out.print("-");
            }
            String fileName = path.getFileName().toString();
            int justify = 1;
            do {
                if (justify % 2 == 1) {
                    fileName = fileName + " ";
                } else {
                    fileName = " " + fileName;
                }
                justify++;
            } while (fileName.length() < rowLength);
            System.out.println("\n" + fileName );
            for (int i = 0; i < rowLength; i++) {
                System.out.print("-");
            }
            System.out.print("\n");
            String idPrintString = "";
            String namePrintString = "";
            String descriptionPrintString = "";
            String pricePrintString = "";
                for (int k = 0; k < 4; k++) {
                    if (k == 0) {
                        String idString = "ID";
                        while (idString.length() < cellLength) {
                            idString = idString + " ";
                        }
                        idPrintString = "| " + idString;
                    } else if (k == 1) {
                        String nameString = "NAME";
                        while (nameString.length() < cellLength) {
                            nameString = nameString + " ";
                        }
                        namePrintString = " | " + nameString;
                    } else if (k == 2) {
                        String descriptionString = "DESC";
                        while (descriptionString.length() < cellLength) {
                            descriptionString = descriptionString + " ";
                        }
                        descriptionPrintString = " | " + descriptionString;
                    } else if (k == 3) {
                        String priceString = "PRICE";
                        while (priceString.length() < cellLength) {
                            priceString = priceString + " ";
                        }
                        pricePrintString = " | " + priceString;

                    }
                }
            System.out.println(idPrintString+namePrintString+descriptionPrintString+pricePrintString);

                for (int k = 0; k < rowLength; k++) {
                    System.out.print("-");
                }
                System.out.print("\n");

            for (int i = 0; i < lines.size(); i++) {
                for (int k = 0; k < 4; k++) {
                    if (k==0) {
                        String idString = Integer.toString(productArray.get(i).getID());
                        while (idString.length() < cellLength) {
                            idString = idString + " ";
                        }
                        idPrintString = "| " + idString;
                    } else if (k==1) {
                        String nameString = productArray.get(i).getName();
                        while (nameString.length() < cellLength) {
                            nameString = nameString+ " ";
                        }
                        namePrintString = " | " + nameString;
                    } else if (k==2) {
                        String descriptionString = productArray.get(i).getDescription();
                        while (descriptionString.length() < cellLength) {
                            descriptionString = descriptionString+ " ";
                        }
                        descriptionPrintString = " | " + descriptionString;
                    } else if (k==3) {
                        String priceString = df.format(productArray.get(i).getPrice());
                        while (priceString.length() < cellLength) {
                            priceString = priceString + " ";
                        }
                        pricePrintString = " | " + priceString + " |";

                    }


                }
                    System.out.println(idPrintString+namePrintString+descriptionPrintString+pricePrintString);


            }
            for (int i = 0; i < rowLength; i++) {
                System.out.print("-");
            }
        }
    }

}






