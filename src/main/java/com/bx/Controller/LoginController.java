package com.bx.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bx.Model.Radnik;
import com.bx.Service.RadnikService;

@Controller
public class LoginController {

	private final RadnikService rs;
	private final HttpSession sesija;
	
	@Autowired
	public  LoginController(RadnikService rs, HttpSession sesija) {
		this.rs=rs;
		this.sesija=sesija;
	}
	
	@GetMapping(path = "/login")
	public String login(Model model) {
		model.addAttribute("radnik", new Radnik());
		return "login";
	}
	
	@PostMapping(path="/index")
	public String provjera(@ModelAttribute Radnik radnik){
		Radnik r = rs.findOne(radnik.getKorIme(), radnik.getKorLozinka());
		if(r==null) {
			sesija.setAttribute("NEMA", "0");
			return "login";
		}else {
			sesija.setAttribute("id", r.getId());
			sesija.setAttribute("Ime", r.getKorIme());
			return "index";
		}
	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	@ResponseBody
	public Boolean logout() {
		sesija.removeAttribute("id");
		sesija.removeAttribute("Ime");
		sesija.invalidate();
		if(sesija.isNew()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	@RequestMapping(value="/provjeriSesiju", method=RequestMethod.GET)
	@ResponseBody
	public Integer sesija() {
		if(sesija.getAttribute("NEMA")==null) {
			if(sesija.getAttribute("id")!=null) {
				return Integer.valueOf(sesija.getAttribute("id").toString());
			}else {
				return 0;
			}
			
		}else {
			return 0;
		}
	}
	
	
}
