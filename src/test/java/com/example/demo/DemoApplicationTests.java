package com.example.demo;

import com.example.demo.Service.RedisService;
import com.example.demo.utils.FastDFSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private RedisService redisService;

    @Test
    public void contextLoads() {

        redisService.set("hhhhh", "aaaa");
    }

    @Test
    public void test() throws Exception {

        String filePath = "pictures/02.jpg";
        //接收上传的文件
        File file = new File(filePath);
        //取扩展名
        String originalFilename = file.getName();
        //System.out.println("文件名：" + originalFilename);

        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //上传到图片服务器
        FastDFSClient fastDFSClient = new FastDFSClient("client.conf");
        String url = fastDFSClient.uploadFile(filePath, extName);
        System.out.println("url = " + url);

    }


}
