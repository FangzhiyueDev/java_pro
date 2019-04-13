package com.fang.demo.model;

import org.springframework.web.multipart.MultipartFile;

public class FileLoad {


    private String name;

    private MultipartFile multipartFile;


    public FileLoad(String name, MultipartFile multipartFile) {
        this.name = name;
        this.multipartFile = multipartFile;
    }

    @Override
    public String toString() {
        return "FileLoad{" +
                "name='" + name + '\'' +
                ", multipartFile=" + multipartFile +
                '}';
    }

    public FileLoad() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
