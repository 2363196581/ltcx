package com.connxun.app.service;

import com.connxun.app.common.BaseService;
import com.connxun.app.entity.CxCollect;
import com.connxun.app.repositories.ICxCollectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author anna
 * @Date 2017-12-04 21:30
 * @Description
 */
@Service
public class CxCollectService implements BaseService<CxCollect, Integer> {

    @Autowired
    private ICxCollectRepository iCxRepository;

    @Override
    public <S extends CxCollect> S save(S entity) {
        return iCxRepository.save(entity);
    }

    @Override
    public CxCollect findOne(Integer primaryKey) {
        return iCxRepository.findOne(primaryKey);
    }

    @Override
    public List<CxCollect> findAll() {
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
