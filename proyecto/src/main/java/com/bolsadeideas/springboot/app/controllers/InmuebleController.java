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

import com.bolsadeideas.springboot.app.models.entity.Inmueble;
import com.bolsadeideas.springboot.app.models.service.IInmuebleService;

@Controller
@SessionAttributes("Inmueble")
public class InmuebleController {

	@Autowired
	private IInmuebleService inmuebleService;

	@RequestMapping(value = "/listarInmueble", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de inmuebles");
		model.addAttribute("inmuebles", inmuebleService.findAll());
		return "listarInmueble";
	}

	@RequestMapping(value = "/formInmueble")
	public String crear(Map<String, Object> model) {

		Inmueble inmueble = new Inmueble();
		model.put("inmueble", inmueble);
		model.put("titulo", "Formulario de Inmuebles");
		return "formInmueble";
	}

	@RequestMapping(value = "/formInmueble/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		Inmueble inmueble = null;

		if (id > 0) {
			inmueble = inmuebleService.findOne(id);
		} else {
			return "redirect:/listarInmueble";
		}
		model.put("inmueble", inmueble);
		model.put("titulo", "Editar Inmueble");
		return "formInmueble";
	}

	@RequestMapping(value = "/formInmueble", method = RequestMethod.POST)
	public String guardar(@Valid Inmueble inmueble, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Inmueble");
			return "formInmueble";
		}

		inmuebleService.save(inmueble);
		status.setComplete();
		return "redirect:listarInmueble";
	}

	@RequestMapping(value = "/eliminarInmueble/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			inmuebleService.delete(id);
		}
		return "redirect:/listarInmueble";
	}

}
