package com.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService 
{
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductEntity> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	public ProductEntity getProductById(int id) throws ResourceNotFoundException
	{
		ProductEntity entity = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product Not Found : "+id));
		
		return entity;
	}
	
	public void addProduct(ProductEntity productEntity)
	{
		productRepository.save(productEntity);
	}
	
	public void updateProduct(int id,ProductEntity productEntity) throws ResourceNotFoundException
	{
			ProductEntity entity = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ProductNot Found :"+id));
			entity.setProduct_name(productEntity.getProduct_name());
			entity.setDescription(productEntity.getDescription());
			
			productRepository.save(entity);
	}
	
	public void deleteProduct(int id) throws ResourceNotFoundException
	{
		ProductEntity entity = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ProductNot Found :"+id));
		productRepository.delete(entity);
	}
}
