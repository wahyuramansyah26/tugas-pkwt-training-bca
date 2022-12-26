package controller;

import java.util.List;

import models.Book;
import repository.BookRepository;
import service.DaoService;

public class BookController {
    private static DaoService<Book, Integer> bookDao = new BookRepository();
    
    public List<Book> getBooks(){
        List<Book> books = bookDao.findAll();
        int iterasi = 1;
        if(books.isEmpty()) {
            System.out.println("Belum ada buku");
        }else {
            for (Book book : books) {
                System.out.println("Buku " + iterasi);
                System.out.println("Title : " + book.getTitle());
                System.out.println("Author : " + book.getAuthor());
                System.out.println();
                iterasi++;
            }
        }
        return books;
        
    }
    

    public Book getBookByid(Integer id){
        Book book = bookDao.findById(id);
        System.out.println("Title : " + book.getTitle());
        System.out.println("Author : " + book.getAuthor());
        return book;
    }

    public void saveBook(String title, String author){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookDao.save(book);
    }

    public void updateBook(Integer id, String title, String author){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookDao.update(book, id);
    }

    public void deleteBook(Integer id){
        bookDao.delete(id);
    }
}
