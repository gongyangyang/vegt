package com.vegt.service;
import com.vegt.entity.vegt;
import com.vegt.service.exception.InsertException;
import com.vegt.service.exception.VegtDuplicateException;
import com.vegt.service.exception.VegtNotFoundException;
import com.vegt.util.PageBean;

import java.util.ArrayList;

public interface VegtService {
    //插入蔬菜
    void InVegt(vegt vegt) throws VegtDuplicateException, InsertException;

    ArrayList<vegt> SelMl (String vname,String bname) throws VegtNotFoundException;

    PageBean Fenye(Integer currentpage) throws VegtNotFoundException;
}
