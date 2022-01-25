package com.example.deliverysystem.utils;

import com.example.deliverysystem.entity.MyUtils;
import com.example.deliverysystem.repository.CuisineRepository;
import com.example.deliverysystem.repository.UtilsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;

import static com.example.deliverysystem.utils.Token.tokenMap;

/**
 * @Author Lang wenchong
 * @Date 2021/12/26 12:37
 * @Version 1.0
 */

@Component
@RestController
public class refresher {
    @Autowired
    CuisineRepository cuisineRepository;

    @Autowired
    UtilsRepository utilsRepository;

    @Value("${root}")
    private String root;

    @Scheduled(cron = "0 0 5 * * ?")
    @RequestMapping(value = "/langwenchong/refresher")
    public String scheduledRefresher() {
        refresh();
        return "refresh";
    }

    private void refresh() {
        System.out.println("-----refresh------");
        System.out.println(new Date());
        System.out.println("--MyUtils--");
        System.out.println("--tokenMap--");
        MyUtils u = utilsRepository.getMyUtils("Langwenchong");
        u.setCid(5);
        System.out.println("before");
        System.out.println(tokenMap);
        tokenMap.clear();
        System.out.println("After");
        System.out.println(tokenMap);
        utilsRepository.save(u);
        System.out.println("--cuisine--");
        cuisineRepository.deleteNewCuisine();
        System.out.println("--file--");
        File file = new File(root + "/user/");
        if (file.exists()) {
            System.out.println("file exits true");
            System.out.println(file.getName() + "-" + file.getAbsolutePath());
            if (file.isFile()) System.out.println("File");
            else if (file.isDirectory()) System.out.println("directory");
            recursionDeleteFile(file);
            System.out.println("delete files");
        } else {
            System.out.println("file exits false");
        }
        System.out.println("-----------");
    }

    private void recursionDeleteFile(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                if (file.listFiles().length > 0) {
                    for (File tmp : file.listFiles()) {
                        recursionDeleteFile(tmp);
                    }
                    file.delete();
                }
            } else if (file.isFile()) {
                file.delete();
            }
        }
    }

}
