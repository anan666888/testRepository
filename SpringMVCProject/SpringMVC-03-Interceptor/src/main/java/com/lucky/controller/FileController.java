package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class FileController {

    public String fileUpload(@RequestParam("file")CommonsMultipartFile file,
                             HttpServletRequest request) throws IOException {
        //1、获取文件名
        String filename = file.getOriginalFilename();
        //2、如果文件名为空，直接回到首页
        if ("".equals(filename)) {
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名：" + filename);
        //3、上传路径保存设置
        String path = request.getServletPath();
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址：" + realPath);
        //文件输入流
        InputStream is = file.getInputStream();
        //文件输出流
        OutputStream os = new FileOutputStream(new File(realPath, filename));
        //读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";
    }
}
