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

import com.bolsadeideas.springboot.app.models.entity.Reclamacion;
import com.bolsadeideas.springboot.app.models.service.IReclamacionService;

@Controller
@SessionAttributes("Reclamacion")
public class ReclamacionController {
	@Autowired
	private IReclamacionService reclamacionService;

	@RequestMapping(value = "/listarReclamaciones", method = RequestMethod.GET)

	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de requerimientos");
		model.addAttribute("requerimietos", reclamacionService.findAll());
		return "listarReclamacione";
	}

	@RequestMapping(value = "/formReclamacion")
	public String crear(Map<String, Object> model) {

		Reclamacion reclamacion = new Reclamacion();
		model.put("Reclamacion", reclamacion);
		model.put("titulo", "Formulario de reclamacion");
		return "formReclamacion";
	}

	@RequestMapping(value = "/formReclamacion/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		Reclamacion reclamacion = null;

		if (id > 0) {
			reclamacion = reclamacionService.findOne(id);
		} else {
			return "redirect:/listarInmuebles";
		}
		model.put("inmueble", reclamacion);
		model.put("titulo", "Editar Reclamacion");
		return "formReclamacion";
	}

	@RequestMapping(value = "/formReclamacion", method = RequestMethod.POST)
	public String guardar(@Valid Reclamacion reclamacion, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Reclamacion");
			return "formReclamacion";
		}

		reclamacionService.save(reclamacion);
		status.setComplete();
		return "redirect:listarReclamacion";
	}

	@RequestMapping(value = "/eliminarReclamacion/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			reclamacionService.delete(id);
		}
		return "redirect:/listarReclamacion";
	}

}
