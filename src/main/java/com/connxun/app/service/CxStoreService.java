package com.connxun.app.service;

import com.connxun.app.common.BaseService;
import com.connxun.app.entity.CxStore;
import com.connxun.app.repositories.ICxStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author anna
 * @Date 2017-12-05 16:45
 * @Description
 */
@Service
public class CxStoreService implements BaseService<CxStore, Integer> {

    @Autowired
    private ICxStoreRepository iCxRepository;

    @Override
    public <S extends CxStore> S save(S entity) {
        return iCxRepository.save(entity);
    }

    @Override
    public CxStore findOne(Integer primaryKey) {
        return iCxRepository.findOne(primaryKey);
    }

    @Override
    public List<CxStore> findAll() {
        return iCxRepository.findAll();
    }

    @Override
    public long count() {
        return iCxRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        iCxRepository.delete(primaryKey);
    }
}
