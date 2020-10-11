package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @Author: lshsh
 * @Time: 2020/10/11 7:57
 * @Description: com.changgou.service.impl
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;


    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {

        PageHelper.startPage(page, size);
        Example example = createExample(brand);
        List<Brand> brands = brandMapper.selectByExample(example);
        return new PageInfo<>(brands);
    }

    /**
     * 分页列表查询
     *
     * @param page 当前页数
     * @param size 每一页多少条记录
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {

        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectAll();
        return new PageInfo<>(brands);
    }

    /**
     * 多条件搜索
     *
     * @param brand
     * @return
     */
    @Override
    public List<Brand> findList(Brand brand) {
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }


    /**
     * 创建条件构造器
     *
     * @param brand
     * @return
     */
    private Example createExample(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria(); //条件构造器

        if (brand != null) {
            //跟名称模糊匹配搜索
            if (StringUtil.isNotEmpty(brand.getName())) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }
            //根据品牌首字母搜索
            if (StringUtil.isNotEmpty(brand.getLetter())) {
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }

    /**
     * 根据品牌id删除记录
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }


    /**
     * 更新品牌数据
     *
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 添加新的品牌
     *
     * @param brand
     */
    @Override
    public void add(Brand brand) {

        /**
         * insertSelective 会做空值判断在进行插入
         * insert 不会做空值判断
         */
        brandMapper.insertSelective(brand);
    }

    /**
     * 根据id查询品牌
     *
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
