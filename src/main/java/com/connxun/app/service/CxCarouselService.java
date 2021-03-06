package com.connxun.app.service;

import com.connxun.app.common.BaseService;
import com.connxun.app.entity.CxCarousel;
import com.connxun.app.repositories.ICxCarouselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author anna
 * @Date 2017-12-01 15:46
 * @Description
 */
@Service
public class CxCarouselService  implements BaseService<CxCarousel, Integer> {

    @Autowired
    private ICxCarouselRepository iCxRepository;

    @Override
    public <S extends CxCarousel> S save(S entity) {
        return iCxRepository.save(entity);
    }

    @Override
    public CxCarousel findOne(Integer primaryKey) {
        return iCxRepository.findOne(primaryKey);
    }

    @Override
    public List<CxCarousel> findAll() {
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
