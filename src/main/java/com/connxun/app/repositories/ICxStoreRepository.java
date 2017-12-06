package com.connxun.app.repositories;

import com.connxun.app.entity.CxStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author anna
 * @Date 2017-12-05 16:44
 * @Description
 */
@Repository
public interface ICxStoreRepository extends JpaRepository<CxStore,Integer>,JpaSpecificationExecutor<CxStore> {
}
