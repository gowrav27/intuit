package com.intuit.cg.backendtechassessment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.intuit.cg.backendtechassessment.dao.repo.ProjectRepository;
import com.intuit.cg.backendtechassessment.dao.repo.SellerRepository;
import com.intuit.cg.backendtechassessment.domain.Project;
import com.intuit.cg.backendtechassessment.domain.Seller;

@Service
public class SellerService {
	@Autowired
    private SellerRepository sellerRepository;
	
	public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Optional<Seller> getSeller(long id) {
        return sellerRepository.findById(id);
    }

    public void updateSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
    
    public Page<Seller> getAllSellers(Integer page, Integer size) {
    	return sellerRepository.findAll(PageRequest.of(page, size));
    }
}
