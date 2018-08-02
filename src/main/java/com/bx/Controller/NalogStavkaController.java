package com.bx.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bx.Model.NalogStavka;
import com.bx.Service.NalogStavkaService;

@Controller
public class NalogStavkaController {
	
	
	private final NalogStavkaService nss;
	
	
	public NalogStavkaController(NalogStavkaService nss) {
		this.nss = nss;
	}
	
	@RequestMapping(path="/nalogStavke", method=RequestMethod.GET)
	public List<NalogStavka> listaNaloga(){
		return nss.findallByNalogId(89673);
	}
	

}
