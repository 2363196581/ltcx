package com.connxun.app.controller;

import com.connxun.app.common.AppBaseController;
import com.connxun.app.common.JsonEntity;
import com.connxun.app.entity.CxCategorySub;
import com.connxun.app.service.CxCategorySubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author anna
 * @Date 2017-12-05 13:56
 * @Description
 */
@RestController
@RequestMapping(value = "api/categorySub")
@Api(tags = {"CategorySub"},value = "CxCategorySubController",description = "菜单二级服务分类信息")
public class CxCategorySubController extends AppBaseController {

    private static Logger logger = LoggerFactory.getLogger("controllerLog");

    @Autowired
    private CxCategorySubService cxCategorySubService;


    /**
     * 获取全部二级服务分类
     * @return
     */
    @ApiOperation(value = "获取全部二级服务分类", notes = "获取全部二级服务分类")
    @PostMapping("categorySubAll")
    public JsonEntity getList() {

        List<CxCategorySub> cxCategories = cxCategorySubService.findAll();
        int size = cxCategories.size();
        if (size > 0) {
            json = listToJson(cxCategories);
            json.setExt(size + "");
        } else {
            json = objectToJson(new ArrayList<>());
        }
        return json;
    }
}
