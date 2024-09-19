package com.api.book.book.service;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import com.api.book.book.model.Book;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();

    static{
        list.add(new Book(1,"java","james gosling"));
        list.add(new Book(2,"meluha","Amish tripathi"));
        list.add(new Book(3,"it ends with us","collen hover"));
    }
    
    public List<Book> getAllBooks(){
        return list;
    }

    public Book getBookById(int id){

       Book book = null;
       try{
       book= list.stream()
       .filter(e->e.getId()==id)
       .findFirst().get();
      
    }
       catch(Exception e){
        e.printStackTrace();
       }
       return book;
    }

    public Book addBook(Book b) {
        list.add(b);
        return b;

    }

    public void deleteBook(int bid){
    
        try{
        list =  list.stream()
           .filter(e->e.getId()!=bid)
           .collect(Collectors.toList());}
        catch(Exception e){
            e.printStackTrace();
            }
    }

    public void updateBook(Book book,int bookId){
        try{
        list = list.stream().map(b->{
            if (b.getId()==bookId)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }

            return b;
        })
        .collect(Collectors.toList());}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
