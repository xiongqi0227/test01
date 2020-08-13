package com.czxy.domain;

import java.io.Serializable;

/**
 * @author 王先森@itcast.cn
 * @version 1.0
 * @date 2019/4/2
 */
public class Product implements Serializable {
    /**  */
    private String id;
    /** 名称*/
    private String name;
    /** 类型*/
    private String type;
    /** 价格*/
    private String price;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Product(String id, String name, String type, String price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
