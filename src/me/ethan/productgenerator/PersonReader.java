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

public class PersonReader {

    public static void PersonReader() throws IOException, InterruptedException {
        System.out.println("Please select the file you'd like to read from:");
        Thread.sleep(1000);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files", "txt");
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File (System.getProperty("user.dir")));
        ArrayList<String> readArray = new ArrayList<>();
        int result = chooser.showOpenDialog(null);
        if (result == chooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println("File Selected: " + file);
            Path path = Paths.get(file.getAbsolutePath());

            List lines = Files.readAllLines(path);
            String display[][] = new String[5][lines.size()];
            ArrayList<Person> personArray = new ArrayList<>();
            int cellLength = 0;
            int rowLargestCell = 0;
            int colLargestCell = 0;
            for (int i = 0; i < lines.size(); i++) {
                String fullLine = (String) lines.get(i);
                String splitLine[] = fullLine.split(", ", 5);

                for (int j = 0; j < 5; j++) {

                    splitLine[j] = splitLine[j].replaceAll("<comma>", ",");
                    if (splitLine[j].length() > cellLength) {
                        cellLength = splitLine[j].length();
                    }
                }
                personArray.add(new Person(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2], splitLine[3], Integer.parseInt(splitLine[4])));
            }
            if (cellLength < 5) {
                cellLength = 5;
            }
            int rowLength = ("| " + " | " + " | " + " | " + " |").length() + ( cellLength*5 );
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
            String firstNamePrintString = "";
            String lastNamePrintString = "";
            String titlePrintString = "";
            String birthYearPrintString = "";
                for (int k = 0; k < 5; k++) {
                    if (k == 0) {
                        String idString = "ID";
                        while (idString.length() < cellLength) {
                            idString = idString + " ";
                        }
                        idPrintString = "| " + idString;
                    } else if (k == 1) {
                        String firstnameString = "FIRST";
                        while (firstnameString.length() < cellLength) {
                            firstnameString = firstnameString + " ";
                        }
                        firstNamePrintString = " | " + firstnameString;
                    } else if (k == 2) {
                        String lastNameString = "LAST";
                        while (lastNameString.length() < cellLength) {
                            lastNameString = lastNameString + " ";
                        }
                        lastNamePrintString = " | " + lastNameString;
                    } else if (k == 3) {
                        String titleString = "TITLE";
                        while (titleString.length() < cellLength) {
                            titleString = titleString + " ";
                        }
                        titlePrintString = " | " + titleString;

                    } else if (k == 4) {
                        String birthYearString = "YOB";
                        while (birthYearString.length() < cellLength) {
                            birthYearString = birthYearString + " ";
                        }
                        birthYearPrintString = " | " + birthYearString;

                    }
                }
            System.out.println(idPrintString+firstNamePrintString+lastNamePrintString+titlePrintString+birthYearPrintString);

                for (int k = 0; k < rowLength; k++) {
                    System.out.print("-");
                }
                System.out.print("\n");

            for (int i = 0; i < lines.size(); i++) {
                for (int k = 0; k < 5; k++) {
                    if (k==0) {
                        String idString = Integer.toString(personArray.get(i).getID());
                        while (idString.length() < cellLength) {
                            idString = idString + " ";
                        }
                        idPrintString = "| " + idString;
                    } else if (k==1) {
                        String firstNameString = personArray.get(i).getFirstName();
                        while (firstNameString.length() < cellLength) {
                            firstNameString = firstNameString+ " ";
                        }
                        firstNamePrintString = " | " + firstNameString;
                    } else if (k==2) {
                        String lastNameString = personArray.get(i).getLastName();
                        while (lastNameString.length() < cellLength) {
                            lastNameString = lastNameString+ " ";
                        }
                        lastNamePrintString = " | " + lastNameString;
                    } else if (k==3) {
                        String titleString = personArray.get(i).getTitle();
                        while (titleString.length() < cellLength) {
                            titleString = titleString + " ";
                        }
                        titlePrintString = " | " + titleString + " |";

                    } else if (k==4) {
                        String birthYearString = Integer.toString(personArray.get(i).getBirthYear());
                        while (birthYearString.length() < cellLength) {
                            birthYearString = birthYearString + " ";
                        }
                        titlePrintString = " | " + birthYearString + " |";

                    }


                }
                    System.out.println(idPrintString+firstNamePrintString+lastNamePrintString+titlePrintString+birthYearPrintString);


            }
            for (int i = 0; i < rowLength; i++) {
                System.out.print("-");
            }
        }
    }

}






