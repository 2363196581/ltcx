package com.connxun.app.controller;

import com.connxun.app.common.AppBaseController;
import com.connxun.app.common.JsonEntity;
import com.connxun.app.entity.CxStore;
import com.connxun.app.service.CxStoreService;
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
 * @Date 2017-12-05 16:47
 * @Description 店铺
 */
@RestController
@RequestMapping(value = "api/store")
@Api(tags = {"Store"},value = "CxStoreController",description = "店铺相关")
public class CxStoreController extends AppBaseController{

    private static Logger logger = LoggerFactory.getLogger("controllerLog");

    @Autowired
    private CxStoreService cxStoreService;

    /**
     * 获取全部名片
     * @return
     */
    @ApiOperation(value = "获取全部店铺", notes = "获取全部店铺")
    @PostMapping(value = "cardAll")
    public JsonEntity getCardAll() {
        List<CxStore> cxCategories = cxStoreService.findAll();
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
