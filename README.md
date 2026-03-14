# ZTPAI_Projekt

ibrary Management System
Opis projektu

Aplikacja biblioteki umożliwia:
    Rejestrację i logowanie użytkowników (role: user, admin)
    Przeglądanie katalogu książek
    Wypożyczanie książek, prolongaty i rezerwacje
    Admin może dodawać nowe książki do katalogu


Backend: Spring Boot + JWT + PostgreSQL
Frontend: React + Vite
Uwierzytelnianie i autoryzacja JWT
Obsługa CORS i responsywny frontend

Wymagania
    Java 17+
    Maven
    Node.js 18+
    PostgreSQL
    Przeglądarka (Chrome, Firefox, Edge)

Konfiguracja bazy danych
    Stwórz bazę w PostgreSQL np. library_db
    Stwórz użytkownika i nadaj hasło (np. library_user / password)
    Zaktualizuj application.properties w backendzie:

    spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
    spring.datasource.username=library_user
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    
Uruchomienie backendu (Spring Boot)

    Otwórz projekt w NetBeans lub innym IDE Maven
    Zatrzymaj wszystkie działające serwery
    W terminalu uruchom:
    mvn clean install
    mvn spring-boot:run

    Backend powinien być dostępny na:
    http://localhost:8080

Test: http://localhost:8080/swagger-ui/index.html – dostęp do dokumentacji API

🚀 Uruchomienie frontendu (React + Vite)
Przejdź do katalogu frontendu (np. frontend/)
    cd frontend
    Zainstaluj zależności:
    npm install
    Uruchom frontend:
    npm run dev

Frontend powinien być dostępny na:
http://localhost:5173

🔑 Logowanie i token

Po zalogowaniu token JWT jest zapisywany w localStorage

Frontend automatycznie wysyła token w nagłówkach Authorization: Bearer <token>

🛠 Funkcjonalności
Backend

/auth/register – rejestracja użytkownika

/auth/login – logowanie użytkownika

/books – pobranie listy książek (GET)

/loans/{bookId} – wypożyczenie książki (POST)

Frontend

Strona logowania / rejestracji

Wyświetlanie książek

Wypożyczanie książek

Wylogowanie

💡 Uwagi

Backend używa BCryptPasswordEncoder do bezpiecznego haszowania haseł

CORS jest włączony dla http://localhost:5173

Token JWT jest weryfikowany przy każdym wywołaniu chronionych endpointów

🧹 Porządkowanie

Jeśli zmieniasz klasy w backendzie, zatrzymaj serwer i odśwież projekt w IDE przed ponownym uruchomieniem

Jeśli frontend pokazuje błędy Failed to fetch, sprawdź czy token jest zapisany w localStorage i backend działa na porcie 8080