package com.intuit.cg.backendtechassessment.controller;


public class AbstractRestHandler {
	protected static final String  DEFAULT_PAGE_SIZE = "100";
    protected static final String DEFAULT_PAGE_NUM = "0";
    
    public static <T> T checkResourceFound(final T resource) {
        if (resource == null) {
            throw new RuntimeException("resource not found");
        }
        return resource;
    }
}
