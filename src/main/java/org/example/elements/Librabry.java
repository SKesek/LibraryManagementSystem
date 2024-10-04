package org.example.elements;

import java.util.ArrayList;
import java.util.List;

public class Librabry {

    private final List<Book> books;
    private final List<User> users;
    private final List<Loan> loans;

    public Librabry(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.loans = new ArrayList<>();
    }



    private Book findBookByIsbn(String isbn){
        for(Book book : books){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }

    private User findUserByCardNumber(Integer cardNumber){
        for(User user : users){
            if(user.getCardNumber().equals(cardNumber)){
                return user;
            }
        }
        return  null;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addUser(User user){
        users.add(user);
    }

}
