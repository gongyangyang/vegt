package com.vegt.entity.mapper;

import com.vegt.entity.feedetail;
import com.vegt.mapper.FeedetailMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
public class FeedetailMapperTest {

        @Autowired
        FeedetailMapper feedetailMapper;

        @Test
        public void Inderfeed(){
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String vtime = sf.format(date);
            feedetail fd = new feedetail();
            feedetail fd1 = new feedetail();
            fd.setFid("2020110721113713016");
            fd.setCid("20201108003510860");
            fd.setCname("龚阳");
            fd.setCtype("日常买菜");
            fd.setComments("龚阳买菜");
            fd.setFtime(vtime);
            fd.setBname("大白菜");
            fd.setPrice(2.5);
            fd.setNumber(3);
            fd.setSum(7.5);

           fd1.setFid("2020110721113713015");
            fd1.setCid("20201108003510860");
            fd1.setCname("龚阳");
            fd1.setCtype("日常买菜");
            fd1.setComments("龚阳买菜");
            fd1.setFtime(vtime);
            fd1.setBname("生姜");
            fd1.setPrice(2.5);
            fd1.setNumber(3);
            fd1.setSum(7.5);
            List<feedetail> list = new ArrayList<>();
            list.add(fd);
            list.add(fd1);
            feedetailMapper.InsertFeede(list);
        }
}
