
package com.ztpai.library.controller;

import com.ztpai.library.model.Loan;
import com.ztpai.library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/borrow/{bookId}/{userId}")
    public Loan borrow(@PathVariable Long bookId, @PathVariable Long userId) {
        return loanService.borrowBook(bookId, userId);
    }

    @PostMapping("/return/{loanId}")
    public void returnBook(@PathVariable Long loanId) {
        loanService.returnBook(loanId);
    }
}
