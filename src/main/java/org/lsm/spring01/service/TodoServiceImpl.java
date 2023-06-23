package org.lsm.spring01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.dto.TodoDTO;
import org.lsm.spring01.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO dto){
        log.info(dto);
        TodoVO vo = modelMapper.map(dto, TodoVO.class);
        log.info(vo);
        todoMapper.insert(vo);
    }

    @Override
    public List<TodoDTO> getAll(){
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo->modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO getOne(Long tno){
        TodoVO vo = todoMapper.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);
        return dto;
    }
}

// DI를 이용해 DB처리하는 #TodoMapper와 #DTO를, VO의 변환을 처리하는 #ModelMapper를 주입.