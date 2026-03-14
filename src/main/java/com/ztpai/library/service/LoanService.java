
package com.ztpai.library.service;

import com.ztpai.library.model.Book;
import com.ztpai.library.model.Loan;
import com.ztpai.library.model.User;
import com.ztpai.library.repository.BookRepository;
import com.ztpai.library.repository.LoanRepository;
import com.ztpai.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public Loan borrowBook(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        if (book.getAvailableCopies() <= 0) throw new RuntimeException("Book not available");

        User user = userRepository.findById(userId).orElseThrow();

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        Loan loan = Loan.builder()
                .book(book)
                .user(user)
                .loanDate(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(14))
                .returned(false)
                .build();

        return loanRepository.save(loan);
    }

    public void returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow();
        loan.setReturned(true);

        Book book = loan.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);

        loanRepository.save(loan);
    }
}
