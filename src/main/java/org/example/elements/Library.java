package org.example.elements;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Book> books;
    private final List<User> users;
    private final List<Loan> loans;

    public Library(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public boolean loanBook(String isbn, Integer userCardNumber){
        Book book = findBookByIsbn(isbn);
        User user = findUserByCardNumber(userCardNumber);

        if(book == null || user == null){
            return false;
        }

        if(book.getAvailableCopies() == 0){
            return false;
        }

        book.setAvailableCopies(book.getAvailableCopies()-1);
        loans.add(new Loan(book, user, LocalDate.now()));
        return true;
    }

    public boolean returnBook(String isbn, Integer userCardNumber){
        for(Loan loan : loans){
            if(loan.getBook().getIsbn().equals(isbn) &&
                    loan.getUser().getUserCardNumber().equals(userCardNumber)&&
                    !loan.isLoaded()){

                loan.setLoaded(true);
                loan.getBook().setAvailableCopies(loan.getBook().getAvailableCopies()+1);
                return true;
            }
        }
        return false;
    }



    private Book findBookByIsbn(String isbn){
        for(Book book : books){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }

    private User findUserByCardNumber(Integer userCardNumber){
        for(User user : users){
            if(user.getUserCardNumber().equals(userCardNumber)){
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

    public void showBooks(){
        if(!books.isEmpty()){
            System.out.println("List of books: ");
            for(Book book : books){
                System.out.println(book);
            }
        } else{
            System.out.println("There is no books");
        }

    }

    public void showUsers(){
        System.out.println("List of users: ");
        if(!users.isEmpty()){
            for(User user : users){
                System.out.println(user);
            }
        } else{
            System.out.println("There is no users");
        }

    }

}
