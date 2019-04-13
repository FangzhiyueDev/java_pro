package com.fang.demo.controller;


import com.fang.demo.model.User;
import com.fang.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 这个是 我在学习springmvc的第一个测试controller,里面都是一些基础的知识
 */

@Controller
public class FirstControll {


    /**
     * 返回字符串
     * 逻辑视图名
     * Controller类方法返回字符串可以指定逻辑视图名，通过视图解析器解析为物理视图地址。
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/center", method = RequestMethod.GET)
    public void getData(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.print("调用数据===========================>");
        PrintWriter writer = response.getWriter();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        writer.write("{\"id\":\"123\"}");
    }

    /**
     * 通过逻辑的视图名,返回相应的视图
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public String getData1(HttpServletRequest request, HttpServletResponse response, Model model) {

        return "index";//ok
    }

    /**
     * spring的注解实现的依赖注入的功能
     */
    @Autowired
    private UserServiceImpl userService;


    /**
     * 返回逻辑视图名的视图
     *
     * @param model mode的作用是携带传递视图的参数
     * @return
     */
    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public String getAllUser(Model model) {

        User user = new User("fang", "123");
        model.addAttribute("user", user);
        return "allUser";
    }

    /**
     * 同上面一样
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/allUserData", method = RequestMethod.GET)
    public String getAllUserData(Model model) {
        model.addAttribute("user", userService.getAllUser());
        return "allUser";
    }

    /**
     * @param redirectAttributes 用于定向添加属性的对象,重定向导致mode失效,通过这个对象传递数据
     * @return
     */
    @RequestMapping(value = "/allUserData1", method = RequestMethod.GET)
    public String getAllUserData1(RedirectAttributes redirectAttributes) {
//        model.addAttribute("user", userService.getAllUser());
        redirectAttributes.addFlashAttribute("user", userService.getAllUser());
        return "redirect:/simpleUser";
    }


    /**
     * 使用请求参数
     * 这个post获得的数据，本来是一个对象吧，但是我们可以强制转为String的字符串进行解析
     * <p>
     * <p>
     * 记住，当前的目录是项目/addUser .如果想要访问上一级，就要通过../的形式访问
     * 如果访问当前目录结构下的文件，就通过./的形式
     *
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(RedirectAttributes redirectAttributes, HttpServletRequest request) {
//        redirectAttributes.addAttribute("user", new User(request.getParameter("name"), request.getParameter("password")));
        return "redirect:./index.jsp";

        /**
         * index.jsp位于项目的顶层，与当前访问级别一致，所以使用的是./的形式访问
         */
    }


    /**
     * 使用路径变量h
     * http://localhost:8080/SpringMVC_war/addUser/2?user=fang&password=wwqwewef
     * 使用路径变量的时候必须存在一个参数,这个参数的作用就是那个路径变量,路径变量不限定值的类型,
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/addUser/{id}")
    public String addUser(Model model, @PathVariable int id, @RequestParam String user, @RequestParam String password) {
        model.addAttribute("user", new User(user, password));
        System.out.print("当前view的id=" + id);
        return "simpleUser";
    }


    /**
     * 对于WEB-INF下面的文件，我们不可能直接进行访问，所以只能通过请求转发  ，也就是通过 dispatcher
     * <p>
     * 对于重定向，这个点是实现不了的
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping(value = "/redi", method = RequestMethod.GET)
    public void getAllUserData1(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        model.addAttribute("user", userService.getAllUser());
        request.getRequestDispatcher("./WEB-INF/jsp/simpleUser.jsp").forward(request, response);
    }


    /**
     * http://localhost:8080/SpringMVC_war_exploded/addUserInfo?name=fagaeg&password=fags
     * 会自动的将请求的数据映射成对象
     *
     * @param user
     * @param model
     * @return
     */
    //使用@ModelAttribute
    @RequestMapping(value = "/addUserInfo", method = RequestMethod.GET)
    public String getUser(@ModelAttribute User user, Model model) {
        System.out.println("user=" + user.getName() + "\tpassword=" + user.getPassword());
        model.addAttribute("user", user);
        return "simpleUser";
    }

}
