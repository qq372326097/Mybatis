package yantang.dao;

import yantang.pojo.Student;

import java.util.List;

public interface StudentDao {
    //添加学生
    void addStudent(Student student);

    //删除学生
    void deleteStudent(int id);

    //修改学生
    void updateStudent(Student student);

    //查询一个学生
    Student findById(int id);

    //查询所有学生
    List<Student> findAll();

    //模糊查询
    List<Student> findAllLike(String name);
}
