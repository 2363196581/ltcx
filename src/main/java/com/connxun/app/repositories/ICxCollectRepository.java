package com.connxun.app.repositories;

import com.connxun.app.entity.CxCollect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author anna
 * @Date 2017-12-04 21:29
 * @Description
 */
@Repository
public interface ICxCollectRepository extends JpaRepository<CxCollect,Integer>,JpaSpecificationExecutor<CxCollect> {

}
