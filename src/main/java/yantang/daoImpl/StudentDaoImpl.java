package yantang.daoImpl;

import org.apache.ibatis.session.SqlSession;
import yantang.dao.StudentDao;
import yantang.pojo.Student;
import yantang.utils.MybatisUtils;

import javax.naming.Name;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private String configFileName = "mybatis-config.xml";

    @Override
    public void addStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession(configFileName);
        try {
            sqlSession.insert("addStudent", student);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.print("添加学生出错" + e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession(configFileName);
        try {
            sqlSession.delete("deleteStudent",12);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.print("删除学生出错" + e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public void updateStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession(configFileName);
        try {
            sqlSession.update("updateStudent",student);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.print("修改学生出错" + e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public Student findById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession(configFileName);
        Student student = null;
        try {
            student = sqlSession.selectOne("findById", id);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.print("查询一个学生出错" + e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession(configFileName);
        List<Student> students = null;
        try {
            students = sqlSession.selectList("findAll");
            sqlSession.commit();
        } catch (Exception e) {
            System.out.print("查询所有学生出错" + e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return students;
    }

    @Override
    public List<Student> findAllLike(String name) {
        SqlSession sqlSession = MybatisUtils.getSqlSession(configFileName);
        List<Student> students = null;
        try {
            students = sqlSession.selectList("findAllLike",name);
            sqlSession.commit();
        } catch (Exception e) {
            System.out.print("模糊查询出错" + e.getMessage());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return students;
    }
}
