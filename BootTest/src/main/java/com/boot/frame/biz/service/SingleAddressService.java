package com.boot.frame.biz.service;



import com.boot.frame.biz.dao.AddressMapper;
import com.boot.frame.biz.entity.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 2018-04-24.
 */
@com.alibaba.dubbo.config.annotation.Service
public class SingleAddressService implements ISingleAddressService{

    @Autowired
    AddressMapper addressMapper;


    @Override
    public String getById(AddressRequest addressRequest) {
        return addressMapper.find(addressRequest);
    }
}
