package yantang.pojo;


import java.util.Date;

public class Student {

    private int id;
    private String name;
    //    出日期
    private Date birth;
    //    性别
   private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String name, Date birth, String sex) {
        this.name = name;
        this.birth = birth;
        this.sex = sex;
    }

    public Student() {
    }
}
