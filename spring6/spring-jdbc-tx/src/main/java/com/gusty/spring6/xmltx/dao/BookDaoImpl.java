package com.gusty.spring6.xmltx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//數據訪問層
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根據圖書ID查詢圖書價格
    @Override
    public Integer getBookPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id=?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;

    }

    //更新圖書表庫存量-1
    @Override
    public void updateStock(Integer bookId) {
        String sql = "update t_book set stock=stock-1 where book_id=?";
        jdbcTemplate.update(sql, bookId);

    }

    //更新用戶表用戶餘額 - 圖書價格
    @Override
    public void updateUserBalance(Integer userId, Integer price) {
        String sql = "update t_user set balance=balance-? where user_id=?";
        jdbcTemplate.update(sql, price, userId);

    }
}
