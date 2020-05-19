package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EstudianteDAO;
import com.example.demo.domain.Estudiante;


@Controller
public class MainController {
	
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@RequestMapping ("/inicio")
	public ModelAndView initMain() {
		Estudiante estudiante = new Estudiante();
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping ("/formEstudiante")
	public ModelAndView formEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("index");
		}
		
		else {
			mav.setViewName("exito");
		}
		
		return mav;
	}
	
	//Mostrar lista de Estudiantes
	@RequestMapping ("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List <Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDAO.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	//un estudiante
	@RequestMapping (value = "/mostrarEstudiante", method = RequestMethod.POST)
	public ModelAndView findOne(@RequestParam (value = "codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try {
			estudiante = estudianteDAO.findOne(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiante", estudiante);
		mav.setViewName("estudiante");
		return mav;
	}
	

}
