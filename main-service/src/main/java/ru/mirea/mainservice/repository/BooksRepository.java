package ru.mirea.mainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.mainservice.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
}
