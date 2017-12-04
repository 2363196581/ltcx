package com.connxun.app.controller;

import com.connxun.app.common.AppBaseController;
import com.connxun.app.common.CodeEnum;
import com.connxun.app.common.JsonEntity;
import com.connxun.app.entity.CxCategory;
import com.connxun.app.service.CxCategoryService;
import com.connxun.util.string.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author anna
 * @Date 2017-11-16 18:13
 * @Description
 */
@Controller
@RequestMapping(value = "api/category")
@Api(tags = {"Category"},value = "CxCategoryController",description = "菜单服务分类信息")
public class CxCategoryController extends AppBaseController {

    private static Logger logger = LoggerFactory.getLogger("controllerLog");

    @Autowired
    private CxCategoryService cxCategoryService;


    /**
     * 获取全部服务分类
     * @return
     */
    @ApiOperation(value = "获取全部服务分类", notes = "获取全部服务分类")
    @PostMapping("categoryAll")
    @ResponseBody
    public JsonEntity getList() {

        //分页查询
//        CommonSearchVO searchVO =new CommonSearchVO();
//        searchVO.setLength(3);
//        BasePage page =new BasePage(cxCategoryService.findAll(searchVO));
//        json=objectToJson(page);

        List<CxCategory> cxCategories = cxCategoryService.findAll();
        int size = cxCategories.size();
        if (size > 0) {
//            List<LwVoucherDTO> lwVoucherDTOS = new ArrayList<LwVoucherDTO>();

            json = listToJson(cxCategories);
            json.setExt(size + "");
        } else {
            json = objectToJson(new ArrayList<>());
        }
        return json;
    }

    /**
     * 获取一级服务下对应的二级服务
     * @param categoryId
     * @return
     */
    @ApiOperation(value = "获取一级服务下对应的二级服务", notes = "获取一级服务下对应的二级服务")
    @PostMapping("categorySub")
    @ResponseBody
    public JsonEntity findOne(@ApiParam(required = true, name = "categoryId", value = "一级服务id")
                                  @RequestParam(value = "categoryId", required = true) String categoryId) {

        if(StringUtil.isNotNullOrEmpty(categoryId)){
            CxCategory cxCategory = cxCategoryService.findOne(Integer.valueOf(categoryId));
            if (cxCategory !=null) {
                json = listToJson(cxCategory.getCxCategorySubs());
            } else {
                json = ErrorCode(CodeEnum.FAIL);
            }
        }else{
            json = ErrorCode(CodeEnum.PARAMFAIL);
        }

        return json;
    }
}
