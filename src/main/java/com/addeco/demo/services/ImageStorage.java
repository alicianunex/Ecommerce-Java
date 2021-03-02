package com.addeco.demo.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.addeco.demo.entity.Product;
import com.addeco.demo.repository.ProductRepository;


@Service
public class ImageStorage {

  @Autowired
  private ProductRepository productRepository;

  public Product store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Product product = new Product();

    return productRepository.save(product);
  }

  public Product getFile(Long id) {
    return productRepository.findById(id).get();
  }
  
  public Stream<Product> getAllFiles() {
    return productRepository.findAll().stream();
  }
}