package com.fang.demo.model;

public class SysDict {

    private Long id;

    private String code;

    private String name;

    private String value;


    public SysDict(Long id, String code, String name, String value) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.value = value;
    }


    public SysDict() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "SysDict{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
