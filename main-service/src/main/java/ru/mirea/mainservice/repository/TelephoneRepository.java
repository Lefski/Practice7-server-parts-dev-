package ru.mirea.mainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.mainservice.model.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}
