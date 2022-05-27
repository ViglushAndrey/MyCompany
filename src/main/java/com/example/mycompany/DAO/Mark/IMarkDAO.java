package com.example.mycompany.DAO.Mark;

import com.example.mycompany.model.Mark;
import org.springframework.stereotype.Service;

@Service
public interface IMarkDAO {

    Mark create (Mark mark);
    Mark update (Mark mark);

}
