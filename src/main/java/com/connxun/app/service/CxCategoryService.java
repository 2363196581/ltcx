package com.connxun.app.service;

import com.connxun.app.common.BaseService;
import com.connxun.app.common.PageableTools;
import com.connxun.app.entity.CxCategory;
import com.connxun.app.repositories.ICxCategoryRepository;
import com.connxun.app.searchVO.CommonSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author anna
 * @Date 2017-11-16 16:10
 * @Description
 */
@Service
public class CxCategoryService  implements BaseService<CxCategory, Integer> {

    @Autowired
    private ICxCategoryRepository iCxCategoryRepository;

    @Override
    public <S extends CxCategory> S save(S entity) {
        return iCxCategoryRepository.save(entity);
    }

    @Override
    public CxCategory findOne(Integer primaryKey) {
        return iCxCategoryRepository.findOne(primaryKey);
    }

    @Override
    public List<CxCategory> findAll() {
        return iCxCategoryRepository.findAll();
    }


    @Override
    public long count() {
        return iCxCategoryRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        iCxCategoryRepository.delete(primaryKey);
    }

    public Page<CxCategory> findAll(CommonSearchVO commonSearchVO) {
        return iCxCategoryRepository.findAll(PageableTools.basicPage(commonSearchVO.getPageParams(),commonSearchVO.getLength()));
    }
}
