package org.lsm.spring01.mapper;

import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.dto.PageRequestDTO;

import java.util.List;
import java.util.Optional;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO vo);
    List<TodoVO> selectAll();
    TodoVO selectOne(Long tno);
    void delete(Long tno);
    void update(TodoVO vo);
    List<TodoVO> selectList(PageRequestDTO dto);
    int getCount (PageRequestDTO dto);
}
