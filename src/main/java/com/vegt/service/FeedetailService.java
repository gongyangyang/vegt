package com.vegt.service;

import com.vegt.entity.feedetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedetailService {
    //插入费用明细
    int InsertFeedetail(@Param("list") List<feedetail> list);
}
