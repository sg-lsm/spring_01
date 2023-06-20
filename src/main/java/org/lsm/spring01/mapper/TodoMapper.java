package org.lsm.spring01.mapper;

import org.lsm.spring01.domain.TodoVO;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO vo);
}
