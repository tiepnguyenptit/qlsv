package main;

import controller.StudentController;
import dao.StudentDAOImpl;
import model.Student;
import view.MenuView;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        StudentDAOImpl dao = new StudentDAOImpl(studentList);

        MenuView view = new MenuView();

        StudentController controller = new StudentController(dao, view);

        controller.run();


    }


}
