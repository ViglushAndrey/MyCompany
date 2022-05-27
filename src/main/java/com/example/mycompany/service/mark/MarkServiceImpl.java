package com.example.mycompany.service.mark;

import com.example.mycompany.DAO.Mark.MarkDAOImpl;
import com.example.mycompany.DTO.Mark.MarkDTOCreate;
import com.example.mycompany.DTO.Mark.MarkDTOUpdate;
import com.example.mycompany.model.Mark;
import com.example.mycompany.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements IMarkService{


    private final MarkDAOImpl dao;


    private final MarkRepository repository;


    public Mark getById(Long id){
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Mark create(Mark mark) {
        return dao.create(mark);
    }

    @Override
    public Mark update(Mark mark) {
        return dao.update(mark);
    }

    public Mark createDTO(MarkDTOCreate request){

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var mark = Mark.builder()
                .id(id)
                .transportmark(request.getTransportmark())
                .build();

        return repository.save(mark);
    }

    public Mark updateDTO(MarkDTOUpdate request){

        var mark = Mark.builder()
                .id(repository.findById(request.getId()).get().getId())
                .transportmark(request.getTransportmark())
                .build();

        return repository.save(mark);
    }
}
