import jdk.internal.dynalink.beans.StaticClass;

import java.util.Scanner;

public class cabin {
    String[] namearray = {"empty", "empty", "empty"}; /*creating a array to store namese*/
    String[] surnamearray = {"empty", "empty", "empty"}; /*its initialize by empty*/
    int[] expensesarray = new int[3]; //created a array to store expenses
    static int i = 0; //continuously add total expenses
    String name;
    String surname;
    int expeneses;
    String removename;
    String removesurname;
    int removeexpeneses;


    public String getName() {
        return name;
    }

    public String getRemovename() {
        return removename;
    }

    public int setRemovename() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < namearray.length; i++) {
            if (namearray[i] != "empty") {

                namearray[i] = "empty";
                return 0;
            }
        }

        return 1;
    }

    public String getRemovesurname() {
        return removesurname;
    }

    public void setRemovesurname() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < surnamearray.length; i++) {
            if (surnamearray[i] != "empty") {
                surnamearray[i] = "empty";
                return;
            }
        }
    }

    public int getRemoveexpeneses() {
        return removeexpeneses;
    }

    public void setRemoveexpeneses() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < expensesarray.length; i++) {
            if (expensesarray[i] != 0) {
                expensesarray[i] = 0;
                return;
            }
        }

    }

    public int setName() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < namearray.length; i++) {
            if (namearray[i] == "empty") {
                System.out.println("Enter Name");
                String name = input.next();
                namearray[i] = name;
                return 0;
            }
        }
        System.out.println("cabin is full Enter to a new cabin");
        return 1;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname() {

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < surnamearray.length; i++) {
            if (surnamearray[i] == "empty") {
                System.out.println("Enter SurName");
                String surname = input.next();
                surnamearray[i] = surname;
                return;
            }
        }
    }


    public int getExpeneses() {
        return expeneses;
    }

    public void setExpeneses() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < expensesarray.length; i++) {
            if (expensesarray[i] == 0) {
                System.out.println("Enter expenses");
                int expenses = 0;
                try{
                    expenses=input.nextInt();


                }catch (Exception e){
                    System.out.println("Invalid input");
                }
                expensesarray[i] = expenses;
                return;
            }
        }

    }

}

