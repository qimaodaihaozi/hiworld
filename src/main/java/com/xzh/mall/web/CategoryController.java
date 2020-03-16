package com.xzh.mall.web;

import com.xzh.mall.service.CategoryService;
import com.xzh.mall.pojo.Category;
import com.xzh.mall.util.ImageUtil;
import com.xzh.mall.util.Page4Navigator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController  //表示这是一个控制器，并且对每个方法的返回值都会直接转换为 json 数据格式
public class CategoryController {
    @Autowired CategoryService categoryService;

    @GetMapping("/categories") //对于categories 访问，会获取所有的 Category对象集合
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Category> page =categoryService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
        categoryService.add(bean);//通过CategoryService 保存到数据库
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }
    public void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/category"));//接受上传图片，并保存到 img/category目录下
        File file = new File(imageFolder,bean.getId()+".jpg");//文件名使用新增分类的id
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);//image.transferTo 进行文件复制
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);//调用ImageUtil的change2jpg 进行文件类型强制转换为 jpg格式
    }
    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        categoryService.delete(id);
        File  imageFolder= new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }
    @GetMapping("/categories/{id}")//提供 get 方法，把id对应的Category取出来，并转换为json对象发给浏览器
    public Category get(@PathVariable("id") int id) throws Exception {
        Category bean=categoryService.get(id);
        return bean;
    }
    @PutMapping("/categories/{id}")
    public Object update(Category bean, MultipartFile image,HttpServletRequest request) throws Exception
    {
        String name = request.getParameter("name");
        bean.setName(name);
        categoryService.update(bean);

        if(image!=null) {
            saveOrUpdateImageFile(bean, image, request);
        }
        return bean;
    }
}


