package hu.domain.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGeneral {

//	Exception details for the handler page
	@ExceptionHandler
	public String exception(Exception ex, Model model){
		model.addAttribute("exception",ex);
		return "exceptionhandler";
	}

}
