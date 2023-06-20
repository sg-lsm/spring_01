package org.lsm.spring01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.dto.TodoDTO;
import org.lsm.spring01.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO dto){
        log.info(modelMapper);
        TodoVO vo = modelMapper.map(dto, TodoVO.class);
        log.info(vo);
        todoMapper.insert(vo);
    }
}

// DI를 이용해 DB처리하는 #TodoMapper와 #DTO를, VO의 변환을 처리하는 #ModelMapper를 주입.