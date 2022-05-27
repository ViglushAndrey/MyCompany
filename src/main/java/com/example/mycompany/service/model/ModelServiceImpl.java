package com.example.mycompany.service.model;


import com.example.mycompany.DAO.Model.ModelDAOImpl;
import com.example.mycompany.DTO.Model.ModelDTOCreate;
import com.example.mycompany.DTO.Model.ModelDTOUpdate;
import com.example.mycompany.model.Model;
import com.example.mycompany.repository.AutoRepository;
import com.example.mycompany.repository.MarkRepository;
import com.example.mycompany.repository.ModelRep;
import com.example.mycompany.repository.MotoRep;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements IModelService{

    @Autowired
    ModelDAOImpl dao;

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    MotoRep motoRep;

    @Autowired
    MarkRepository markRepository;

    private final ModelRep repository;

    public Page<Model> getAll(Integer page, Integer size){
        var pageble = PageRequest.of(page, size);
        return repository.findAll(pageble);
    }

    public Model createDTO(ModelDTOCreate request) {
        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var model = Model.builder()
                .id(id)
                .carModel(request.getCarModel())
                .mark(markRepository.findById(request.getMark()).get())
                .build();

        return repository.save(model);
    }

    public Model updateDTO(ModelDTOUpdate request) {

        var model = Model.builder()
                .id(repository.findById(request.getId()).get().getId())
                .carModel(request.getCarModel())
                .mark(markRepository.findById(request.getMark()).get())
                .build();

        return repository.save(model);
    }

    @Override
    public Model create(Model model) {
        return dao.create(model);
    }

    @Override
    public Model update(Model model) {
        return dao.update(model);
    }
}
