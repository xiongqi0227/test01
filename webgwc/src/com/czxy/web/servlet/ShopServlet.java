package com.czxy.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.czxy.domain.Product;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王先森@itcast.cn
 * @version 1.0
 * @date 2019/4/2
 */
public class ShopServlet extends BaseServlet {

    /**
     * 删除商品
     * @return
     */
    public String delete(){
        String id ="id"+ getRequest().getParameter("id");
        Cookie[] cookies = getRequest().getCookies();
        for (Cookie c : cookies) {
            if(id.equals(c.getName())){
                c.setMaxAge(0);
                getResponse().addCookie(c);
            }
        }
        return "redirect:/cookie?method=look";
    }

    /**
     * 添加到购物车
     * @return
     */
    public String add(){
        //获取id
        String id ="id"+getRequest().getParameter("id");
        //获取所有的cookie
        Cookie[] cookies = getRequest().getCookies();
        //遍历
        for (Cookie c : cookies) {
            //不是第一次添加
            if(id.equals(c.getName())){
               int value =  Integer.parseInt(c.getValue())+1;
                c.setValue(value+"");
                getResponse().addCookie(c);
                return "forward:/cookie?method=look";
            }
        }
        Cookie cookie = new Cookie(id, "1");
        getResponse().addCookie(cookie);
        return "forward:/cookie?method=look";
    }

    /**
     * 查看所有商品
     * @return
     */
    public String list(){
        //获取数据
        Map<String,Product> productMap = getProductMap();
        //保存request作用域
        getRequest().setAttribute("productMap",productMap);
        //请求转发到jsp页面
        return "forward:/productList.jsp";
    }

    /**
     * 获取所有数据
     * @return
     */
    public String look(){

        //把数据存入request作用域中
        Map<String,Product> productMap = getProductMap();
        getRequest().setAttribute("productMap",productMap);
        return "forward:/cartList.jsp";
    }

    /**
     * 初始化数据
     * @return
     */
    public Map<String, Product> getProductMap() {
        //定义map集合
        Map<String, Product> map = new HashMap<>();
        //保存数据
        map.put("1", new Product("1", "Apple X", "128G", "6"));
        map.put("2", new Product("2", "小米7", "256G", "7"));
        map.put("3", new Product("3", "一加6", "512G", "8"));
        return map;
    }
}
