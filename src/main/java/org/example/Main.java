package org.example;

import org.example.elements.*;

import java.sql.*;
import java.time.LocalDate;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/library_schema",
                    "root",
                    "haslo1234"
            );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            while (resultSet.next()){
                System.out.print(resultSet.getInt("idbooks") + ": ");
                System.out.print(resultSet.getString("title") + " ");
                System.out.println(resultSet.getInt("avaliableCopies"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





        //Welcome
        Library library = new Library();
        Menu menu = new Menu(library);

        Book book = new Book("Wiedźmin", "Andrzej Sapkowski", "123456", 1);
        //AssertTest.bookTest(book);
        library.addBook(book);

        User user = new User("Jan Kowalski", 1000);
        //AssertTest.userTest(user);
        library.addUser(user);

        Loan loan = new Loan(book, user, LocalDate.now());
        //AssertTest.loanTest(book, user, loan);

        //AssertTest.libraryTest(book, user, library);

        menu.start();
    }
}