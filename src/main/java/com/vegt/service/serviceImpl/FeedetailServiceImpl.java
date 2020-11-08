package com.vegt.service.serviceImpl;

import com.vegt.entity.feedetail;
import com.vegt.mapper.FeedetailMapper;
import com.vegt.service.FeedetailService;
import com.vegt.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedetailServiceImpl implements FeedetailService {
    @Autowired
    FeedetailMapper feedetailMapper;
    @Override
    public int InsertFeedetail(List<feedetail> list) {
        int feedenumber=0;
        if(list==null || list .equals("")){
            throw new InsertException("费用明细不能我空");
        }else{
            feedenumber = feedetailMapper.InsertFeede(list);
        }
        return feedenumber;
    }
}
