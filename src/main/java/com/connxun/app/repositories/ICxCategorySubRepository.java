package com.connxun.app.repositories;

import com.connxun.app.entity.CxCategorySub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author anna
 * @Date 2017-11-16 17:19
 * @Description
 */
@Repository
public interface ICxCategorySubRepository extends JpaRepository<CxCategorySub,Integer> {

}
