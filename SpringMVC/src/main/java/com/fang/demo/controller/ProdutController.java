package com.fang.demo.controller;


import com.fang.demo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


/**
 * 产品输入与保存的demo实现
 */

@Controller
public class ProdutController {

    @RequestMapping(value = "product_input")
    public String inputProduct(Model model) {
        model.addAttribute("product", new Product());
        return "ProducrtForm";
    }


    @RequestMapping(value = "product_save")
    public String productSave(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            FieldError fieldError = bindingResult.getFieldError();

            System.out.print("code" + fieldError.getCode() + "\n");
            System.out.print("product=" + product);

            return "ProducrtForm";
        }
        model.addAttribute("product", product);
        return "ProductDetails";
    }


}
