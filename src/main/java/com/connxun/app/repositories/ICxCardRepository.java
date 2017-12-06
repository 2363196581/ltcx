package com.connxun.app.repositories;

import com.connxun.app.entity.CxCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author anna
 * @Date 2017-11-12 23:30
 * @Description
 */
@Repository
public interface ICxCardRepository  extends JpaRepository<CxCard,Integer>,JpaSpecificationExecutor<CxCard> {

    /**
     * 通过cardId获取名片
     * @param cardId
     * @return
     */
    CxCard findCxCardByCardid(String cardId);


}
