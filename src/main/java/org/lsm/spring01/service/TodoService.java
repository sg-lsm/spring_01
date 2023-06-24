package org.lsm.spring01.service;

import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.dto.PageRequestDTO;
import org.lsm.spring01.dto.PageResponseDTO;
import org.lsm.spring01.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO dto);
//    List<TodoDTO> getAll();
    PageResponseDTO<TodoDTO> getList(PageRequestDTO dto);
    TodoDTO getOne(Long tno);
    void remove(Long tno);
    void modify(TodoDTO dto);
}
