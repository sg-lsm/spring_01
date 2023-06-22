package org.lsm.spring01.mapper;

import org.lsm.spring01.domain.TodoVO;

import java.util.Optional;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO vo);
}
