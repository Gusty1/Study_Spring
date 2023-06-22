package com.gusty.spring6.xmltx.dao;

public interface BookDao {
    //根據圖書ID查詢圖書價格
    Integer getBookPriceByBookId(Integer bookId);

    //更新圖書表庫存量-1
    void updateStock(Integer bookId);

    //更新用戶表用戶餘額 - 圖書價格
    void updateUserBalance(Integer userId, Integer price);
}
