package com.intuit.cg.backendtechassessment.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.cg.backendtechassessment.domain.Project;
import com.intuit.cg.backendtechassessment.domain.Seller;
import com.intuit.cg.backendtechassessment.service.ProjectService;
import com.intuit.cg.backendtechassessment.service.SellerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController extends AbstractRestHandler {
	@Autowired
    private SellerService sellerService;

 
 @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a project resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createProject(@RequestBody Seller seller,
                                 HttpServletRequest request, HttpServletResponse response) {
	 Seller createdSeller = this.sellerService.createSeller(seller);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdSeller.getSellerId()).toString());
    }	 

@RequestMapping(value = "",
        method = RequestMethod.GET,
        produces = {"application/json"})
@ResponseStatus(HttpStatus.OK)
@ApiOperation(value = "Get a paginated list of all projects.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
public
@ResponseBody
Page<Seller> getAllProject(@ApiParam(value = "The page number (zero-based)", required = true)
                                  @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                  @ApiParam(value = "Tha page size", required = true)
                                  @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                  HttpServletRequest request, HttpServletResponse response) {
    return this.sellerService.getAllSellers(page, size);
}

@RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
        produces = {"application/json"})
@ResponseStatus(HttpStatus.OK)
@ApiOperation(value = "Get a single project.", notes = "You have to provide a valid project ID.")
public
@ResponseBody
Seller getHotel(@ApiParam(value = "The ID of the project.", required = true)
                         @PathVariable("id") Long id,
                         HttpServletRequest request, HttpServletResponse response) throws Exception {
	Optional<Seller> seller = this.sellerService.getSeller(id);
   // checkResourceFound(project.get);
    return seller.get();
}


}
