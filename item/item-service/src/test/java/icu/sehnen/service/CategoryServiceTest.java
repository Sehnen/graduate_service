package icu.sehnen.service;


import icu.sehnen.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemService.class)
public class CategoryServiceTest {
@Autowired
CategoryService categoryService;
@Test
    public void getListtoTree() {
        System.out.println(categoryService.getListtoTree());

    }
}