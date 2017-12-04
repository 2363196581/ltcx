package com.connxun.app.repositories;

import com.connxun.app.entity.CxCarousel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author anna
 * @Date 2017-12-01 15:44
 * @Description
 */
@Repository
public interface ICxCarouselRepository extends JpaRepository<CxCarousel,Integer> {
}
