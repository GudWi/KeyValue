package com.sdanilin.services;

import com.sdanilin.dao.BaseDao;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Default
@Dependent
public class BaseService {
    @Inject
    private BaseDao dao;

    public void putValue(String key, String value){
        dao.putValue(key, value);
    }

    public String getValue(String key){
        return dao.getValue(key);
    }

    public void deleteValue(String key){
        dao.deleteValue(key);
    }
}
