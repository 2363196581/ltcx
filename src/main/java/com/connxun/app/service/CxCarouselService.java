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
    private ICxCarouselRepository iCxCarouselRepository;

    @Override
    public <S extends CxCarousel> S save(S entity) {
        return iCxCarouselRepository.save(entity);
    }

    @Override
    public CxCarousel findOne(Integer primaryKey) {
        return iCxCarouselRepository.findOne(primaryKey);
    }

    @Override
    public List<CxCarousel> findAll() {
        return iCxCarouselRepository.findAll();
    }

    @Override
    public long count() {
        return iCxCarouselRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        iCxCarouselRepository.delete(primaryKey);
    }
}
