package com.changgou.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;

/**
 * @Author: lshsh
 * @Time: 2020/10/11 7:57
 * @Description: com.changgou.service
 */
public interface BrandService {

    /**
     * 查询所有品牌
     * @return
     */
    List<Brand> findAll();
}
