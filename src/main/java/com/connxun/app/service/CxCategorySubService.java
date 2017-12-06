package com.connxun.app.service;

import com.connxun.app.common.BaseService;
import com.connxun.app.entity.CxCategorySub;
import com.connxun.app.repositories.ICxCategorySubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author anna
 * @Date 2017-11-16 18:11
 * @Description
 */
@Service
public class CxCategorySubService   implements BaseService<CxCategorySub, Integer> {

    @Autowired
    private ICxCategorySubRepository iCxCategorySubRepository;

    @Override
    public <S extends CxCategorySub> S save(S entity) {
        return iCxCategorySubRepository.save(entity);
    }

    @Override
    public CxCategorySub findOne(Integer primaryKey) {
        return iCxCategorySubRepository.findOne(primaryKey);
    }

    @Transactional
    @Override
    public List<CxCategorySub> findAll() {
        return iCxCategorySubRepository.findAll();
    }

    @Override
    public long count() {
        return iCxCategorySubRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        iCxCategorySubRepository.delete(primaryKey);
    }

}
