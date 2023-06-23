package org.lsm.spring01.service;

import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO dto);
    List<TodoDTO> getAll();
    TodoDTO getOne(Long tno);
}
