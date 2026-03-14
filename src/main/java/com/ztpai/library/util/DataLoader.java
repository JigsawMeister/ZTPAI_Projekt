
package com.ztpai.library.util;

import com.ztpai.library.model.Book;
import com.ztpai.library.model.User;
import com.ztpai.library.repository.BookRepository;
import com.ztpai.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            for (int i = 1; i <= 30; i++) {
                bookRepository.save(Book.builder()
                        .title("Book " + i)
                        .author("Author " + i)
                        .description("Description for book " + i)
                        .availableCopies(3)
                        .build());
            }
        }

        if (userRepository.count() == 0) {
            userRepository.save(User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .role("ADMIN")
                    .build());

            userRepository.save(User.builder()
                    .username("user1")
                    .password(passwordEncoder.encode("1234"))
                    .role("USER")
                    .build());
        }
    }
}
