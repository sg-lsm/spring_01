package org.lsm.spring01.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("normal")
public class SampleDaoImpl implements SampleDAO{

}
