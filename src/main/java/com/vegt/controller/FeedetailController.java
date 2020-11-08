package com.vegt.controller;

import com.vegt.entity.feedetail;
import com.vegt.service.FeedetailService;
import com.vegt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("feedetail")
public class FeedetailController extends BaseController{

    @Autowired
    public FeedetailService feedetailService;

    @RequestMapping("vegtdetail")
    public JsonResult<Void> InsFeede(List<feedetail> list) {
        feedetailService.InsertFeedetail(list);
        return new JsonResult<Void>(SUCCESS);
    }

}
