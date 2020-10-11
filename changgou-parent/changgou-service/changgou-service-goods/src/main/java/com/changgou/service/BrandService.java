package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: lshsh
 * @Time: 2020/10/11 7:57
 * @Description: com.changgou.service
 */
public interface BrandService {


    /**
     *条件+分页搜索
     * @param page 当前页数
     * @param size 每一页多少条记录
     * @return
     */
    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);


    /**
     *分页搜索
     * @param page 当前页数
     * @param size 每一页多少条记录
     * @return
     */
    PageInfo<Brand> findPage(Integer page,Integer size);

    /**
     * 多条件搜索
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);


    /**
     * 根据品牌id删除品牌
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据id修改品牌
     * @param brand
     */
    void update(Brand brand);



    /**
     * 添加一个品牌
     *
     * @param brand
     */
    void add(Brand brand);


    /**
     * 查询一个
     *
     * @param id
     * @return
     */
    Brand findById(Integer id);


    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> findAll();
}
