package org.lsm.spring01.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lsm.spring01.mapper.TimeMapper;
import org.lsm.spring01.mapper.TimeMapper02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MapperTest{
    @Autowired(required = false)
    private TimeMapper mapper;
    @Autowired(required = false)
    private TimeMapper02 mapper02;


    @Test
    public void TimeTest(){
        log.info(mapper.getTime());
    }

    @Test
    public void TimeTest02(){
        log.info(mapper02.getNow());
    }
}