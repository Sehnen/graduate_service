package icu.sehnen.service;

import icu.sehnen.mapper.CategoryMapper;
import icu.sehnen.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
//    查询所有分类
public List<Category> getListtoTree(){

    List<Category> categories=categoryMapper.selectAll();
        List<Category> firstLevelMenu = categories.stream().filter(category -> category.getCatPid()==0).
                map(menu->{menu.setChildren(getChildrens(categories,menu));
                 return menu;}).collect(Collectors.toList());

         return  getTreeData(firstLevelMenu);
    }

    private List<Category>  getChildrens(List<Category> all, Category root) {
        List<Category> children = all.stream()
                .filter(category -> category.getCatPid() == root.getCatId())
                .map(categoryEntity -> {
                    //递归设置子菜单
                        categoryEntity.setChildren(getChildrens(all, categoryEntity));
                        return categoryEntity;

                })
                .collect(Collectors.toList());
        return children;
    }
//    过滤children为空的数据
    public List<Category> getTreeData(List<Category> categories){

        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getChildren().size()<1){
                categories.get(i).setChildren(null);
            }else {
                getTreeData(categories.get(i).getChildren());
            }
        }
        return categories;
    }


}

