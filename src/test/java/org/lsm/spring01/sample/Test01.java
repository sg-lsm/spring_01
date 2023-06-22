package org.lsm.spring01.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.dto.TodoDTO;
import org.lsm.spring01.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class Test01 {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TodoMapper todoMapper;

    @Test
    public void register(){
        log.info(modelMapper);
        TodoDTO dto = TodoDTO.builder().title("didi").localDate(LocalDate.now()).writer("123").build();
        TodoVO vo = modelMapper.map(dto, TodoVO.class);
        log.info(vo);
        todoMapper.insert(vo);
    }
}