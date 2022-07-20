package hu.domain.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

@Controller
public class ErrorPageController implements ErrorController {
	 
	private static final String ERROR_PATH = "/error";
	
	@Autowired
	private ErrorAttributes errorAttributes;

// Error details for the error page
	@RequestMapping(ERROR_PATH)
	public String error(Model model, HttpServletRequest request) {
		ServletWebRequest rA = new ServletWebRequest(request);
		Map<String,Object> error = this.errorAttributes.getErrorAttributes(rA, ErrorAttributeOptions.defaults());
		model.addAttribute("error",error.get("error"));
		model.addAttribute("status",error.get("status"));
		model.addAttribute("path",error.get("path"));
		model.addAttribute("timestamp",error.get("timestamp"));
		return "error";
	}
		
	public String getErrorPath() {
		return ERROR_PATH;
	}

}