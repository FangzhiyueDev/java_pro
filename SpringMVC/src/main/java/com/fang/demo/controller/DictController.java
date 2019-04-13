package com.fang.demo.controller;


import com.fang.demo.model.SysDict;
import com.fang.demo.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * 字典的管理实现demo  这个例子比较综合,建议阅读
 * 下面是文件的介绍
 * #{{@link BookController}}  springmvc的映射的controller
 * #{{@link SysDict}}  mode,模型类
 * #{{@link DictService}}   操作数据库的接口
 * #{{@link com.fang.demo.service.impl.DictServiceImpl}} 上面接口的实现
 * #{{@link com.fang.demo.dao.DictDao}}和#{BookMapper.xml}进行映射
 *
 */

@Controller
public class DictController {

    /**
     * 使用spring依赖注入
     */
    @Autowired
    private DictService dictService;

    @RequestMapping(value = "/dicts")
    public ModelAndView dicts(SysDict sysDict, Integer offset, Integer limit) {
        ModelAndView mv = new ModelAndView("dicts");
        List<SysDict> dicts = dictService.findBySysDict(sysDict, offset, limit);
        mv.addObject("dicts", dicts);
        return mv;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(Long id) {
        ModelAndView mv = new ModelAndView("dict_add");
        SysDict sysDict;
        if (id == null) {
            sysDict = new SysDict();
        } else {
            sysDict = dictService.findById(id);
        }
        mv.addObject("model", sysDict);
        return mv;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute SysDict sysDict) {
        ModelAndView mv = new ModelAndView();
        System.out.println("sysDict=" + sysDict.toString());
        try {
            dictService.saveOrUpdate(sysDict);
            mv.setViewName("redirect:/dicts");
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("dict_add");
            mv.addObject("msg", e.getMessage());
            mv.addObject("model", sysDict);
        }
        return mv;
    }


    /**
     * 　@responseBody注解的作用是将controller的方法返回
     * 的对象通过适当的转换器转换为指定的格式之后
     * ，写入到response对象的body区，通常用来返回JSON数据或者是XML
     * 　　数据，需要注意的呢，在使用此注解之后不会再走视图处理器，
     * 而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
     */

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap delete(@RequestParam Long id) {
        ModelMap modelMap = new ModelMap();
        try {
            boolean success = dictService.deleteById(id);
            modelMap.put("success", success);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("msg", e.getMessage());
        }
        return modelMap;
    }


}
