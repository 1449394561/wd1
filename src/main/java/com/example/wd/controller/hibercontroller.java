package com.example.wd.controller;

import com.example.wd.entity.Wd;
import com.example.wd.util.HibernateUtil;
import com.example.wd.util.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hiber")
public class hibercontroller {





        Session session;
        Transaction tx;

        @After
        public void afterTest(){
            tx.commit();
            HibernateUtil.CloseSession();
        }

        @Before
        public void initData(){
            session=HibernateUtil.getSession();
            tx=session.beginTransaction();
        }

        /*
         * get方法查询
         */
        @GetMapping("/get")
        @Test
        public Result getData(){
            Wd stu=(Wd)session.get(Wd.class, 3);

            return Result.success(stu);
        }


        /*
         * 增加
         */

        @Test
        public void addData(){
            Wd stu=new Wd();
            stu.setId(12);
            stu.setPassword("324");
            stu.setName("李小龙");
            //读取大配置文件 获取连接信息
            Configuration cfg=new Configuration().configure();

            //创建SessionFactory
            SessionFactory fa=cfg.buildSessionFactory();
            //加工Session
            Session se=fa.openSession();
            Transaction tx = se.beginTransaction();
            //保存
            se.save(stu);
            //事务提交
            tx.commit();
            se.close();

            System.out.println("Save ok!");


        }

        /*
         * 删除
         */
        @Test
        public void delData(){
            Session session=HibernateUtil.getSession();
            Wd stu=new Wd();
            stu.setId(2);
            Transaction tx=session.beginTransaction();
            session.delete(stu);
            tx.commit();
            HibernateUtil.CloseSession();
            System.out.println("del ok!");
        }

        /*
         * 修改
         */
        @Test
        public void updateData(){
            Session session=HibernateUtil.getSession();
            Wd stu=(Wd) session.load(Wd.class,3);
            stu.setName("呵呵");
            Transaction tx=session.beginTransaction();
            session.update(stu);
            tx.commit();
            HibernateUtil.CloseSession();
            System.out.println("update ok!");
        }




}
