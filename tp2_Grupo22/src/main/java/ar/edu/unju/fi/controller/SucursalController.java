package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {
    
    @Autowired
    Sucursal sucursal;
    
    @Autowired
    private ISucursalService sucursalService;
    
    /**
     * Muestra la página de listado de sucursales.
     *
     * @param model el modelo de la vista.
     * @return el nombre de la vista.
     */
    @GetMapping("/listado")
    public String getListaSucursalesPage(Model model) {
        model.addAttribute("sucursales", sucursalService.getLista());
        return "sucursales";
    }

    /**
     * Muestra la página de creación de una nueva sucursal.
     *
     * @param model el modelo de la vista.
     * @return el nombre de la vista.
     */
    @GetMapping("/nuevo")
    public String getNuevaSucursalPage(Model model) {
        boolean edicion = false;
        model.addAttribute("sucursal", sucursalService.getSucursal());
        model.addAttribute("edicion", edicion);
        return "nueva_sucursal";
    }

    /**
     * Guarda una nueva sucursal o actualiza una existente.
     *
     * @param sucursal la sucursal a guardar o actualizar.
     * @param result   los resultados de la validación.
     * @return el ModelAndView que redirige a la página de listado de sucursales.
     */
    @PostMapping("/guardar")
    public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
        ModelAndView modelView = new ModelAndView("sucursales");
        if (result.hasErrors()) {
            modelView.setViewName("nueva_sucursal");
            modelView.addObject("sucursal", sucursal);
            return modelView;
        }
        sucursal.setEstado(true);
        sucursalService.guardar(sucursal);
        modelView.setViewName("sucursales");
        modelView.addObject("sucursales", sucursalService.getLista());
        return modelView;
    }

    /**
     * Muestra la página de modificación de una sucursal existente.
     *
     * @param model el modelo de la vista.
     * @param id    el ID de la sucursal a modificar.
     * @return el ModelAndView que muestra la página de modificación de sucursal.
     */
    @GetMapping("/modificar/{id}")
    public ModelAndView getModificarSucursalPage(Model model, @PathVariable(value = "id") Long id) {
        ModelAndView modelView = new ModelAndView("nueva_sucursal");
        Sucursal sucursalEncontrada = sucursalService.getBy(id);
        boolean edicion = true;
        modelView.addObject("sucursal", sucursalEncontrada);
        modelView.addObject("edicion", edicion);
        return modelView;
    }

    /**
     * Modifica una sucursal existente.
     *
     * @param sucursal la sucursal modificada.
     * @param result   los resultados de la validación.
     * @param model    el modelo de la vista.
     * @return el nombre de la vista que redirige a la página de listado de sucursales.
     */
    @PostMapping("/modificar")
    public ModelAndView modificarSucursal(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
    	ModelAndView modelView = new ModelAndView("sucursales");
    	if (result.hasErrors()) {
    		boolean edicion = true;
    		modelView.setViewName("nueva_sucursal");
    		modelView.addObject("sucursal", sucursal);
    		modelView.addObject("edicion", edicion);
    		return modelView;
            }
    	sucursalService.guardar(sucursal);
    	modelView.addObject("sucursales", sucursalService.getLista());
    	return modelView;
    }

    /**
     * Elimina una sucursal existente.
     *
     * @param id el ID de la sucursal a eliminar.
     * @return el nombre de la vista que redirige a la página de listado de sucursales.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarSucursal(@PathVariable(value = "id") Long id) {
        Sucursal sucursalEncontrada = sucursalService.getBy(id);
        sucursalService.eliminar(sucursalEncontrada);
        return "redirect:/sucursales/listado";
    }
}
