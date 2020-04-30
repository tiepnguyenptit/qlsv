package controller;

import dao.IDAO;
import model.Student;
import view.MenuView;

import java.util.List;

public class StudentController {

    private IDAO dao;
    private MenuView view;

    public StudentController(IDAO dao, MenuView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run(){

        while(true) {
            String choice = view.showMenu();

            switch (choice) {

                case "1" : {
                    Student student = this.view.typeStudent();
                    dao.add(student);
                    break;
                }

                case "2" : {
                    String code = this.view.keyWord();
                    Student student = this.view.typeStudent();
                    dao.update(student, code);
                    break;
                }

                case "3" : {
                    String code = this.view.keyWord();
                    dao.remove(code);
                    break;
                }

                case "4.1": {
                    String keyword = this.view.keyWord();
                    List<Student> studentList = dao.findByCode(keyword);
                    studentList.forEach(student -> this.view.print(student.toString()));
                    break;
                }

                case "4.2": {
                    String keyword = this.view.keyWord();
                    List<Student> studentList = dao.findByName(keyword);
                    studentList.forEach(student -> this.view.print(student.toString()));
                    break;
                }

                case "5" : {
                    dao.sortListByName();
                    break;
                }

                case "6" : {
                    List<Student> studentList = dao.getList();
                    studentList.forEach(student -> this.view.print(student.toString()));
                    break;
                }

                case "7" : {
                    dao.clearList();
                    break;
                }

                case "8" : {
                    dao.writeToFile();
                    break;
                }

                case "9" : {
                    dao.readFile();
                    break;
                }

                case "10" : {
                    System.exit(0);
                }

                default: {
                    System.out.println("Wrong input, type again!!!");
                }

            }

        }

    }



}
