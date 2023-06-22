package com.gusty.spring6.iocxml.di;

public class Book {
    private String bname;
    private String author;
    private String others;

    //無參數構造方法
    public Book() {
        System.out.println("無參數構造執行了...");
    }
    //有參數構造方法
    public Book(String bname, String author) {
        System.out.println("有參數構造執行了...");
        this.bname = bname;
        this.author = author;
    }

    //生成setter方法

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //set方法注入
        Book book = new Book();
        book.setBname("java");
        book.setAuthor("Gusty");

        //通過構造器注入
        Book book1 = new Book("c++","we");
    }
}
