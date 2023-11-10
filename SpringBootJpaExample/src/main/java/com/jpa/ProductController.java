package com.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@GetMapping("/allProducts")
	public List<ProductEntity> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public ProductEntity getProductById(@PathVariable(value = "id") int id) throws ResourceNotFoundException
	{
		return productService.getProductById(id);
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody ProductEntity entity)
	{
		productService.addProduct(entity);
		
		return "Added Successfully...";
	}
	
	@PutMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable(value = "id") int id,@RequestBody ProductEntity entity) throws ResourceNotFoundException
	{
		productService.updateProduct(id, entity);
		
		return "Updated Successfully...";
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value = "id") int id) throws ResourceNotFoundException
	{
		productService.deleteProduct(id);
		
		return "Deleted Successfully...";
	}
}
