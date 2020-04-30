package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String studentCode;
    private String name;
    private String className;
    private String phoneNumber;
    private String gender;
    private Date dob;


    public Student() {
    }

    public Student(String studentCode, String name, String className, String phoneNumber, String gender, Date dob) {
        this.studentCode = studentCode;
        this.name = name;
        this.className = className;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dob = dob;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return Objects.equals(studentCode, student.studentCode) &&
                Objects.equals(name, student.name) &&
                Objects.equals(className, student.className) &&
                Objects.equals(phoneNumber, student.phoneNumber) &&
                Objects.equals(gender, student.gender) &&
                Objects.equals(dob, student.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode, name, className, phoneNumber, gender, dob);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode='" + studentCode + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                '}';
    }
}
