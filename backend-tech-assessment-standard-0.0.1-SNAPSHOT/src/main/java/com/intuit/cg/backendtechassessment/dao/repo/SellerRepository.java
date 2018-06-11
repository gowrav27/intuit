package com.intuit.cg.backendtechassessment.dao.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.intuit.cg.backendtechassessment.domain.Project;
import com.intuit.cg.backendtechassessment.domain.Seller;

public interface SellerRepository extends CrudRepository<Seller, Long>  {
	Page findAll(Pageable pageable);
}
