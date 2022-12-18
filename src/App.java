import exceptions.ResponseStatus;
import models.Major;
import models.Student;
import repositories.implementation.StudentRepository;
import repositories.interfaces.IStudentRepository;
import services.implementation.StudentService;
import services.interfaces.IStudentService;
import validations.StudentAgeValidation;
import validations.StudentNameLengthValidation;
import validations.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        IStudentRepository studentRepository = new StudentRepository();
        Validation ageValidation = new StudentAgeValidation(17);
        Validation nameLengthValidation = new StudentNameLengthValidation(3, 20);
        IStudentService studentService = new StudentService(studentRepository, ageValidation, nameLengthValidation);

        List<Student> studentList = new ArrayList<>();

        System.out.println("--------------------");
        System.out.println("Main Menu");
        System.out.println("--------------------");

        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. View Student");
        System.out.println("4. Exit");

        System.out.print("Masukan menu yang dipilih: ");
        Integer input = scanner.nextInt();

        switch (input) {
            case 1:
                System.out.print("Masukan id: ");
                Integer id = scanner.nextInt();

                System.out.print("Masukan nama: ");
                String name = scanner.next();

                System.out.print("Masukan umur: ");
                Integer age = scanner.nextInt();

                System.out.print("Masukan jurusan: ");
                String major = scanner.next();

                Student newStudent = new Student(id, name, age, new Major(major));
                studentService.registerStudent(newStudent);
                break;

            case 2:
                studentService.unregisterStudent();
                break;

            case 3:
                System.out.println("1. View All Student");
                System.out.println("2. View Student By Index");

                System.out.print("Masukan menu yang dipilih: ");
                Integer inputView = scanner.nextInt();

                switch (inputView) {
                    case 1:
                        List<Student> students = studentService.getAllStudent();
                        System.out.println(students);
                        break;
                    case 2:
                        System.out.print("Masukan index: ");
                        Integer index = scanner.nextInt();
                        studentService.getStudentByIndex(index);
                        break;
                }
                break;

            case 4:
                System.out.print("THANK YOU :)");
                break;

            default:
                System.out.println("Menu tidak ada dalam pilihan");
        }

    }

}
