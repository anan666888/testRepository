package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FileController {
    @RequestMapping("/upload")
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
        String path = request.getSession().getServletContext().getRealPath("/upload");

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

    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request) throws IOException {
        //1、上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //2、上传文件地址
        System.out.println("上传文件保存地址：" + realPath);
        //3、通过CommonsMultipartFile的方法直接写文件
        file.transferTo(new File(realPath+"/"+file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")
    public String downloadFile(HttpServletResponse response,HttpServletRequest request) throws Exception {
        //1、要下载的图片所在的地址
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String fileName = "1.png";
        //2、设置response响应头
        response.reset();//设置页面不缓存，清空buffer
        response.setCharacterEncoding("utf-8");//字符编码
        response.setContentType("multipart/form-data");//二进制传输数据
        //3、设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));
        File file = new File(path, fileName);
        //4、读取文件--输入流
        InputStream is = new FileInputStream(file);
        //5、写出文件--输出流
        OutputStream os = response.getOutputStream();
        byte[] buff = new byte[1024];
        int index = 0;
        //6、执行写出操作
        while ((index=is.read(buff))!=-1) {
            os.write(buff,0,index);
            os.flush();
        }
        os.close();
        is.close();
        return null;
    }
}

