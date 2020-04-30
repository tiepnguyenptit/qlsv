package dao;

import constant.PathConstant;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDAOImpl implements IDAO<Student> {

    private List<Student> studentList;

    public StudentDAOImpl(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void update(Student studentUpdate, String code) {
        for (Student student : studentList) {
            if (student.getStudentCode().equals(code)) {
                studentList.set(studentList.indexOf(student), studentUpdate);
                break;
            }
        }
    }

    @Override
    public void remove(String code) {
        studentList.forEach(s -> {
            if (s.getStudentCode().equals(code)) {
                studentList.remove(s);
            }
        });
    }

    @Override
    public List<Student> findByCode(String code) {
        return studentList.stream().filter(s ->
                s.getStudentCode().toUpperCase()
                        .contains(code.trim().toUpperCase()))
                        .collect(Collectors.toList());
    }

    @Override
    public List<Student> findByName(String name) {
        return studentList.stream().filter(s ->
                s.getName().toUpperCase().
                        contains(name.trim().toUpperCase()))
                        .collect(Collectors.toList());
    }

    @Override
    public List<Student> getList() {
        return this.studentList;
    }

    @Override
    public void sortListByName() {
        studentList = studentList.stream().sorted(
                Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    @Override
    public void writeToFile() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PathConstant.LIST_STUDENT_FILE_PATH));
            out.writeObject(studentList);
            out.close();
            System.out.println("Write success");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void readFile() {
        try {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream(PathConstant.LIST_STUDENT_FILE_PATH));
            studentList = (ArrayList<Student>) out.readObject();
            out.close();
            System.out.println("Read success");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public void clearList() {
        studentList.clear();
    }

}
