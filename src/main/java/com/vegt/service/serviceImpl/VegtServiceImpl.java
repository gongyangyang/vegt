package com.vegt.service.serviceImpl;
import com.vegt.entity.vegt;
import com.vegt.mapper.VegtMapper;
import com.vegt.service.VegtService;
import com.vegt.service.exception.InsertException;
import com.vegt.service.exception.VegtDuplicateException;
import com.vegt.service.exception.VegtNotFoundException;
import com.vegt.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class VegtServiceImpl implements VegtService {
    @Autowired(required=false)
    private VegtMapper vegtMapper;
    @Override
    public void InVegt(vegt vegt) throws VegtDuplicateException, InsertException {
        String num = "0000";
        int index = vegt.getVprice().toString().indexOf(".");
        vegt.setVid(vegt.getBname()+num+vegt.getVprice().toString().substring(0,index));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vegt.setVtime(sf.format(new Date()));
        vegt vt = new vegt();
        vt = vegtMapper.Selvegt(vegt.getVid());
        if(vt==null){
            vegtMapper.Addvegt(vegt);
        }else if(vt!=null) {
            throw new VegtDuplicateException("该价格蔬菜已存在");
        }else if(vegt.getVname()==null){
            throw new InsertException("插入蔬菜异常,蔬菜名为空");
        }else{
            throw new InsertException("插入蔬菜异常");
        }
    }

    @Override
    public ArrayList<vegt> SelMl(String vname, String bname) throws VegtNotFoundException {
        ArrayList<vegt> vlist = vegtMapper.queryvegt(vname,bname);
        if(vlist==null || vlist.size()==0){
            throw new VegtNotFoundException("该菜品不存在");
        }
        return vlist;
    }

    @Override
    public PageBean<List> Fenye(Integer currentpage) throws VegtNotFoundException {
        //统计出总行数
        Integer totalnum = vegtMapper.countvegt();
        PageBean<List> pb = new PageBean<>();
        Integer pagenum1 = 0;
        Integer pagenum2 = 0;
        //实例化分页类
        pb.setTotalCount(totalnum);  //总行数
        pb.setTotalPage(pb.getTotalCount()/pb.getPageCount()); //总页数
        System.out.println("currentpage:"+currentpage);
        if(currentpage>pb.getTotalPage()){
            currentpage=pb.getTotalPage();
        }
        if(currentpage<1){
            currentpage=1;
            pb.setCurrentPage(1);
        }
            pagenum1 = 1+(currentpage-1)*10;
            pagenum2 = currentpage * pb.getPageCount();
            pb.setCurrentPage(currentpage);
        System.out.println(pagenum1+"/t"+pagenum2);
        //实例化显示的数据
        List<vegt> list = vegtMapper.fenye(pagenum1,pagenum2);
        pb.setPageData(list);
        return pb;
    }
}
