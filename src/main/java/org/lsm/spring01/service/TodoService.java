package org.lsm.spring01.service;

import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.dto.TodoDTO;

public interface TodoService {
    void register(TodoDTO dto);
}
