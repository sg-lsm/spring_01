package org.lsm.spring01.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lsm.spring01.domain.TodoVO;
import org.lsm.spring01.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MapperTodoTest {
    @Autowired(required = false)
    private TodoMapper mapper;

    @Test
    public void testGetTime(){
        log.info(mapper);
    }
    @Test
    public void testInsert(){
        TodoVO vo = TodoVO.builder()
                .title("테스트01")
                .localDate(LocalDate.now())
                .writer("user00")
                .build();
        mapper.insert(vo);
    }

    @Test
    public void testSelectAll(){
        List<TodoVO> voList = mapper.selectAll();
        voList.forEach(log::info);
        voList.forEach(v->log.info(v.getTitle()));
    }

    @Test
    public void testSelectOne(){
        TodoVO vo = mapper.selectOne(4L);
        log.info(vo);
    }
}
