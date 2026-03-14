
package com.ztpai.library.service;

import com.ztpai.library.model.Book;
import com.ztpai.library.model.Reservation;
import com.ztpai.library.model.User;
import com.ztpai.library.repository.BookRepository;
import com.ztpai.library.repository.ReservationRepository;
import com.ztpai.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public Reservation reserveBook(Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        Reservation reservation = Reservation.builder()
                .book(book)
                .user(user)
                .reservationDate(LocalDate.now())
                .fulfilled(false)
                .build();

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
