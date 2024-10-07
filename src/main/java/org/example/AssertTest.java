package org.example;

import org.example.elements.Book;
import org.example.elements.Library;
import org.example.elements.Loan;
import org.example.elements.User;

public class AssertTest {

    public static void bookTest(Book book){
        // Testowanie konstruktora
        assert "Wiedźmin".equals(book.getTitle()) : "Tytuł książki powinien być 'Wiedźmin'";
        assert "Andrzej Sapkowski".equals(book.getAuthor()) : "Autor książki powinien być 'Andrzej Sapkowski'";
        assert "123456".equals(book.getIsbn()) : "ISBN powinien być '123456'";
        assert book.getAvailableCopies() == 1 : "Liczba egzemplarzy powinna być 1";

        // Testowanie setterów
        book.setAvailableCopies(1);
        assert book.getAvailableCopies() == 1 : "Liczba egzemplarzy po zmianie powinna być 1";

        // Testowanie toString()
        String expected = "Book{Title='Wiedźmin', Author='Andrzej Sapkowski', ISBN='123456', Available Copies=1}";
        assert expected.equals(book.toString()) : "Metoda toString() w klasie Book nie zwraca oczekiwanego wyniku";

        System.out.println("Book test succeed");
    }

    public static void userTest(User user){

        //Testowanie konstruktora
        String nameExpected = "Jan Kowalski";
        int cardNumberExpecred = 1000;
        assert nameExpected.equals(user.getName()): "Użytkownik powinien być Jan Kowalski";
        assert  cardNumberExpecred == user.getUserCardNumber() : "Numer karty powinien być 1000";

        //Testowanie setterów
        user.setName("Jakub Nowak");
        assert user.getName().equals("Jakub Nowak") : "Użytkownik po zmianie powinien być Jakub Nowak";
        user.setUserCardNumber(1234);
        assert user.getUserCardNumber() == 1234 : "Numer karty powinien być 1234";

        //Testowanie toString()
        String expected = "User{Name='Jakub Nowak', Card Number='1234'}";
        assert expected.equals(user.toString()) : "Metoda toString() w klasie User nie zwraca oczekiwanego wyniku";
        System.out.println("User test succeed");
    }

    public static void loanTest(Book book, User user, Loan loan){
        assert loan.getBook().equals(book) : "Książka powinna być 'Wiedźmin'";
        assert loan.getUser().equals(user) : "Użytkownik powinien być 'Jan Kowalski'";
        assert loan.getReturnDate() == null : "Data zwrotu powinna być null (książka nie została zwrócona)";

        System.out.println("Loan test succeed");
    }

    public static void libraryTest(Book book, User user, Library library){
        library.addBook(book);
        library.addUser(user);


        assert library.loanBook("123456", 1234) : "Książka powinna zostać wypożyczona.";
        assert !library.loanBook("123456", 1234) : "Nie powinna być dostępna kolejna kopia.";
        assert library.returnBook("123456", 1234) : "Książka powinna zostać zwrócona.";
        assert library.loanBook("123456", 1234) : "Książka powinna zostać wypożyczona.";

        System.out.println("Library test succeed");
    }
}
