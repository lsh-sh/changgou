package com.changgou.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: lshsh
 * @Time: 2020/10/11 7:58
 * @Description: com.changgou.controller
 */

@RestController
@RequestMapping("/brand")
@CrossOrigin //解决跨域问题
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findAll() {
        int a = 23 / 0;
        List<Brand> brands = brandService.findAll();
        return new Result<>(brands);

    }

    @GetMapping(value = "{id}")
    public Result<Brand> findById(@PathVariable(value = "id") Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<>(brand);
    }


    @PostMapping
    public Result addBrand(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result();
    }

    @PutMapping(value = "{id}")
    public Result updateBrand(@PathVariable(value = "id") Integer id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.update(brand);
        return new Result();
    }

    @DeleteMapping("/{id}")
    public Result deleteBrand(@PathVariable(value = "id") Integer id) {
        brandService.delete(id);
        return new Result();
    }

    @PostMapping("/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand) {
        List<Brand> brands = brandService.findList(brand);
        return new Result<>(brands);
    }

    @GetMapping("search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page") Integer page, @PathVariable(value = "size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<>(pageInfo);
    }

    @PostMapping("search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand, @PathVariable(value = "page") Integer page, @PathVariable(value = "size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result<>(pageInfo);
    }
}
