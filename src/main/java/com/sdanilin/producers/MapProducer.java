package com.sdanilin.producers;

import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
@Default
public class MapProducer {
    private ConcurrentHashMap<String, String> map;

    @Inject
    private Logger logger;

    public ConcurrentHashMap<String, String> getMap(){
        if (map == null) {
            try {
                map = new ConcurrentHashMap<>();
            } catch (Exception e) {
                logger.error(e);
            }

        }
        return map;
    }
}
