package com.niit.controllers;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.services.ProductService;

@Controller
public class ProductController {
	@Autowired
private ProductService productService;
	public ProductController(){
		System.out.println("ProductController bean is created");
	}
	
	//http://localhost:8080/project1frontend/all/getproducts 
	@RequestMapping(value="/all/getproducts")
	public ModelAndView getAllProducts(){
		List<Product> products=productService.getAllProducts();
		//1st parameter - logical view name - productlist
		//2nd parameter - model attribute name - refer it in jsp page
		//3rd parameter - model [data] list of products
		// /WEB-INF/views/productlist.jsp
		return new ModelAndView("productlist","productsAttr",products);
	}
	@RequestMapping(value="/all/getproduct/{id}")  //id is pathvariable  id=1, id=2, id=3
	//  all/getproduct/1  , all/getproduct/2 , all/getproduct/3...
	public ModelAndView getProduct(@PathVariable int id){//id =1, 2, 3 
		//Pass this id to Service -> Service has to pass the id to Dao -> select * from product where id=1
		System.out.println("Product Id is " + id);
		Product product=productService.getProduct(id);
		System.out.println("Product is " + product );
		return new ModelAndView("productdetails","product",product);
		// 1st parameter productdetails - view name - jsp filename
		//2nd parameter product  - model attribute - in jsp page to display the data
		//3rd parameter product - model -data [1 1000.0 Product Description for toy car Toy Car 12]
		//product = [1 1000.0 Product Description for toy car Toy Car 12]
	}
	
	@RequestMapping(value="/admin/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return "redirect:/all/getproducts";
	}
	@RequestMapping(value="/admin/getproductform")
	public ModelAndView getProductForm(){
		return new ModelAndView("productform","product",new Product());
	}
	@RequestMapping(value="/admin/updateproductform/{id}")
	public ModelAndView getUpdateProductForm(@PathVariable int id){
		Product product=productService.getProduct(id);
		return new ModelAndView("updateproductform","product",product);
	}
	
	
	@RequestMapping(value="/admin/saveproduct")
	public String saveProduct(@ModelAttribute(name="product") Product product){
		System.out.println("New Product Details " + product);
		productService.saveProduct(product);
		return "redirect:/all/getproducts";
	}
	
	@RequestMapping(value="/admin/updateproduct")
	public String updateProduct(@ModelAttribute(name="product") Product product){
		System.out.println("New Product Details " + product);
		productService.updateProduct(product);
		return "redirect:/all/getproducts";
	}
	
	/*@RequestMapping(value="/admin/saveproduct")
		public String saveProduct(@Valid @ModelAttribute(name="product") Product product,BindingResult result){
		if(result.hasErrors()){//hasErrors return true if product details in not valid
			return "productform";
		}
		System.out.println("New Product Details " + product);
		productService.saveProduct(product);
		return "redirect:/all/getproducts";
	}
	
	@RequestMapping(value="/admin/updateproduct")
	public String updateProduct(@Valid @ModelAttribute(name="product") Product product,BindingResult result){
		if(result.hasErrors()){
			return "updateproductform";
		}
		System.out.println("New Product Details " + product);
		productService.updateProduct(product);
		return "redirect:/all/getproducts";
	}

*/	
	@RequestMapping(value="/admin/getproductform")
	public String getProductForm(Model model){//model to send data to the view
		//Two model attributes
		//product =new Product();
		//categories = List<Category>
		List<Category> categories=productService.getAllCategories();
		model.addAttribute("product",new Product());
		model.addAttribute("categories",categories);
		System.out.println("Size of category list " + categories.size());
		return "productform";
	}


	
	
}

