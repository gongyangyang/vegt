package com.vegt.entity.service;
import com.vegt.entity.vegt;
import com.vegt.service.VegtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class VegServiceTest {

    @Autowired(required=false)
    private VegtService vs;

    @Test
    public void add( vegt vegt){
        vegt.setVname("黄瓜");
        vegt.setVprice(8.0);
        vegt.setAddress("贵州黔西");
        vegt.setBname("hg");
        vs.InVegt(vegt);
    }


}
