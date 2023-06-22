package com.gusty.spring6.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查詢: 返回對象
    @Test
    public void testSelectObject() {
        /*
        String sql = "select * from t_emp where id=?";
        //將返回的結果集自行封裝
        Emp empResult = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Emp emp = new Emp();
            emp.setName(rs.getString("name"));
            emp.setAge(rs.getInt("age"));
            emp.setSex(rs.getString("sex"));
            emp.setId(rs.getInt("id"));
            return emp;
        }, 3);
        System.out.println(empResult);
        */

        String sql = "select * from t_emp where id=?";
        Emp emp =  jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class),3);
        System.out.println(emp);
    }

    //查詢: 返回list集合
    @Test
    public void testSelectList(){
        String sql = "select * from t_emp where id=?";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class), 3);
        System.out.println(list);
    }

    //查詢: 返回單個值
    @Test
    public void testSelectValue(){
        String sql = "select count(*) from t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    //添加、修改、刪除操作
    @Test
    public void testUpdate() {
        /*
        //1.添加操作
        //1-1.編寫sql語句
        String sql = "insert into t_emp values(null,?,?,?)";

        //1-2.調用jdbcjdbcTemplate的方法傳入相關參數
        //Object[] params = {"老李", 20, "男"};
        //int rows = jdbcTemplate.update(sql, params);
        int rows = jdbcTemplate.update(sql, "小櫻", 10, "女");
        System.out.println(rows);
         */

        /*
        //2.修改操作
        String sql = "update t_emp set name=? where id=?";
        int rows = jdbcTemplate.update(sql,"雛田",2);
        System.out.println(rows);
         */

        //3.刪除操作
        String sql = "delete from t_emp where id=?";
        int rows = jdbcTemplate.update(sql, 2);
        System.out.println(rows);

    }

}
