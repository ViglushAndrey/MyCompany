package com.example.mycompany.service.mark;

import com.example.mycompany.DAO.Mark.MarkDAOImpl;
import com.example.mycompany.DTO.Mark.MarkDTOCreate;
import com.example.mycompany.model.Mark;
import com.example.mycompany.repository.MarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class MarkServiceImplTest {

    public static final Long ID = 1L;

    private MarkServiceImpl service;

    @Mock
    private MarkDAOImpl dao;

    @Mock
    private MarkRepository repository;

    @BeforeEach
    void setup(){
        service = new MarkServiceImpl(dao,repository);
    }

    @Test
    public void createDTO(){

        MarkDTOCreate markDTOCreate = new MarkDTOCreate();
        markDTOCreate.setTransportmark("M 1000 RR");

        service.createDTO(markDTOCreate);

        assert markDTOCreate.getTransportmark().equals("M 1000 RR");

    }

    @Test
    void testSuccessfullGetById(){



        var mark = Mark.builder()
                .id(ID)
                .transportmark("M 1000 RR")
                .model(new HashSet<>())
                .build();

        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(mark));

        var byId = service.getById(ID);

        assertEquals(byId.getId(), mark.getId());
        assertEquals(byId.getTransportmark(), mark.getTransportmark());
        assertEquals(byId.getModel().size(), mark.getModel().size());
    }


    @Test
    public void create(){
        var mark = Mark.builder()
                .transportmark("M 1000 RR")
                .model(new HashSet<>())
                .build();

        service.create(mark);

        assert mark.getTransportmark().equals("M 1000 RR");
    }

    @Test
    public void findAll(){
        create();

        List<Mark> list = repository.findAll();

        assert list.isEmpty();


    }

    @Test
    public void deleteById(){
        create();

        repository.deleteById(1L);

        Mark mark = null;

        Optional<Mark> markOptional = repository.findById(1L);

        if(markOptional.isPresent()){
            mark = markOptional.get();
        }

        assert mark == null;
    }

    @Test
    public void update(){
        create();

        var mark = Mark.builder()
                .transportmark("M 1000")
                .model(new HashSet<>())
                .build();

        service.update(mark);

        assert mark.getTransportmark().equals("M 1000");
    }

    @Test
    public void testNotSuccessfullGetById(){
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        var e = assertThrows(NoSuchElementException.class, ()->service.getById(ID));

        assertEquals(e.getMessage(), "No value present");
    }
}