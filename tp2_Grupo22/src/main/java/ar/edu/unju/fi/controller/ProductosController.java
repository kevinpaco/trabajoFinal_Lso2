package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private ICommonService commonService;

	
	//Pagina con el listado de los productgos 
@GetMapping("/listado")
public String getProductosPage(Model model, @RequestParam (name = "categoriaP", required = false) String categoriaP) {
	model.addAttribute("productos", productoService.getListaP(categoriaP));
	model.addAttribute("categoriaP", categoriaP);
	return "productos";
}


	//Pagina para crear un producto nuevo
@GetMapping("/nuevo")
public String getNuevoProductoPage(Model model) {
    boolean edicion = false ;
    Producto producto = new Producto(); // Crear un nuevo objeto Producto
    model.addAttribute("producto", producto);
	model.addAttribute("categorias", commonService.getProductoCategoria());
    model.addAttribute("edicion", edicion);
    return "nuevo_producto";
}

//Página para modificar un producto
@GetMapping("/modificar/{id}")
public String getModificarProductosPage(Model model, @PathVariable(value = "id") Long id) {
  boolean edicion = true;
  Producto productoEncontrado = productoService.getBy(id);
  if (productoEncontrado == null) {
      return "redirect:/productos/listado";
  }
  model.addAttribute("producto", productoEncontrado);
  model.addAttribute("categorias", commonService.getProductoCategoria());
  model.addAttribute("edicion", edicion);
  return "nuevo_producto";
}


@PostMapping("/modificar")
public ModelAndView getModificarProductoPage(@Valid @ModelAttribute("producto")Producto producto, BindingResult result) {
	ModelAndView modelView = new ModelAndView("productos");
	boolean edicion = true;
	if(result.hasErrors()) {
		modelView.setViewName("nuevo_producto");
		modelView.addObject("producto", producto);
		modelView.addObject("categorias", commonService.getProductoCategoria());
		modelView.addObject("edicion", edicion);
		return modelView;
	}
	productoService.guardarProducto(producto);
//	modelView.addObject("consejos", productoService.getListaP());
	return modelView;
}

//Método para guardar o modificar un producto
@PostMapping("/guardar")
public ModelAndView guardarProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
  ModelAndView modelView = new ModelAndView("productos");
  if (result.hasErrors()) {
      modelView.setViewName("nuevo_producto");
      modelView.addObject("producto", producto);
      modelView.addObject("categorias", commonService.getProductoCategoria());
      return modelView;
  }
      productoService.guardarProducto(producto);
//  modelView.addObject("productos", productoService.getListaP());
  return modelView;
}

//Página para eliminar un producto
@GetMapping("/eliminar/{id}")
public String eliminarProducto(@PathVariable(value = "id") Long id) {
	Producto productoEncontrado = productoService.getBy(id);
    productoService.eliminarProducto(productoEncontrado);
    return "redirect:/productos/listado";
}
}
