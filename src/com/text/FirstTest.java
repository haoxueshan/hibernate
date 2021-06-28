package com.text;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.domain.Student;

import java.util.List;

public class FirstTest {
    Configuration cfg;  //配置对象
    Session session;   //会话对象
    Transaction tx;    //事务对象
    @Before
    public void mybefore(){
        cfg=new Configuration().configure();  //获取配置对象
        SessionFactory factory = cfg.buildSessionFactory(); //获取sessionfactory对象
         session= factory.openSession();  //获取session对象
         tx= session.beginTransaction();  //开启事务
    }

    //添加学生
    @Test
    public void add(){
        Student stu=new Student();
        stu.setSname("微冷的雨");
        session.save(stu);  //提交到数据库
        System.out.println("save ok!");
    }

    //根据条件查询学生姓名
    @Test
    public void select1(){
    	String hql = "FROM Student E WHERE E.id = :employee_id";
    	Query query = session.createQuery(hql);
    	query.setParameter("employee_id",1);
    	List<Student> results = query.list();
    	for(Student s:results){
    		System.out.println(s.getSname());
    	}
    }

    //修改学生姓名
    @Test
    public void update(){
    	String hql = "UPDATE Student set namee = :salary "  + 
                "WHERE id = :employee_id";
    	int id = 7;
	   Query query = session.createQuery(hql);
	   query.setParameter("salary", "name");
	   query.setParameter("employee_id", id);
	   int result = query.executeUpdate();
	   
	   System.out.println("更新行数: " + result);


    }

    //删除学生
    @Test
    public void delete(){
    	String hql = "DELETE FROM Student "  + 
                "WHERE id = :employee_id";
	   Query query = session.createQuery(hql);
	   query.setParameter("employee_id", 19);
	   int result = query.executeUpdate();
	   System.out.println("删除 : " + result);
    }

    //查询学生
    @Test
    public void select(){
      Student stu=session.load(Student.class,6);
      System.out.println("姓名："+stu.getSname());
    }
    @After
    public void after(){
        tx.commit();  //提交事务
        session.close();  //关闭session
    }
}