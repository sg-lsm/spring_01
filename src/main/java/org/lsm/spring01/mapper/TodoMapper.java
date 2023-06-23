package org.lsm.spring01.mapper;

import org.lsm.spring01.domain.TodoVO;

import java.util.List;
import java.util.Optional;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO vo);
    List<TodoVO> selectAll();
    TodoVO selectOne(Long tno);
}
