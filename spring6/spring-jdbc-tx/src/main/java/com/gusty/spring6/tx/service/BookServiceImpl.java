package com.gusty.spring6.tx.service;

import com.gusty.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

//業務邏輯層

//預設false。只能對資料庫作query，用其他操作會報錯
//@Transactional(readOnly = true)

//預設-1永不超時。超時設定(秒)，若超過即報錯
//@Transactional(timeout = 3)

//若出現該異常(異常.class)，則不rollback
//@Transactional(noRollbackFor = ArithmeticException.class)

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    //買書的方法: 圖書ID & 用戶ID
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        /*模擬超時效果
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        */

        //根據圖書ID查詢圖書價格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        //更新圖書表庫存量-1
        bookDao.updateStock(bookId);

        //更新用戶表用戶餘額 - 圖書價格
        bookDao.updateUserBalance(userId, price);

        /*
        noRollbackFor模擬測試
        System.out.println(1/0);
        */
    }
}
