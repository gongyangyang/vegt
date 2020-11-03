package com.vegt.controller;
import com.vegt.entity.vegt;
import com.vegt.service.VegtService;
import com.vegt.util.JsonResult;
import com.vegt.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@ResponseBody
@RequestMapping("vegt")
public class VegtController extends BaseController{
    @Autowired(required = false)
    private VegtService vegtService;

    @RequestMapping("add")
    public JsonResult<vegt> Addvegt( vegt vegt){
        vegtService.InVegt(vegt);
        return new JsonResult<>(SUCCESS);
    }

    @RequestMapping("vegtlist")
    public JsonResult<ArrayList<vegt>> Addvegt(String vname, String bname){
        ArrayList<vegt> vt = new ArrayList<vegt>();
       vt = vegtService.SelMl(vname,bname);
        System.out.println("vvvv:"+vt);
        return new JsonResult<ArrayList<vegt>>(SUCCESS,vt);

    }

    @RequestMapping("vegtbm")
    public JsonResult<ArrayList<vegt>> findvegt(String bname){
        System.out.println("bname:"+bname);
        String vname = "";
        ArrayList<vegt> vt = new ArrayList<vegt>();
        vt = vegtService.SelMl(vname,bname);
        System.out.println("vvvv:"+vt);
        return new JsonResult<ArrayList<vegt>>(SUCCESS,vt);

    }



    @RequestMapping("feny")
    public JsonResult<PageBean<ArrayList<vegt>>> Feny(Integer currentpage){
       PageBean<ArrayList<vegt>> vg= vegtService.Fenye(currentpage);
        return new JsonResult<PageBean<ArrayList<vegt>>>(SUCCESS, vg);
    }

}
