package com.connxun.app.service;

import com.connxun.app.common.BaseService;
import com.connxun.app.common.page.PageableTools;
import com.connxun.app.common.sort.SortDto;
import com.connxun.app.entity.CxCard;
import com.connxun.app.repositories.ICxCardRepository;
import com.connxun.app.searchVO.CommonSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author anna
 * @Date 2017-11-12 23:32
 * @Description
 */
@Service
public class CxCardService  implements BaseService<CxCard, Integer> {

    @Autowired
    private ICxCardRepository iCxRepository;

    @Override
    public <S extends CxCard> S save(S entity) {
        return iCxRepository.save(entity);
    }

    @Override
    public CxCard findOne(Integer primaryKey) {
        return iCxRepository.findOne(primaryKey);
    }

    @Override
    public List<CxCard> findAll() {
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


    public Page<CxCard> findAll(CommonSearchVO commonSearchVO) {
        return iCxRepository.findAll(PageableTools.basicPage(commonSearchVO.getPageParams(),commonSearchVO.getLength(), new SortDto("desc", "recommendvalue")));
    }

    public CxCard findCxCardByCardid(String cardId){
        return iCxRepository.findCxCardByCardid(cardId);
    }

}
