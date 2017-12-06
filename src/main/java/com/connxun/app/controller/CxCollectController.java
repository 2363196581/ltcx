package com.connxun.app.controller;

import com.connxun.app.common.AppBaseController;
import com.connxun.app.common.JsonEntity;
import com.connxun.app.entity.CxCollect;
import com.connxun.app.service.CxCollectService;
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
 * @Date 2017-12-04 21:33
 * @Description 热门收藏
 */
@RestController
@RequestMapping(value = "api/collect")
@Api(tags = {"Collect"},value = "CxCollectController",description = "收藏")
public class CxCollectController  extends AppBaseController {

    private static Logger logger = LoggerFactory.getLogger("controllerLog");

    @Autowired
    private CxCollectService cxCollectService;

    /**
     * 获取全部收藏
     * @return
     */
    @ApiOperation(value = "获取全部收藏", notes = "获取全部收藏")
    @PostMapping(value = "cardAll")
    public JsonEntity getCardAll() {
        List<CxCollect> cxCategories = cxCollectService.findAll();
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
