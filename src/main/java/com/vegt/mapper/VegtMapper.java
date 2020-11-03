package com.vegt.mapper;
import java.util.ArrayList;
import com.vegt.entity.vegt;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface VegtMapper {
    //插入蔬菜
    Integer Addvegt(vegt vegt);

    //查询插入的蔬菜ID是否存在
    vegt Selvegt(String vid);

    ArrayList<vegt> queryvegt(String vname,String bname);

    Integer countvegt();

    List<vegt> fenye(Integer pagenum1,Integer pagenum2);
}
