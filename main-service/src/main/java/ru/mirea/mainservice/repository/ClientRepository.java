package ru.mirea.mainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.mainservice.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
