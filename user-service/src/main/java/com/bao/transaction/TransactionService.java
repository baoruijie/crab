package com.bao.transaction;

import com.bao.crab.study.annotation.Study;
import com.bao.crab.study.handspring.spring.Autowired;
import com.bao.crab.study.handspring.spring.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/6/7 15:07
 */


@Component
public class TransactionService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Study(comment = "事务失效的几种情况？" +
            "1.未开启事务管理 @EnableTransactionManagement,或者没有@Configuration" +
            "2.方法自调用（需要通过代理对象调用，自调用时this.method()）需要和传播机制共同判断是否失效。" +
            "3.非public方法" +
            "4.异常类型" +
            "5.注解属性propagation属性设置错误" +
            "6.注解属性rollbankFor设置错误" +
            "7.数据库引擎不支持" +
            "8.....")
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(){
        jdbcTemplate.execute("insert into xxx");
    }

    @Study(comment = "spring事务传播机制：7种,见Propagation类" +
            "1.REQUIRED：    支持（并加入）当前事务，不存在时新建；" +
            "2.SUPPORTS：    支持（并加入）当前事务，不存在时以非事务方式运行；" +
            "3.MANDATORY：   支持（并加入）当前事务，不存在时抛出异常；" +
            "4.REQUIRES_NEW：当前存在事务则当前事务挂起，新建事务运行；" +
            "5.NOT_SUPPORTED:当前存在事务则当前事务挂起，以非事务方式运行；" +
            "6.NEVER：       当前存在事务则抛出异常；" +
            "7.NESTED：      当前存在事务则新建事务，嵌套执行;如果当前不存在事务，等于required")
    @Transactional(propagation = Propagation.NEVER)
    public void deleteUser(String userName){
        jdbcTemplate.execute("delete from ... where username=" + userName);
    }

    @Study(ask = "方法自调用肯定会失败吗？",comment = "经过验证，方法自调用其实是传播机制失效了." +
            "如methodA调用methodB，最终会只考虑methodA的事务，忽略methodB的，比如methodA事务类型是REQUIRED，" +
            "methodB的事务类型是NEVER，则自调用methodB时，并不会抛出异常。")
    @Transactional
    public void updateUser(){

    }


}
