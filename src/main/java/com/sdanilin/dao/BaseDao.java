package com.sdanilin.dao;

import com.sdanilin.producers.MapProducer;
import org.apache.log4j.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Default
@Dependent
public class BaseDao {
    @Inject
    private Logger logger;

    @Inject
    private MapProducer mapProducer;

    public void putValue(String key, String value){
        mapProducer.getMap().put(key, value);

        logger.debug("PUT key = " + key + " value = " + value);
    }

    public String getValue(String key){
        String value = mapProducer.getMap().get(key);

        logger.debug("GET key = " + key + " value = " + value);
        return value;
    }

    public void deleteValue(String key){
        mapProducer.getMap().remove(key);
        logger.debug("DELETE key = " + key);
    }
}
