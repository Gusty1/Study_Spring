package com.gusty.spring6.tx.service;

import org.springframework.stereotype.Repository;


public interface BookService {

    void buyBook(Integer bookId,Integer userId);
}
