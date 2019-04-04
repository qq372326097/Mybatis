package yantang.daoImpl;

import org.junit.Test;
import yantang.pojo.Student;

import java.text.SimpleDateFormat;
import java.util.List;

public class StudentDaoImplTest {
    StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

    @Test
    public void addStudent() throws Exception {
        Student student = new Student("李四",new SimpleDateFormat("yyyy-MM-dd").parse("1992-06-27"),"男");
        studentDaoImpl.addStudent(student);
    }

    @Test
    public void deleteStudent() throws Exception {
        studentDaoImpl.deleteStudent(12);
    }

    @Test
    public void updateStudent() throws Exception {
        Student student = new Student("赵雷",new SimpleDateFormat("yyyy-MM-dd").parse("1992-06-27"),"男");
        //需指明ID也就是where后面的参数，否则更新不成功
        student.setS_id(1);
        studentDaoImpl.updateStudent(student);
    }

    @Test
    public void findById() throws Exception {
        Student student = null;
        student = studentDaoImpl.findById(1);
        System.out.print("ID = "+student.getS_id()+",name = "+student.getS_name()+",birth"+student.getS_birth()+",sex = "+student.getS_sex());
    }

    @Test
    public void findAll() throws Exception {
        List<Student> students = null;
        students = studentDaoImpl.findAll();
        for (Student student : students) {
            System.out.print("ID = "+student.getS_id()+",name = "+student.getS_name()+",birth"+student.getS_birth()+",sex = "+student.getS_sex());
            System.out.print("\r\n");
        }
    }

    @Test
    public void findAllLike() throws Exception {
        List<Student> students = null;
        students = studentDaoImpl.findAllLike("李");
        for (Student student : students) {
            System.out.print("ID = "+student.getS_id()+",name = "+student.getS_name()+",birth"+student.getS_birth()+",sex = "+student.getS_sex());
            System.out.print("\r\n");
        }
    }

}