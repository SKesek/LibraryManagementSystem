package org.example.elements;

import java.time.LocalDate;

public class Loan {

    private Book book;
    private User user;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Book book, User user, LocalDate localDate){
        this.book = book;
        this.user = user;
        this.loanDate = localDate;
        this.returnDate = null;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book.getTitle() +
                ", user=" + user.getName() +
                ", loanDate=" + loanDate +
                ", returnDate=" + (returnDate != null ? returnDate : "Not returned") +
                '}';
    }
}


