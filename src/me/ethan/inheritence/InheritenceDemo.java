package me.ethan.inheritence;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class InheritenceDemo {
    public static void InheritenceDem() {
        Worker worker1 = new Worker("000001", "John", "Doe", "Mr.", 1980, 14.70);
        Worker worker2 = new Worker("000002", "Jane", "Buck", "Mrs.", 1985, 15.10);
        Worker worker3 = new Worker("000003", "Jimmy", "Deer", "Mr.", 1990, 12.50);
        SalaryWorker sworker1 = new SalaryWorker("000004", "James", "Jones", "Mr.", 1983, 0, 52000);
        SalaryWorker sworker2 = new SalaryWorker("000005", "Julie", "Jones", "Mrs.", 1983, 0, 43000);
        SalaryWorker sworker3 = new SalaryWorker("000006", "Jefferson", "Jones", "Mr.", 2000, 0, 30000);
        ArrayList<Worker> workerArray = new ArrayList<>();
        workerArray.add(worker1);
        workerArray.add(worker2);
        workerArray.add(worker3);
        workerArray.add(sworker1);
        workerArray.add(sworker2);
        workerArray.add(sworker3);
        display(40, workerArray, 1);
        display(50, workerArray, 2);
        display(40, workerArray, 3);

    }

    public static void display(double hoursWorked, ArrayList<Worker> workerArray, int weekNum) {
        int idCellLength = 2;
        DecimalFormat df = new DecimalFormat("0.00");
        int firstCellLength = 5;
        int lastCellLength = 5;
        int weeklyPayCellLength = 3;
        for (int i = 0; i < workerArray.size(); i++) {
            Worker readWorker = workerArray.get(i);
            for (int k = 0; k < 4; k++) {
                if (k == 0) {
                    if ((readWorker.getID()).length() > idCellLength) {
                        idCellLength = (readWorker.getID()).length();
                    }
                } else if (k == 1) {
                    if (readWorker.getFirstName().length() > firstCellLength) {
                        firstCellLength = readWorker.getFirstName().length();
                    }
                } else if (k == 2) {
                    if (readWorker.getLastName().length() > lastCellLength) {
                        lastCellLength = readWorker.getLastName().length();
                    }
                } else if (k == 3) {
                    if ((df.format(readWorker.calculateWeeklyPay(hoursWorked))).length() > weeklyPayCellLength) {
                        weeklyPayCellLength = df.format(readWorker.calculateWeeklyPay(hoursWorked)).length();
                    }
                }
            }

        }
        int rowLength = ("| " + " | " + " | " + " | " + " |").length() + (firstCellLength + lastCellLength + weeklyPayCellLength + idCellLength);
        for (int i = 0; i < rowLength; i++) {
            System.out.print("-");
        }
        String weekNumDisplay = "Week " + weekNum;
        int justify = 1;
        do {
            if (justify % 2 == 1) {
                weekNumDisplay = weekNumDisplay + " ";
            } else {
                weekNumDisplay = " " + weekNumDisplay;
            }
            justify++;
        } while (weekNumDisplay.length() < rowLength);
        System.out.println("\n" + weekNumDisplay);
        for (int i = 0; i < rowLength; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
        String idPrintString = "";
        String firstNamePrintString = "";
        String lastNamePrintString = "";
        String weeklyPayPrintString = "";
        for (int k = 0; k < 4; k++) {
            if (k == 0) {
                String idString = "ID";
                while (idString.length() < idCellLength) {
                    idString = idString + " ";
                }
                idPrintString = "| " + idString;
            } else if (k == 1) {
                String firstNameString = "FIRST";
                while (firstNameString.length() < firstCellLength) {
                    firstNameString = firstNameString + " ";
                }
                firstNamePrintString = " | " + firstNameString;
            } else if (k == 2) {
                String lastNameString = "LAST";
                while (lastNameString.length() < lastCellLength) {
                    lastNameString = lastNameString + " ";
                }
                lastNamePrintString = " | " + lastNameString;
            } else if (k == 3) {
                String weeklyPayString = "PAY";
                while (weeklyPayString.length() < weeklyPayCellLength) {
                    weeklyPayString = weeklyPayString + " ";
                }
                weeklyPayPrintString = " | " + weeklyPayString + " |";
            }
        }
        System.out.println(idPrintString + firstNamePrintString + lastNamePrintString + weeklyPayPrintString);
        for (int i = 0; i < workerArray.size(); i++) {
            for (int k = 0; k < 4; k++) {
                if (k == 0) {
                    String idString = (workerArray.get(i).getID());
                    while (idString.length() < idCellLength) {
                        idString = idString + " ";
                    }
                    idPrintString = "| " + idString;
                } else if (k == 1) {
                    String firstNameString = workerArray.get(i).getFirstName();
                    while (firstNameString.length() < firstCellLength) {
                        firstNameString = firstNameString + " ";
                    }
                    firstNamePrintString = " | " + firstNameString;
                } else if (k == 2) {
                    String lastNameString = workerArray.get(i).getLastName();
                    while (lastNameString.length() < lastCellLength) {
                        lastNameString = lastNameString + " ";
                    }
                    lastNamePrintString = " | " + lastNameString;
                } else if (k == 3) {
                    String weeklyPayString = df.format(workerArray.get(i).calculateWeeklyPay(hoursWorked));
                    while (weeklyPayString.length() < weeklyPayCellLength) {
                        weeklyPayString = weeklyPayString + " ";
                    }
                    weeklyPayPrintString = " | " + weeklyPayString + " |";
                }
            }
            System.out.println(idPrintString + firstNamePrintString + lastNamePrintString + weeklyPayPrintString);


        }
        for (int i = 0; i < rowLength; i++) {
            System.out.print("-");
        }
        System.out.print("\n");

    }

}
