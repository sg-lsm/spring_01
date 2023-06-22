package org.lsm.spring01.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.dto.TodoDTO;
import org.lsm.spring01.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTest {
    @Autowired
    private TodoService service;

    @Test
    public void todoReg(){
        TodoDTO dto = TodoDTO.builder()
                .title("hello")
                .localDate(LocalDate.now())
                .writer("hello")
                .build();
        log.info(dto);
        service.register(dto);
    }
}
