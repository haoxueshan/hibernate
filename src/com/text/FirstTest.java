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
    Configuration cfg;  //���ö���
    Session session;   //�Ự����
    Transaction tx;    //�������
    @Before
    public void mybefore(){
        cfg=new Configuration().configure();  //��ȡ���ö���
        SessionFactory factory = cfg.buildSessionFactory(); //��ȡsessionfactory����
         session= factory.openSession();  //��ȡsession����
         tx= session.beginTransaction();  //��������
    }

    //���ѧ��
    @Test
    public void add(){
        Student stu=new Student();
        stu.setSname("΢�����");
        session.save(stu);  //�ύ�����ݿ�
        System.out.println("save ok!");
    }

    //����������ѯѧ������
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

    //�޸�ѧ������
    @Test
    public void update(){
    	String hql = "UPDATE Student set namee = :salary "  + 
                "WHERE id = :employee_id";
    	int id = 7;
	   Query query = session.createQuery(hql);
	   query.setParameter("salary", "name");
	   query.setParameter("employee_id", id);
	   int result = query.executeUpdate();
	   
	   System.out.println("��������: " + result);


    }

    //ɾ��ѧ��
    @Test
    public void delete(){
    	String hql = "DELETE FROM Student "  + 
                "WHERE id = :employee_id";
	   Query query = session.createQuery(hql);
	   query.setParameter("employee_id", 19);
	   int result = query.executeUpdate();
	   System.out.println("ɾ�� : " + result);
    }

    //��ѯѧ��
    @Test
    public void select(){
      Student stu=session.load(Student.class,6);
      System.out.println("������"+stu.getSname());
    }
    @After
    public void after(){
        tx.commit();  //�ύ����
        session.close();  //�ر�session
    }
}