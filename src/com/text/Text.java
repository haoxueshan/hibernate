package com.text;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.domain.Student;

public class Text {
	public static void main(String[] args) {

		Student user=new Student();

		user.setSname("��ѩɽ");
		user.setSage(12);
		user.setSadd("����");
		user.setSsex("��");
		user.setSphone("18303037852");
		Configuration configuration = new Configuration();

        //����������Ĭ�ϼ���hibernate.cfg.xml�ļ���
        configuration.configure();

        //����Session��������
        SessionFactory factory = configuration.buildSessionFactory();

        //�õ�Session����
        Session session = factory.openSession();

        //ʹ��Hibernate�������ݿ⣬��Ҫ��������,�õ��������
        Transaction transaction = session.getTransaction();

        //��������
        transaction.begin();

        //�Ѷ�����ӵ����ݿ���
        session.save(user);

        //�ύ����
        transaction.commit();

        //�ر�Session
        session.close();
	}
}
