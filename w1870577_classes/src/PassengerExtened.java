import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PassengerExtened {
    public static int number = 0;
    public static String[] queueArray = new String[36]; //creating  queue array
    public static String[] surnamequeueArray = new String[36];
    public static int total;

    public static void main(String args[]) {
        for (int i = 1; i < queueArray.length; i++) {
            queueArray[i] = "empty";
        }

        cabin c1[] = new cabin[12];
        for (int i = 0; i < c1.length; i++) {
            c1[i] = new cabin();
        }


        System.out.println("Enter the following commend:");//given inputs
        System.out.println("A - Adds customer to cabin");
        System.out.println("V - view all cabins");
        System.out.println("E - Display Empty cabins");
        System.out.println("D - Delete customer from cabin");
        System.out.println("F - Find cabin from customer name");
        System.out.println("S - Store program data into file");
        System.out.println("L - Load program data from file");
        System.out.println("O - View passengers Ordered alphabetically by name");
        System.out.println("T-  Print the expenses per passenger");

        Scanner scanchoice = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter \"A\", \"V\", \"E\", \"D\", \"F\", \"S\", \"L\" ,\"O\" or \"T\" ");


        while (true) {
            System.out.print("Enter a Input-");
            String menu = scanchoice.next();


            if (menu.equals("V")) {
                viewPassenger(c1);

            } else if (menu.equals("A")) {
                c1 = addpassenger(c1);

            } else if (menu.equals("E")) {
                emptypassenger(c1);

            } else if (menu.equals("D")) {
                c1 = deletePassenger(c1);

            } else if (menu.equals("F")) {
                findPassenger(c1);

            } else if (menu.equals("S")) {
                c1 = storPassenger(c1);

            } else if (menu.equals("L")) {
                c1 = loadPasenger(c1);

            } else if (menu.equals("O")) {
                orderPassenger(c1);

            } else if (menu.equals("T")) {
                expensesPasenger(c1);

            } else {
                System.out.println("Invalid Input");

            }

        }
    }

    private static void expensesPasenger(cabin[] c1) {

        for (int i = 0; i < c1.length; i++) {

            if (c1[i].namearray[0] != "empty") {
                System.out.println("cabin " + i + " passenger " + 1 + " is " + c1[i].expensesarray[0]);
                total += +c1[i].expensesarray[0];

            }
            if (c1[i].namearray[1] != "empty") {
                System.out.println("cabin " + i + " passenger " + 2 + " is " + c1[i].expensesarray[1]);
                total += +c1[i].expensesarray[1];
            }

            if (c1[i].namearray[2] != "empty") {
                System.out.println("cabin " + i + " passenger " + 3 + " is " + c1[i].expensesarray[2]);
                total += +c1[i].expensesarray[2];
            }


        }
        System.out.println("Total is :" + total);


    }

    private static void orderPassenger(cabin[] c1) {
        String[] sortarray = new String[36];
        int index = 0;
        for (int i = 0; i < c1.length; i++) {
            sortarray[index] = c1[i].namearray[0];
            index++;
            sortarray[index] = c1[i].namearray[1];
            index++;
            sortarray[index] = c1[i].namearray[2];
            index++;
        }
        for (int i = 0; i < sortarray.length; i++) {
            for (int j = i + 1; j < sortarray.length; j++) {

                if (sortarray[i].compareTo(sortarray[j]) > 0) {
                    String temp;
                    temp = sortarray[i];
                    sortarray[i] = sortarray[j];
                    sortarray[j] = temp;
                }
            }
        }
        for (int i = 0; i < sortarray.length; i++) {
            if (!sortarray[i].equals("empty")) {
                System.out.println(sortarray[i]);
            }

        }
    }

    private static cabin[] loadPasenger(cabin[] c1) {
        File myObj = new File("SavedData.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());

        } else {
            System.out.println("The file does not exist.");
        }


        return c1;
    }

    private static cabin[] storPassenger(cabin[] c1) {
        try {
            FileWriter savedata = new FileWriter("SavedData.txt"); //creat a new object type file writer
            for (int i = 0; i < c1.length; i++) {
                savedata.write("cabin" + i + "passenger1:" + c1[i].namearray[0] + "\n");
                savedata.write("cabin" + i + "passenger2:" + c1[i].namearray[1] + "\n");
                savedata.write("cabin" + i + "passenger3:" + c1[i].namearray[2] + "\n");
            }

            savedata.close();
            System.out.println("The file was successfully written to..");
        } catch (IOException e) {
            System.out.println("There was a mistake.");
            e.printStackTrace();
        }


        return c1;
    }

    private static cabin[] findPassenger(cabin[] c1) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Passenger Name:");
        String name = input.next();
        for (int i = 0; i < c1.length; i++) {
            if (c1[i].namearray[0].equals(name)) {
                System.out.println("This passenger is in cabin " + i);

            }
            if (c1[i].namearray[1].equals(name)) {
                System.out.println("This passenger is in cabin " + i);


            }
            if (c1[i].namearray[2].equals(name)) {
                System.out.println("This passenger is in cabin " + i);

            }
        }


        return c1;
    }

    private static cabin[] deletePassenger(cabin[] c1) {
        System.out.println("Enter cabin number ");
        Scanner input = new Scanner(System.in);
        int cabinnumber = input.nextInt();
        while (true) {

            if (!queueArray[0].equals("empty")) {
                c1[cabinnumber].namearray[0] = queueArray[0];
                c1[cabinnumber].expensesarray[0] = 0;
                c1[cabinnumber].surnamearray[0] = surnamequeueArray[0];

                c1[cabinnumber].namearray[1] = "empty";
                c1[cabinnumber].expensesarray[1] = 0;
                c1[cabinnumber].surnamearray[1] = "empty";      //assign data to the zeroth element of the array

                c1[cabinnumber].namearray[2] = "empty";
                c1[cabinnumber].expensesarray[2] = 0;
                c1[cabinnumber].surnamearray[2] = "empty";

                for (int i = 0; i < queueArray.length - 1; i++) {
                    queueArray[i] = queueArray[i+1];
                    surnamequeueArray[i] = surnamequeueArray[i+1];
                }
                break;

            }
            if (queueArray[0].equals("empty")) { /*deleting passenger details according to the cabin number entered by the user*/

                cabinnumber = input.nextInt();


                int key = c1[cabinnumber].setRemovename();
                if (key == 0) {
                    c1[cabinnumber].setRemovesurname();
                    c1[cabinnumber].setRemoveexpeneses();

                }


            }
        }
        return c1;
    }


    private static void emptypassenger(cabin[] c1) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i].namearray[0] == "empty") {
                System.out.println("cabin " + i + " passenger " + 1);
            }
            if (c1[i].namearray[1] == "empty") {
                System.out.println("cabin " + i + " passenger " + 2);
            }

            if (c1[i].namearray[2] == "empty") {
                System.out.println("cabin " + i + " passenger " + 3);
            }

        }

    }

    private static void viewPassenger(cabin[] c1) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i].namearray[0] != "empty") {
                System.out.println("cabin " + i + " passenger " + 1 + " is " + c1[i].namearray[0] + " " + c1[i].surnamearray[0]);
            } else {
                System.out.println("cabin " + i + " passenger " + 1 + " is empty");
            }
            if (c1[i].namearray[1] != "empty") {
                System.out.println("cabin " + i + " passenger " + 2 + " is " + c1[i].namearray[1] + " " + c1[i].surnamearray[1]);
            } else {
                System.out.println("cabin " + i + " passenger " + 2 + " is empty");
            }

            if (c1[i].namearray[2] != "empty") {
                System.out.println("cabin " + i + " passenger " + 3 + " is " + c1[i].namearray[2] + " " + c1[i].surnamearray[2]);
            } else {
                System.out.println("cabin " + i + " passenger " + 3 + " is empty");
            }

        }


    }

    private static cabin[] addpassenger(cabin[] c1) {
        int validate = 0;
        String confirm = "none";
        System.out.println("Enter cabin Number");
        while (true) {
            for (int i = 0; i < c1.length; i++) {
                if (!c1[i].namearray[0].equals("empty")) {
                    validate++;
                }
            }
            if (validate == 12) {
                confirm = "Notempty";   //storing data in the waiting list after the 11'th cabin is filed
            }
            if (confirm == "Notempty") {
                System.out.println("Cruise ship is full.........");
                System.out.println("Add passenger to queue");
                Scanner input = new Scanner(System.in);
                queueArray[number] = input.next();
                System.out.println("Add surname");
                surnamequeueArray[number] = input.next();
                number++;
                break;


            }
            if (confirm != "Notempty") {

                Scanner input = new Scanner(System.in);
                int cabinnumber = input.nextInt();

                int key = c1[cabinnumber].setName();
                if (key == 0) {
                    c1[cabinnumber].setSurname();
                    c1[cabinnumber].setExpeneses();
                    return c1;

                }


            }


        }
        return c1;
    }
}



