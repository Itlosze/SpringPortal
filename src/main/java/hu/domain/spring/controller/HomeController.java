package hu.domain.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.domain.spring.service.ContentService;

@Controller
public class HomeController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private ContentService contentService;
	
// ContentService injection
	@Autowired
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

// Start page
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("content", contentService.getContent());
		return "index";
	}

// All contents page
	@RequestMapping("/contents")
	public String contents(Model model) {
		model.addAttribute("contents", contentService.getContents());
		return "contents";
	}
	
//	@RequestMapping("/contents/{search}")
//	public String searchContent(@PathVariable(value="search") String title, Model model) throws Exception {
//		if (title==null) {
//			throw new Exception("There is no such title");
//		}
//		log.info(title);
//		model.addAttribute("content",contentService.getSpecificContent(title));
//		return "content";
//	}
	
//	Search result page
	@RequestMapping(value = "/contents", params= {"search"}, method = RequestMethod.GET)
	public String searchContent(@RequestParam (value = "search", required = false) String title, Model model) throws Exception {
		log.info("Search: "+title);
		if (title==null) {
			throw new Exception("There is no such title");
		}
		model.addAttribute("content",contentService.getSpecificContent(title));
		return "content";
	}
	
//	Writers page
	@RequestMapping("/writers")
	public String writers(Model model) {
		model.addAttribute("writers",contentService.getWriter());
		return "writers";
	}
	
}
