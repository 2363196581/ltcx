package com.connxun.app.controller;

import com.connxun.app.common.AppBaseController;
import com.connxun.app.common.JsonEntity;
import com.connxun.app.entity.CxCard;
import com.connxun.app.searchVO.CommonSearchVO;
import com.connxun.app.service.CxCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author anna
 * @Date 2017-12-04 19:57
 * @Description 名片相关
 */
@RestController
@RequestMapping(value = "api/card")
@Api(tags = {"Card"},value = "CxCardController",description = "名片相关")
public class CxCardController extends AppBaseController {

    private static Logger logger = LoggerFactory.getLogger("controllerLog");

    @Autowired
    private CxCardService cxCardService;

    /**
     * 获取全部名片
     * @return
     */
    @ApiOperation(value = "获取全部名片", notes = "获取全部名片")
    @PostMapping(value = "cardAll")
    public JsonEntity getCardAll() {
        List<CxCard> cxCategories = cxCardService.findAll();
        int size = cxCategories.size();
        if (size > 0) {
            json = listToJson(cxCategories);
            json.setExt(size + "");
        } else {
            json = objectToJson(new ArrayList<>());
        }
        return json;
    }

    /**
     * 根据推荐值获取全部名片
     * @return
     */
    @ApiOperation(value = "根据推荐值获取全部名片", notes = "根据推荐值获取全部名片")
    @PostMapping(value = "getCardAllOrderRecommendValue")
    public JsonEntity getCardAllOrderRecommendValue(CommonSearchVO commonSearchVO) {
        Page<CxCard> page = cxCardService.findAll(commonSearchVO);

        if (page.getTotalElements() > 0) {
            json=listToJson(page.getContent());
        } else {
            json = objectToJson(new ArrayList<>());
        }
        return json;
    }

    /**
     * 名片发布
     * @param card 名片json对象
     * @return
     */
    @ApiOperation(value = "名片发布", notes = "名片发布")
    @PostMapping(value = "publishCard",consumes = MediaType.APPLICATION_JSON_VALUE)
    public JsonEntity publishCard(@ApiParam(required = true, name = "card", value = "名片json对象")
                                      @RequestBody CxCard card) {

        CxCard pulishCard = cxCardService.save(card);
        if (pulishCard !=null) {
            json=objectToJson(pulishCard);
        } else {
            json=booleanToJson(false);
        }
        return json;
    }

    /**
     * 根据名片ID获取名片
     * @param cardId cardId
     * @return
     */
    @ApiOperation(value = "根据名片ID获取名片", notes = "根据名片ID获取名片")
    @PostMapping(value = "getCardByCardId")
    public JsonEntity getCardByCardId(@ApiParam(required = true, name = "cardId", value = "名片id")
                                  @RequestParam(value = "cardId", required = true) String cardId) {

        CxCard pulishCard = cxCardService.findCxCardByCardid(cardId);
        if (pulishCard !=null) {
            json=objectToJson(pulishCard);
        } else {
            json=booleanToJson(false);
        }
        return json;
    }


}
