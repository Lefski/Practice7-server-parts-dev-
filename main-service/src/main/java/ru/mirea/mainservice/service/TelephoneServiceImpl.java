package ru.mirea.mainservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.mainservice.model.Telephone;
import ru.mirea.mainservice.repository.TelephoneRepository;

@Service
public class TelephoneServiceImpl extends BaseImpl<Telephone, Long> implements TelephoneService {

    @Autowired
    public TelephoneServiceImpl(TelephoneRepository repository) {
        super(repository);
    }
}
