package com.practicehouse.WidgetsList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.practicehouse.WidgetsList.model.Widget;
import com.practicehouse.WidgetsList.repository.WidgetRepo;

@Controller
public class WidgetController {
	
	@Autowired
	private WidgetRepo repo;
	
	/**
     * Get all widgets.
     * Considering home page
     */
	 
    @GetMapping("/widgets")
    public String getWidgets(Model model) {
        model.addAttribute("widgets", repo.findAll());
        return "widgets";
    }

	/**
     * Load the new widget page.
     */    
    @GetMapping("/widget/new")
    public String newWidget(Model model) {
        model.addAttribute("widget", new Widget());
        return "widgetform";
    }
    
    /**
     * Create a new widget.
     */
    @PostMapping("/widget")
    public String createWidget(Widget widget, Model model) {
    	repo.save(widget);
        return "redirect:/widgets";
    }
    
    /**
     * Get a widget by ID.
     */
    @GetMapping("/widget/{id}")
    public String getWidgetById(@PathVariable Long id, Model model) {
        model.addAttribute("widget", repo.findById(id).orElse(new Widget()));
        return "widget";
    }
    
    /**
     * Load the edit widget page for the widget with the specified ID.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/widget/edit/{id}")
    public String editWidget(@PathVariable Long id, Model model) {
        model.addAttribute("widget", repo.findById(id).orElse(new Widget()));
        return "widgetform";
    }
    
    /**
     * Update a widget.
     */
    @PostMapping("/widget/{id}")
    public String updateWidget(Widget widget) {
        repo.save(widget);
        return "redirect:/widget/" + widget.getId();
    }
    
    /**
     * Delete a widget by ID.
     * @PathVariable id
     */
    @GetMapping("/widget/delete/{id}")
    public String deleteWidget(@PathVariable  Long id) {
        repo.deleteById(id);
        return "redirect:/widgets";
    }
	

}
