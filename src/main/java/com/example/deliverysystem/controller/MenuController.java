package com.example.deliverysystem.controller;

import com.example.deliverysystem.entity.Cuisine;
import com.example.deliverysystem.entity.MyUtils;
import com.example.deliverysystem.entity.User;
import com.example.deliverysystem.repository.CuisineRepository;
import com.example.deliverysystem.repository.UserRepository;
import com.example.deliverysystem.repository.UtilsRepository;
import com.example.deliverysystem.utils.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.example.deliverysystem.utils.Token.tokenMap;

/**
 * @Author Lang wenchong
 * @Date 2021/12/25 16:42
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/api/menu")
public class MenuController {
    //    获取这三个查询对象实例
    @Autowired
    CuisineRepository cuisineRepository;

    @Autowired
    UtilsRepository utilsRepository;

    @Autowired
    UserRepository userRepository;

    @Value("${root}")
    private String root;

    @RequestMapping("/get")
    private MyJson getAllCuisine(HttpServletRequest request) {
        MyJson myJson = new MyJson();
        String token = request.getHeader("token");
        if (!tokenMap.containsKey(token)) {
            myJson.setStatus(403);
            myJson.setMessage("Please login first");
            return myJson;
        }
        List<Cuisine> list = cuisineRepository.findAll();
        myJson.setResult(list);
        myJson.setMessage("Menu");
        return myJson;
    }

    @RequestMapping("/add")
    private MyJson addCuisine(HttpServletRequest request,
                              @RequestParam("name") String name,
                              @RequestParam("descr") String descr,
                              @RequestParam("price") int price,
                              @RequestParam("image") MultipartFile image) {
        MyJson myJson = new MyJson();
        String token = request.getHeader("token");
        if (!tokenMap.containsKey(token)) {
            myJson.setStatus(403);
            myJson.setMessage("Please login first");
            return myJson;
        }
        User user = userRepository.findUserByUsername(tokenMap.get(token));
        MyUtils u = utilsRepository.getMyUtils("Langwenchong");
        String imgPath = "/user/" + user.getUsername() + "/" + u.getCid() + ".jpg";
        Cuisine c = new Cuisine(u.getCid(), name, descr, price, imgPath);
        cuisineRepository.save(c);
        u.setCid(u.getCid() + 1);
        utilsRepository.save(u);
        File dest = new File(new File(root + imgPath).getAbsolutePath());
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            image.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            myJson.setResult(500);
            myJson.setMessage("Unexpected Error!");
            return myJson;
        }
        myJson.setStatus(200);
        myJson.setResult(c);
        myJson.setMessage("success");
        return myJson;
    }

}
