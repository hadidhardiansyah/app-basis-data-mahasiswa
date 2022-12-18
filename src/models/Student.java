package models;

public class Student {

    private Integer studentId;

    private String studentName;

    private Integer age;

    private Major major;

    public Student(Integer studentId, String studentName, Integer age, Major major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.major = major;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }

}
