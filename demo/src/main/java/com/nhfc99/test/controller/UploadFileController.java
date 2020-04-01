package com.nhfc99.test.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test/uploadfile")
public class UploadFileController {
    @Value("${web.upload-path}")
    private String filePath;

    @PostMapping("/upload")
    public ModelAndView upload(MultipartFile[] file) throws Exception {
        // 遍历文件数组执行上传
        for (int i = 0; i < file.length; i++) {
            if (file[i] != null) {
                // 调用上传方法
                executeUpload(filePath, file[i]);
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("result", true);
        return modelAndView;
    }

    private void executeUpload(String uploadDir, MultipartFile file) throws Exception {
        // 文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 上传文件名
        String filename = UUID.randomUUID() + suffix;
        // 服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        // 将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

    @GetMapping("/test")
    public String tt() {
        return "test";
    }
}
