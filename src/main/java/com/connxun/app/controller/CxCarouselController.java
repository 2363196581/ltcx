package com.connxun.app.controller;

import com.connxun.app.common.AppBaseController;
import com.connxun.app.common.JsonEntity;
import com.connxun.app.entity.CxCarousel;
import com.connxun.app.service.CxCarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author anna
 * @Date 2017-12-01 15:49
 * @Description 轮播图
 */
@Controller
@RequestMapping(value = "api/banner")
@Api(tags = {"Banner"},description = "Banner信息", value = "Banner信息")
public class CxCarouselController extends AppBaseController {


    private static Logger logger = LoggerFactory.getLogger("controllerLog");

    @Autowired
    private CxCarouselService cxCarouselService;


    /**
     * 获取全部BANNER信息
     * @return
     */
    @ApiOperation(value = "获取全部Banner信息", notes = "获取全部Banner信息")
    @PostMapping(value = "bannerAll")
    @ResponseBody
    public JsonEntity getList() {
        List<CxCarousel> cxCategories = cxCarouselService.findAll();
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
