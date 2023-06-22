package com.gusty.spring6.tx.controller;

import com.gusty.spring6.tx.service.BookService;
import com.gusty.spring6.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    //@Autowired
    //private BookService bookService;

    //買書的方法: 圖書ID & 用戶ID
//    public void buyBook(Integer bookId , Integer userId){
//        //調用service方法
//        bookService.buyBook(bookId,userId);
//    }

    @Autowired
    private CheckoutService checkoutService;

    public void checkout(Integer[] bookIds, Integer userId) {
        checkoutService.checkout(bookIds, userId);

    }
}
