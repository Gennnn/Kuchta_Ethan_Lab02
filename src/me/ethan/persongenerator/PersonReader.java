package me.ethan.persongenerator;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            lines.add(0, "ID, FIRST, LAST, TITLE, YOB");
            String display[][] = new String[5][lines.size()];
            int cellLength = 0;
            int rowLargestCell = 0;
            int colLargestCell = 0;
            for (int i = 0; i < lines.size(); i++) {
                String fullLine = (String) lines.get(i);
                String splitLine[] = fullLine.split(", ", 5);

                for (int j = 0; j < 5; j++) {
                    splitLine[j] = splitLine[j].replaceAll("<comma>", ",");
                    display[j][i] = splitLine[j];
                    if (display[j][i].length() > cellLength) {
                        cellLength = display[j][i].length();
                    }
                }
            }
            for (int i = 0; i < lines.size(); i++) {
                for (int k = 0; k < 5; k++) {
                    if (display[k][i].length() < cellLength) {
                        do {
                            display[k][i] = display[k][i] + " ";
                        } while (display[k][i].length() < cellLength);
                    }
                }


            }
            int rowLength = ("| " + display[0][0] + " | " + display[1][0] + " | " + display[2][0] + " | " + display[3][0] + " | " + display[4][0] + " |").length();
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
            for (int i = 0; i < lines.size(); i++) {
                    System.out.println("| " + display[0][i] + " | " + display[1][i] + " | " + display[2][i] + " | " + display[3][i] + " | " + display[4][i] + " |");
                    if (i==0) {
                        for (int k = 0; k < rowLength; k++) {
                            System.out.print("-");
                        }
                        System.out.print("\n");
                    }

            }
            for (int i = 0; i < rowLength; i++) {
                System.out.print("-");
            }
        }
    }

}






