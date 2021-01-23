package icu.sehnen.controller;


import icu.sehnen.pojo.Category;
import icu.sehnen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
public ResponseEntity<List<Category>> queryByCatLevel( @RequestParam(value = "type",defaultValue = "3") int type){

    List<Category> list =null;
    if(CollectionUtils.isEmpty(list)){
        //404 资源服务器未找到
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(list);


}


}
