package com.connxun.app.repositories;

import com.connxun.app.entity.CxUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author anna
 * @Date 2017-11-11 14:23
 * @Description
 */
@Repository
public interface ICxUserRepository extends JpaRepository<CxUser,Integer>,JpaSpecificationExecutor<CxUser> {

    /**
     * 通过用户手机获取用户
     * @param phone
     * @return
     */
    CxUser findCxUserByPhone(String phone);

    /**
     * 通过userId获取用户
     * @param userId
     * @return
     */
    CxUser findCxUserByUserid(String userId);

    /**
     * @Author：luoxiaosheng
     * @Date：2017-11-17 10:44
     * @Description：
     */
    CxUser findCxUserByqqidOrWxidOrSinaid(String qqid,String wxid, String sinaid);

    /**
     * 获取用户列表()
     * @return  ?1 或 :phone、@Param("phone") String phone
     */
    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT  u  FROM CxUser u where 1=1 And phone like CONCAT('%',?1,'%')")
    Page<CxUser> getList(String phone, Pageable pageable);





}
