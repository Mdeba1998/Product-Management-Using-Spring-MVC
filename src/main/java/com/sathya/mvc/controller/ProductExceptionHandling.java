package com.sathya.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandling {
	
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public String handleValidationExceptions(MethodArgumentNotValidException ex, Model model) {
	        StringBuilder errorMessage = new StringBuilder();

	ex.getBindingResult()
	  .getAllErrors()
	  .forEach((error) -> {
		String fieldName = ((FieldError) error).getField();
		String message = error.getDefaultMessage();
		errorMessage.append(fieldName).append(": ").append(message).append("\n");
	});
	        
	        model.addAttribute("errorMessage", errorMessage.toString());
	        model.addAttribute("product", ex.getBindingResult().getTarget()); // Add the product object back to the model
	        return "newProduct";
	    }
}
