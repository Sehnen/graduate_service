package icu.sehnen.service;

import icu.sehnen.mapper.CategoryMapper;
import icu.sehnen.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
//    查询所有分类
public List<Category> getListtoTree(){
    List<Category> categories=categoryMapper.selectAll();
    return categories;
}

}
