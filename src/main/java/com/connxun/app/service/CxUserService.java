package com.connxun.app.service;

import com.connxun.app.common.BaseService;
import com.connxun.app.common.PageableTools;
import com.connxun.app.entity.CxUser;
import com.connxun.app.repositories.ICxUserRepository;
import com.connxun.app.searchVO.CommonSearchVO;
import com.connxun.app.searchVO.CxUserSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author anna
 * @Date 2017-11-11 14:30
 * @Description
 */
@Service
public class CxUserService implements BaseService<CxUser, Integer> {

    @Autowired
    private ICxUserRepository iCxUserRepository;

    @Override
    public <S extends CxUser> S save(S entity) {
        return iCxUserRepository.save(entity);
    }

    @Override
    public CxUser findOne(Integer primaryKey) {
        return iCxUserRepository.findOne(primaryKey);
    }

    //IterableUtils.toList(
    @Override
    public List<CxUser> findAll() {
        return iCxUserRepository.findAll();
    }

    @Override
    public long count() {
        return iCxUserRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        iCxUserRepository.delete(primaryKey);
    }

    /**
     * 分页查询list
     * @param commonSearchVO 基础查询VO
     * @return
     */
    public Page<CxUser> findAll(CommonSearchVO commonSearchVO) {
        return iCxUserRepository.findAll(PageableTools.basicPage(commonSearchVO.getPageParams(),commonSearchVO.getLength()));
    }

    public CxUser findCxUserByPhone(String phone){
        return iCxUserRepository.findCxUserByPhone(phone);
    }

    public CxUser findCxUserByUserid(String userId){
        return iCxUserRepository.findCxUserByUserid(userId);
    }

    public CxUser findCxUserByQqidWOrWxidOrSinaid(String qqid,String wxid, String sinaid){
        return iCxUserRepository.findCxUserByqqidOrWxidOrSinaid( qqid, wxid, sinaid);
    }

    public Page<CxUser> getList(CxUserSearchVO cxUserSearchVO){


        /*findAll 分页加多条件查询*/
//        return iCxUserRepository.findAll(SearchTools.buildSpecification(
//                SearchTools.buildSpeDto("and", new SearchDto("phone", "like", cxUserSearchVO.getPhone()))
//        ),PageableTools.basicPage(cxUserSearchVO.getPageParams(),cxUserSearchVO.getLength()));

//        return iCxUserRepository.findAll(SearchTools.buildSpecification(
//                SearchTools.buildSpeDto("and", new SearchDto("and", "id", "gt", 2)),
//                SearchTools.buildSpeDto("and", new SearchDto("phone", "like", cxUserSearchVO.getPhone()),
//                        new SearchDto("or", "userName", "ne", "user9"))
//                ),PageableTools.basicPage(cxUserSearchVO.getPageParams(),cxUserSearchVO.getLength()));

        /*自定义查询语句 分页加多条件查询*/
        return iCxUserRepository.getList(cxUserSearchVO.getPhone(), PageableTools.basicPage(cxUserSearchVO.getPageParams(),cxUserSearchVO.getLength()));
    }




}
