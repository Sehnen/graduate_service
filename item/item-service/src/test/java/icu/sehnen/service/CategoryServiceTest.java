package icu.sehnen.service;


import icu.sehnen.ItemService;
import icu.sehnen.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemService.class)
public class CategoryServiceTest {
@Autowired
CategoryService categoryService;
@Test
    public void getListtoTree() {
    List<Category> categories= categoryService.getListtoTree();
    List<Category> firstLevelMenu = categories.stream().filter(category -> category.getCatPid()==0).
            map(menu->{menu.setChildren(getChildrens(categories,menu));
            return menu;}).collect(Collectors.toList());
    System.out.println(firstLevelMenu);
//    System.out.println(getTreeData(firstLevelMenu));
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