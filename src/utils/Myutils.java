package src.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Myutils {
    public static String roomStandards( ) {
        int numberChoice5 = 0;
        String roomStandards = "";
        do {
            try {
                System.out.print("Select roomStandards :");
                System.out.println();
                System.out.println("1.One Star");
                System.out.println("2.Two Star");
                System.out.println("3.Three Star");
                System.out.println("4.Four Star");
                System.out.println("5.Five Star");
                Scanner scanner = new Scanner(System.in);
                numberChoice5 = scanner.nextInt();
                if (numberChoice5 > 5){
                    System.err.println("Vui lòng nhập từ 1 -> 5 !");
                }
            }catch (InputMismatchException e){
                System.err.println("Vui lòng nhập số !");
            }
            switch (numberChoice5) {
                case 1:
                    roomStandards = "One Star";
                    break;
                case 2:
                    roomStandards = "Two Star";
                    break;
                case 3:
                    roomStandards = "Three Star";
                    break;
                case 4:
                    roomStandards = "Four Star";
                    break;
                case 5:
                    roomStandards = "Five Star";
                    break;
            }
        } while (roomStandards.equals(""));
        return roomStandards;
    }
    public static boolean checkDate (int age){
        return age >= 18 && age <=100 ;
    }
    public static String gender (){
        int numberchoice = 0 ;
        String gender = "";
        do {
            try {
                System.out.println("Select gender :");
                System.out.println("1.Male");
                System.out.println("2.Female");
                Scanner scanner = new Scanner(System.in);
                numberchoice = scanner.nextInt();
                switch (numberchoice){
                    case 1 :
                        gender = "Male" ;
                    case 2 :
                        gender = "Female";
                }
            }catch (InputMismatchException e){
                System.err.println("Vui lòng nhập số 1 or 2 !");
            }
        }while (gender.equals(""));
        return gender ;
    }
}
