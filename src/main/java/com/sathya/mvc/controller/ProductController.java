package com.sathya.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sathya.mvc.model.Product;
import com.sathya.mvc.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/getform")
    public String getProductForm(Model model) {
    	logger.info("Getting the form: {}");
        Product product = new Product();
        product.setMadeIn("India");
        model.addAttribute("product", product);
        return "newProduct";
    }

    @PostMapping("/saveproduct")
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            logger.error("Validation failed while saving product: {}", bindingResult.getAllErrors());
            model.addAttribute("product", product);
            return "newProduct";
        }

        boolean status = productService.createProduct(product);
        if (status) {
            redirectAttributes.addFlashAttribute("saveMessage", "Product Saved Successfully");
            logger.info("Product saved successfully: {}", product);
            return "redirect:/products/getproducts";
        } else {
            redirectAttributes.addFlashAttribute("saveMessage", "Product Saving Failed");
            logger.error("Failed to save product: {}", product);
            return "failure";
        }
    }

    @GetMapping("/getproducts")
    public String getProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        logger.info("Retrieved all products: {}", products);
        return "productsList";
    }

    @GetMapping("/editproduct/{proId}")
    public String editProduct(@PathVariable Long proId, Model model) {
        Product existingProduct = productService.getProduct(proId);
        model.addAttribute("product", existingProduct);
        logger.info("Editing product with ID: {}", proId);
        return "editProduct";
    }

    @GetMapping("/deleteproduct/{proId}")
    public String deleteProduct(@PathVariable Long proId, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(proId);
        redirectAttributes.addFlashAttribute("deleteMessage", "Product Deleted Successfully");
        logger.info("Product deleted successfully with ID: {}", proId);
        return "redirect:/products/getproducts";
    }
}
