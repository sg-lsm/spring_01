package org.lsm.spring01.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {
    @Autowired
    private SampleService service;
    @Autowired
    private DataSource ds;

    @Test
    public void testService(){
        log.info(service);
        Assertions.assertNotNull(service);
    }

    @Test
    public void ConnectionTest() throws Exception{
        Connection conn = ds.getConnection();
        log.info(conn);
        Assertions.assertNotNull(conn);
        conn.close();
    }
}
