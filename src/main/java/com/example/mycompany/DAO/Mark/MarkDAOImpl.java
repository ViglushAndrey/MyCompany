package com.example.mycompany.DAO.Mark;

import com.example.mycompany.model.Mark;
import com.example.mycompany.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkDAOImpl implements IMarkDAO{

    @Autowired
    MarkRepository repository;

    @Override
    public Mark create(Mark mark) {

        Long id = (long) (repository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        mark.setId(id);

        repository.save(mark);
        return mark;
    }

    @Override
    public Mark update(Mark mark) {

        mark.setId(mark.getId());

        repository.save(mark);
        return mark;
    }
}
