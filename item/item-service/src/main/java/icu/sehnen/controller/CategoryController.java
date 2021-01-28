package icu.sehnen.controller;


import icu.sehnen.pojo.Category;
import icu.sehnen.service.CategoryService;
import icu.sehnen.myexception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import icu.sehnen.pojo.ExceptionEnum;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("categories")
public ResponseEntity<List<Category>> queryByCatLevel( @RequestParam(value = "type",defaultValue = "3") int type){

    //List<Category> list = categoryService.getListtoTree();
   // if(CollectionUtils.isEmpty(list)){
        //404 资源服务器未找到
      //  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        System.out.println("jinru");
        throw  new MyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
 //   }
   // return ResponseEntity.ok(list);

}


}
