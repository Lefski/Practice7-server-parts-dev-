package ru.mirea.mainservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.mainservice.model.WashingMachine;
import ru.mirea.mainservice.repository.WashingMachineRepository;

@Service
public class WashingMachineServiceImpl extends BaseImpl<WashingMachine, Long> implements WashingMachineService {

    @Autowired
    public WashingMachineServiceImpl(WashingMachineRepository repository) {
        super(repository);
    }
}
