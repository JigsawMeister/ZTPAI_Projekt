
package com.ztpai.library.controller;

import com.ztpai.library.model.Reservation;
import com.ztpai.library.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/{bookId}/{userId}")
    public Reservation reserve(@PathVariable Long bookId, @PathVariable Long userId) {
        return reservationService.reserveBook(bookId, userId);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }
}
