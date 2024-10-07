package org.example.elements;

import java.util.Scanner;

public class Menu {

    private final Library library;
    private final Scanner scanner;

    public Menu(Library library){
        this.library = library;
        this.scanner = new Scanner(System.in);
        System.out.println("Welcome in Library Managment System!");
    }

    public void start(){
        while (true){
            showMenu();
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice){
                case 1:
                    addBook();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    loanBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    showBooks();
                    break;
                case 6:
                    showUsers();
                    break;
                case 0:
                    System.out.println("Thank you! Good bye!");
                    return;
                default:
                    System.out.println("Incorrect input. Try again.");
                    break;

            }

        }
    }

    private void showMenu() {
        System.out.println("1. Add book");
        System.out.println("2. Add user");
        System.out.println("3. Loan book");
        System.out.println("4. Return book");
        System.out.println("5. Show books");
        System.out.println("6. Show users");
        System.out.println("0. Exit");
        System.out.print("Choose one option: ");
    }

    private void addBook() {
        System.out.print("Book title: ");
        String title = scanner.nextLine();
        System.out.print("Book author: ");
        String author = scanner.nextLine();
        System.out.print("Book isbn: ");
        String isbn = scanner.nextLine();
        int availableCopies = scanner.nextInt();
        scanner.nextLine();

        library.addBook(new Book(title, author, isbn, availableCopies));
        System.out.println("Book has been added");

    }

    private void addUser() {
        System.out.print("User name: ");
        String name = scanner.nextLine();
        System.out.print("User card number: ");
        Integer userCardNumber = scanner.nextInt();
        scanner.nextLine();

        library.addUser(new User(name, userCardNumber));
        System.out.println("User has been added");
    }

    private void loanBook(){
        System.out.println("_________________");
        System.out.println("LOAN BOOK");
        System.out.println("_________________");
        System.out.print("Give ISBN number: ");
        String isbn = scanner.nextLine();
        System.out.print("Give user card number: ");
        Integer userCardNumber = scanner.nextInt();
        scanner.nextLine();

        if(library.loanBook(isbn,userCardNumber)){
            System.out.println("Loan succeed");
        } else {
            System.out.println("Loan failed");
        }
    }

    private void returnBook(){
        System.out.println("_________________");
        System.out.println("RETUR BOOK");
        System.out.println("_________________");
        System.out.println("Give ISBN: ");
        String isbn = scanner.nextLine();
        System.out.println("Give user card number: ");
        Integer userCardNumber = scanner.nextInt();
        scanner.nextLine();

        if(library.returnBook(isbn, userCardNumber)){
            System.out.println("Return succeed");
        }else {
            System.out.println("Return failed");
        }
    }

    private void showBooks(){
        library.showBooks();
    }

    private void showUsers(){
        library.showUsers();
    }



}
