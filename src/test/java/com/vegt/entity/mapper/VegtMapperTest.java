package com.vegt.entity.mapper;
import com.vegt.entity.vegt;
import com.vegt.mapper.VegtMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class VegtMapperTest {

    @Autowired
    VegtMapper vegtMapper;
    @Test
    public void addv(){
        vegt v = new vegt();
        v.setAddress("贵州省黔西县");
        v.setBname("hg");
        v.setVprice(3.00);
        int index = v.getVprice().toString().indexOf(".");
        v.setVid(v.getBname()+"0000"+v.getVprice().toString().substring(0,index));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        v.setVtime(df.format(new Date()));
        v.setVname("黄瓜");
        vegtMapper.Addvegt(v);
    }


    @Test
    public void SelVeg(){
        String vid="hg0001";
        vegt v = vegtMapper.Selvegt(vid);
        System.out.println(v);
    }

    @Test
    public void query(){
        String v = "白";
        String b =  "x";
        ArrayList<vegt> list = vegtMapper.queryvegt(v,b);
        System.out.println(list);
    }

    @Test
    public void countV(){
        Integer count = vegtMapper.countvegt();
        System.out.println(count);
    }

    @Test
    public void fenye(){
        Integer pagenum1 = 11;
        Integer pagenum2 = 20;
        List<vegt> list = vegtMapper.fenye(pagenum1,pagenum2);
        System.out.println(list);

    }

}
