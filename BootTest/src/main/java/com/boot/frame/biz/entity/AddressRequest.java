package com.boot.frame.biz.entity;

import java.io.Serializable;

/**
 * Created by admin on 2018-04-24.
 */
public class AddressRequest implements Serializable{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
