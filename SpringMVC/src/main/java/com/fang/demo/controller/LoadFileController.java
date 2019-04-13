package com.fang.demo.controller;


import com.fang.demo.model.FileLoad;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;

/**
 * 实现的是文件上传以及下载的实现,以及文件展示
 */
@Controller
public class LoadFileController {

    private static final Logger logger = Logger.getLogger("test");


    @RequestMapping(value = "/loadFile")
    public String loadFile() {
        return "ImageLoad";
    }

    @RequestMapping(value = "/fileSave")
    public String saveFile(@ModelAttribute FileLoad fileLoad, HttpServletRequest request, RedirectAttributes model, HttpSession session) throws IOException {

        System.out.println("文件信息==" + fileLoad.getName());

        if (fileLoad.getMultipartFile().isEmpty()) {
            return "redirect:/loadFile";
        }
        File saveFile = new File(request.getServletContext().getRealPath("/file"));
        if (!saveFile.exists()) {
            saveFile.createNewFile();
        }
        File file = new File(
                saveFile, fileLoad.getMultipartFile().getOriginalFilename());
        if (!file.exists()) {
            file.createNewFile();
        }
        fileLoad.getMultipartFile().transferTo(file);
        return "redirect:/allFile";
    }


    @RequestMapping(value = "/allFile")
    public String fileList(HttpServletRequest request, RedirectAttributes model, HttpSession session) throws IOException {
        File saveFile = new File(request.getServletContext().getRealPath("/file"));
        session.setAttribute("files", saveFile.listFiles());
        return "fileList";
    }


    @RequestMapping(value = "context_path")
    public void contextPath(HttpServletRequest request) {
        System.out.println("目录=" + request.getServletContext().getRealPath("/"));//   /media/fang/codeAndNote/developeDemo/JAVA/java开发实例大全/MR/SpringMVC/target/SpringMVC/
    }

    @RequestMapping("/fileDown/{fileName}")
    public void fileDown(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) throws
            IOException {
        String parentFile = request.getServletContext().getRealPath("/file");
        fileName = URLDecoder.decode(fileName, "UTF-8");
        System.out.println("文件名称" + fileName);
        response.setContentType("application/octet-stream");

        File file = getFile(parentFile, fileName);

        BufferedInputStream bis = null;
        OutputStream outputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bis = new BufferedInputStream(fileInputStream);
            outputStream = response.getOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = bis.read(bytes, 0, bytes.length)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            bis.close();
        }
    }

    private File getFile(String parentFile, String fileName) {
        for (File file : new File(parentFile).listFiles()) {
            if (file.getName().contains(fileName)) {
                return file;
            }
        }
        return null;
    }


}
