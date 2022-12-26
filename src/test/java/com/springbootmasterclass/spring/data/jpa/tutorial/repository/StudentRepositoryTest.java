package com.springbootmasterclass.spring.data.jpa.tutorial.repository;

import com.springbootmasterclass.spring.data.jpa.tutorial.entity.Guardian;
import com.springbootmasterclass.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("diwasarya25@gmail.com")
                .firstName("Diwas")
                .lastName("Arya")
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("9999999999")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printStudentByFirstName() {

        List<Student> students =
                studentRepository.findByFirstName("shivam");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students =
                studentRepository.findByFirstNameContaining("sh");

        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByLastName() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Nikhil");
        System.out.println("students = " + students);
    }
    @Test
    public void printFindByFirstNameAndLastName() {
        Student student =
                studentRepository.findByFirstNameAndLastName("Shivam","Kumar");
        System.out.println("Student = " + student);
    }
    @Test
    public void printGetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "diwasarya25@gmail.com"
                );

        System.out.println("student = " + student);
    }
    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "diwasarya25@gmail.com"
                );
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "diwasarya25@gmail.com"
                );

        System.out.println("student = " + student);
    }
    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "diwasarya25@gmail.com"
                );

        System.out.println("student = " + student);
    }
    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "Diwas Kumar",
                "diwasarya25@gmail.com");
    }
}