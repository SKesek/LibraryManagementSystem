package org.example;

import org.example.elements.Book;
import org.example.elements.Loan;
import org.example.elements.User;


import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        //Welcome
        System.out.println("Hello in Library Managment System!");

        Book book = new Book("Wiedźmin", "Andrzej Sapkowski", "978-83-7578-005-6", 5);
        AssertTest.bookTest(book);

        User user = new User("Jan Kowalski", 1000);
        AssertTest.userTest(user);

        Loan loan = new Loan(book, user, LocalDate.now());
        AssertTest.loanTest(book, user, loan);


    }
}