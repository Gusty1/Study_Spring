package com.gusty.spring6.xmltx.controller;

import com.gusty.spring6.xmltx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    //買書的方法: 圖書ID & 用戶ID
    public void buyBook(Integer bookId , Integer userId){
        //調用service方法
        bookService.buyBook(bookId,userId);
    }

}
