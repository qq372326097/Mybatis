package yantang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtils {
    //SqlSession确定是不能通用所以设置为单例的
    private static SqlSessionFactory sqlSessionFactory;
    //获取SqlSession
    public static SqlSession getSqlSession(String configFile){
        InputStream inputStream;
        try {
            //1、读取配置文件
            inputStream = Resources.getResourceAsStream(configFile);
            if (sqlSessionFactory == null){
                //2、获取sqlSessionFactory
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
            //3、打开SqlSesion
            return sqlSessionFactory.openSession();
        }catch (Exception e){
            System.out.print("获取SqlSession出错"+e.getMessage());
        }
        return null;

    }
}
