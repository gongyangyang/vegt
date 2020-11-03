package com.vegt.mapper;


import com.vegt.entity.order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository("OrderMapper")
public interface OrderMapper {

    @Select("select username from users")
    Set<String> Selcname();

    @Insert("insert into corder values(#{cid},#{cname},#{ctime},#{ctype},#{comments})")
    Integer inCorder(order order);

}
