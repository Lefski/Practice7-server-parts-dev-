package ru.mirea.mainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.mainservice.model.WashingMachine;

@Repository
public interface WashingMachineRepository extends JpaRepository<WashingMachine, Long> {
}
