package org.lsm.spring01.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("event")
public class SampleEventDaoImpl implements SampleDAO{

}
