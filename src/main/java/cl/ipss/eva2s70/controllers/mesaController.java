package cl.ipss.eva2s70.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.ipss.eva2s70.models.mesa;
import cl.ipss.eva2s70.services.mesaService;


/**
 * Controlador que gestiona las operaciones CRUD para las mesas del restaurante.
 * 
 * Este controlador es responsable de:
 * - Listar todas las mesas disponibles
 * - Crear nuevas mesas
 * - Editar mesas existentes
 * - Eliminar mesas
 * - Gestionar el estado de disponibilidad de las mesas
 * 
 * Rutas manejadas:
 * - GET "/mesa" : Lista todas las mesas
 * - GET "/mesa/nuevo" : Formulario para crear nueva mesa
 * - POST "/mesa/guardar" : Guarda una nueva mesa o actualiza una existente
 * - GET "/mesa/editar/{id}" : Muestra formulario para editar una mesa
 * - GET "/mesa/eliminar/{id}" : Elimina una mesa específica
 * 
 * @author RocoBytes
 * @version 1.0
 * @since 2024-11-30
 */



@Controller
@RequestMapping("/mesa")
public class mesaController {

    @Autowired
    private mesaService mesaService;

    /**
     * Lista todas las mesas disponibles en el sistema.
     * 
     * @param model Modelo para pasar datos a la vista
     * @return Vista mesaListar con la lista de todas las mesas
     */
    @GetMapping
    public String listarmesas(Model model) {
        model.addAttribute("titulo", "Listado de mesas");
        model.addAttribute("mesa", mesaService.listarTodas());
        return "mesaListar";
    }

    /**
      Muestra el formulario para crear una nueva mesa.
    
     * @param model Modelo para pasar datos a la vista
     * @return Vista mesaCrear con el formulario vacío
     */
    @GetMapping("/nuevo")
    public String nuevamesa(Model model) {
        model.addAttribute("mesa", new mesa());
        return "mesaCrear";
    }

    /**
     * Guarda una nueva mesa o actualiza una existente.
     * 
     * @param mesa Mesa a guardar
     * @param redirectAttributes Para mensajes flash de éxito
     * @return Redirección a la lista de mesas
     */
    @PostMapping("/guardar")
    public String guardarPersona(mesa mesa, RedirectAttributes redirectAttributes) {
        mesaService.guardar(mesa);
        redirectAttributes.addFlashAttribute("msg", "mesa guardada con éxito!");
        return "redirect:/mesa";
    }

    /**
     * Muestra el formulario para editar una mesa existente.
     * 
     * @param id ID de la mesa a editar
     * @param model Modelo para pasar datos a la vista
     * @return Vista mesaCrear con los datos de la mesa
     */
    @GetMapping("/editar/{id}")
    public String editarmesa(@PathVariable Long id, Model model) {
        model.addAttribute("mesa", mesaService.obtenerPorId(id));
        return "mesaCrear";
    }

    /**
     * Elimina una mesa específica del sistema.
     * 
     * @param id ID de la mesa a eliminar
     * @return Redirección a la lista de mesas
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarmesa(@PathVariable Long id) {
        mesaService.eliminar(id);
        return "redirect:/mesa";
    }
}
