package com.gusty.spring6.xmltx.service;

import com.gusty.spring6.xmltx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//業務邏輯層
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    //買書的方法: 圖書ID & 用戶ID
    @Override
    public void buyBook(Integer bookId, Integer userId) {

        //根據圖書ID查詢圖書價格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        //更新圖書表庫存量-1
        bookDao.updateStock(bookId);

        //更新用戶表用戶餘額 - 圖書價格
        bookDao.updateUserBalance(userId, price);

    }
}
