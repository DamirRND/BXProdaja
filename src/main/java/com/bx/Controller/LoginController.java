package com.bx.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bx.Model.Radnik;
import com.bx.Service.RadnikService;

@Controller
public class LoginController {

	private final RadnikService rs;
	
	@Autowired
	public  LoginController(RadnikService rs) {
		this.rs=rs;
	}
	
	@GetMapping(path = "/login")
	public String login(Model model) {
		model.addAttribute("radnik", new Radnik());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Integer provjera(@ModelAttribute Radnik radnik){
		Radnik r = rs.findOne(radnik.getKorIme(), radnik.getKorLozinka());
		if(r==null) {
			return 1;
		}else {
			return 2;
		}
	}
	
	
}
