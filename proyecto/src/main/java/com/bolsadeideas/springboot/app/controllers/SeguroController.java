package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Seguro;
import com.bolsadeideas.springboot.app.models.service.IClienteService;
import com.bolsadeideas.springboot.app.models.service.ISeguroService;

@Controller
@SessionAttributes("seguro")
public class SeguroController {
	
	@Autowired
	private ISeguroService seguroService;
	
	@RequestMapping(value = "/listarSeguro", method = RequestMethod.GET)
	public String listarSeguro(Model model) {
		model.addAttribute("titulo", "Listado de seguros");
		model.addAttribute("seguros", seguroService.findAll());
		return "listarSeguro";
	}
	
	@RequestMapping(value = "/formSeguro")
	public String crear(Map<String, Object> model) {

		Seguro seguro = new Seguro();
		model.put("seguro", seguro);
		model.put("titulo", "Formulario de Seguro");
		return "formSeguro";
	}
	
	@RequestMapping(value="/formSeguro/{id}")
	public String editarSeguro(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Seguro seguro = null;
		
		if(id > 0) {
			seguro = seguroService.findOne(id);
		} else {
			return "redirect:/listarSeguro";
		}
		model.put("seguro", seguro);
		model.put("titulo", "Editar seguro");
		return "formSeguro";
	}
	
	@RequestMapping(value = "/formSeguro", method = RequestMethod.POST)
	public String guardar(@Valid Seguro seguro, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de seguro");
			return "formSeguro";
		}

		seguroService.save(seguro);
		status.setComplete();
		return "redirect:listarSeguro";
	}
	
	@RequestMapping(value="/eliminarSeguro/{id}")
	public String eliminarSeguro(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			seguroService.delete(id);
		}
		return "redirect:/listarSeguro";
	}

}
