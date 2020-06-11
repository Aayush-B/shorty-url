package com.shortyurl.shortyurl.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shortyurl.shortyurl.services.UrlService;

@Controller
public class HomeController {

	@Autowired
	private UrlService urlService;
	
	@GetMapping("/")
	public ModelAndView displayHome(Model model) {
		
		String compressedUrl=null ;
		
		if(model!=null) {
			Map<Object,Object> viewParams=(Map<Object, Object>) model.asMap().get("viewParams") ;
			
			if(viewParams!=null) {
				compressedUrl = (String)viewParams.get("compressedUrl");
			}
		}
		
		Map<Object,Object> viewParams=new HashMap<Object,Object>() ;
		viewParams.put("latestUrls", urlService.returnLastTenUrls()) ;
		viewParams.put("compressedUrl", compressedUrl) ;
		return new ModelAndView("index", "viewParams", viewParams);
	}

	@PostMapping("/compress-url")
	public String redirectToHomeWithCompressedUrl(@RequestParam Map<String, String> userUrlMap, RedirectAttributes redirectAttributes) {
		Map<Object,Object> viewParams=new HashMap<Object,Object>() ;
		viewParams.put("compressedUrl", urlService.compressURL(userUrlMap.get("userUrl"))) ;
		viewParams.put("latestUrls", urlService.returnLastTenUrls()) ;
		redirectAttributes.addFlashAttribute("viewParams",viewParams) ;
		return "redirect:/";
	}

	@GetMapping("/{userUrl}")
	public String goToOriginalUrl(@PathVariable String userUrl) {
		return "redirect:" + urlService.getOriginalUrl(userUrl);
	}
}
