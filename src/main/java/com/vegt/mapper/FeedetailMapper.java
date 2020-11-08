package com.vegt.mapper;
import com.vegt.entity.feedetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface FeedetailMapper {
     int InsertFeede(@Param("list") List<feedetail> list);
}
