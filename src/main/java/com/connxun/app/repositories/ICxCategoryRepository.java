package com.connxun.app.repositories;

import com.connxun.app.entity.CxCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author anna
 * @Date 2017-11-16 16:08
 * @Description
 */
@Repository
public interface ICxCategoryRepository extends JpaRepository<CxCategory,Integer> {


}
