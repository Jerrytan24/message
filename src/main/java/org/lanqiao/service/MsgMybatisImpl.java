package org.lanqiao.service;

import org.lanqiao.mapper.MsgMapper;
import org.lanqiao.entity.Msg;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MsgMybatisImpl {
    public List<Msg> getAllmsg(){
        List<Msg> m=null;
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        MsgMapper p=ac.getBean("msgMapper",MsgMapper.class);
        m=p.getAllmsg();
        return m;
    }
    public int insert(Msg record){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        MsgMapper p=ac.getBean("msgMapper",MsgMapper.class);
        return p.insert(record);
    }
}
