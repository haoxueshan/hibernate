package com.text;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.domain.Student;

public class Text {
	public static void main(String[] args) {

		Student user=new Student();

		user.setSname("郝雪山");
		user.setSage(12);
		user.setSadd("安阳");
		user.setSsex("男");
		user.setSphone("18303037852");
		Configuration configuration = new Configuration();

        //不给参数就默认加载hibernate.cfg.xml文件，
        configuration.configure();

        //创建Session工厂对象
        SessionFactory factory = configuration.buildSessionFactory();

        //得到Session对象
        Session session = factory.openSession();

        //使用Hibernate操作数据库，都要开启事务,得到事务对象
        Transaction transaction = session.getTransaction();

        //开启事务
        transaction.begin();

        //把对象添加到数据库中
        session.save(user);

        //提交事务
        transaction.commit();

        //关闭Session
        session.close();
	}
}
