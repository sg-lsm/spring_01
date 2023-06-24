package org.lsm.spring01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.dto.PageRequestDTO;
import org.lsm.spring01.dto.PageResponseDTO;
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

    /*
    @Override
    public List<TodoDTO> getAll(){
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo->modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }
     */

    @Override
    public TodoDTO getOne(Long tno){
        TodoVO vo = todoMapper.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);
        return dto;
    }

    @Override
    public void remove(Long tno){
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO dto){
        TodoVO vo = modelMapper.map(dto, TodoVO.class);
        todoMapper.update(vo);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList (PageRequestDTO dto){
        List<TodoVO> voList = todoMapper.selectList(dto);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        int total = todoMapper.getCount(dto);
        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .dto(dto)
                .build();
        // PageResponseDTO에서 지정한 빌더 메서드인 withAll()에 제네릭스를 준 이유는 반환타입 지정목적 ( 결국 이 메서드는 TodoDTO 데이터 타입을 반환한다.)
        return pageResponseDTO;
    }
}

// DI를 이용해 DB처리하는 #TodoMapper와 #DTO를, VO의 변환을 처리하는 #ModelMapper를 주입.