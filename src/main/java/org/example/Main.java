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
        bookTest(book);

        User user = new User("Jan Kowalski", 1000);
        userTest(user);

        Loan loan = new Loan(book, user, LocalDate.now());
        loanTest(book, user, loan);


    }

    private static void bookTest(Book book){
        // Testowanie konstruktora
        assert "Wiedźmin".equals(book.getTitle()) : "Tytuł książki powinien być 'Wiedźmin'";
        assert "Andrzej Sapkowski".equals(book.getAuthor()) : "Autor książki powinien być 'Andrzej Sapkowski'";
        assert "978-83-7578-005-6".equals(book.getIsbn()) : "ISBN powinien być '978-83-7578-005-6'";
        assert book.getAvailableCopies() == 5 : "Liczba egzemplarzy powinna być 5";

        // Testowanie setterów
        book.setAvailableCopies(10);
        assert book.getAvailableCopies() == 10 : "Liczba egzemplarzy po zmianie powinna być 10";

        // Testowanie toString()
        String expected = "Book{Title='Wiedźmin', Author='Andrzej Sapkowski', ISBN='978-83-7578-005-6', Available Copies=10}";
        assert expected.equals(book.toString()) : "Metoda toString() w klasie Book nie zwraca oczekiwanego wyniku";

        System.out.println("Book test succeed");
    }

    private static void userTest(User user){

        //Testowanie konstruktora
        String nameExpected = "Jan Kowalski";
        int cardNumberExpecred = 1000;
        assert nameExpected.equals(user.getName()): "Użytkownik powinien być Jan Kowalski";
        assert  cardNumberExpecred == user.getCardNumber() : "Numer karty powinien być 1000";

        //Testowanie setterów
        user.setName("Jakub Nowak");
        assert user.getName().equals("Jakub Nowak") : "Użytkownik po zmianie powinien być Jakub Nowak";
        user.setCardNumber(1234);
        assert user.getCardNumber() == 1234 : "Numer karty powinien być 1234";

        //Testowanie toString()
        String expected = "User{Name='Jakub Nowak', Card Number='1234'}";
        assert expected.equals(user.toString()) : "Metoda toString() w klasie User nie zwraca oczekiwanego wyniku";
        System.out.println("User test succeed");
    }

    private static void loanTest(Book book, User user, Loan loan){
        assert loan.getBook().equals(book) : "Książka powinna być 'Wiedźmin'";
        assert loan.getUser().equals(user) : "Użytkownik powinien być 'Jan Kowalski'";
        assert loan.getReturnDate() == null : "Data zwrotu powinna być null (książka nie została zwrócona)";

        System.out.println("Loan test succeed");
    }
}