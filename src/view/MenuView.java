package view;

import constant.DateFormatConstant;
import model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MenuView {

    private Scanner sc;

    public MenuView() {
        sc = new Scanner(System.in);
    }

    public String showMenu() {
        System.out.println("1. Add student.");
        System.out.println("2. Update student.");
        System.out.println("3. Remove student.");
        System.out.println("4. Find student.");
        System.out.println("5. Sort list student by name.");
        System.out.println("6. Show list student.");
        System.out.println("7. Clear list student.");
        System.out.println("8. Write to File.");
        System.out.println("9. Read File.");
        System.out.println("10. Close the program.");
        System.out.print("Choose your selection: ");
        String choice = sc.nextLine();

        if (choice.equals("4")) {
            System.out.println("================================");
            System.out.println("Find student.");
            System.out.println("1.Find by student code.");
            System.out.println("2.Find by student name.");
            System.out.println("3.Find by class name.");
            System.out.println("4.Find by phone number.");
            System.out.print("Choose your selection : ");
            return "4.".concat(sc.nextLine());
        }
        return choice;
    }


    public Student typeStudent() {
        System.out.print("Student code : ");
        String studentCode = sc.nextLine();
        System.out.print("Student name : ");
        String name = sc.nextLine();
        System.out.print("Class name : ");
        String className = sc.nextLine();
        System.out.print("Phone Number : ");
        String phoneNumber = sc.nextLine();
        System.out.print("Gender : ");
        String gender = sc.nextLine();
        System.out.print("Date of Birth (format dd-mm-yyyy) : ");
        String dobString = sc.nextLine();

        while (!dobString.matches(DateFormatConstant.REGULAR_EXPRESSION_FORMAT)) {
            System.out.println("Wrong date format, please retype.");
            System.out.print("Date of Birth (format dd-mm-yyyy) : ");
            dobString = sc.nextLine();
        }

        SimpleDateFormat formatter = new SimpleDateFormat(DateFormatConstant.FORMAT);
        Date dobDate = null;
        try {

            dobDate = formatter.parse(dobString);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Student(studentCode, name, className, phoneNumber, gender, dobDate);
    }


    public String keyWord() {
        System.out.println("KeyWord: ");
        return sc.nextLine();
    }

    public void print(String message) {
        System.out.println(message);
    }

}
