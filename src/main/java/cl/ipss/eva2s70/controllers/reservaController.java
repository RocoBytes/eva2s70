package cl.ipss.eva2s70.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ipss.eva2s70.models.reserva;
import cl.ipss.eva2s70.services.mesaService;
import cl.ipss.eva2s70.services.reservaService;


/**
 * Controlador que gestiona las operaciones CRUD para las mesas del restaurante Sabor Gourmet.
 * 
 * Este controlador maneja todas las operaciones relacionadas con las mesas:
 * - Visualización del listado completo de mesas
 * - Creación de nuevas mesas en el sistema
 * - Actualización de información de mesas existentes
 * - Eliminación de mesas del sistema
 * 
 * Funcionalidades principales:
 * - Gestión del número de mesa
 * - Control de cantidad de asientos
 * - Manejo del estado de disponibilidad
 * 
 * Rutas disponibles:
 * - GET "/mesa" : Muestra todas las mesas
 * - GET "/mesa/nuevo" : Formulario de nueva mesa
 * - POST "/mesa/guardar" : Guarda/actualiza mesa
 * - GET "/mesa/editar/{id}" : Edita mesa existente
 * - GET "/mesa/eliminar/{id}" : Elimina mesa
 * 
 * @author RocoBytes
 * @version 1.0
 * @since 2024-11-30
 */



@Controller
@RequestMapping("/reserva")
public class reservaController {

    @Autowired
    private reservaService reservaService;
    @Autowired
    private mesaService mesaService;

    /**
     * Lista todas las reservas existentes en el sistema.
     * 
     * @param model Modelo para pasar datos a la vista
     * @return Vista reservaListar con la lista de todas las reservas
     */
    @GetMapping
    public String listarreservas(Model model) {
        model.addAttribute("titulo", "Listado de reservas");
        model.addAttribute("reserva", reservaService.listarTodas());
        return "reservaListar";
    }

    /**
     * Muestra el formulario para crear una nueva reserva.
     * Carga la lista de mesas disponibles para selección.
     * 
     * @param model Modelo para pasar datos a la vista
     * @return Vista reservaCrear con el formulario vacío y lista de mesas
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrearreserva(Model model) {
        model.addAttribute("reserva", new reserva());
        model.addAttribute("mesa", mesaService.listarTodas()); // Cargar todas las mesas disponibles
        return "reservaCrear";
    }

    /**
     * Guarda una nueva reserva o actualiza una existente.
     * 
     * @param reserva Objeto reserva con los datos a guardar
     * @return Redirección a la lista de reservas
     */
    @PostMapping("/guardar")
    public String guardarreserva(reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reserva";
    }

    /**
     * Muestra el formulario para editar una reserva existente.
     * 
     * @param id ID de la reserva a editar
     * @param model Modelo para pasar datos a la vista
     * @return Vista reservaCrear con los datos de la reserva
     */
    @GetMapping("/editar/{id}")
    public String editarreserva(@PathVariable Long id, Model model) {
        model.addAttribute("reserva", reservaService.obtenerPorId(id));
        return "reservaCrear";
    }

    /**
     * Elimina una reserva específica del sistema.
     * 
     * @param id ID de la reserva a eliminar
     * @return Redirección a la lista de reservas
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarreserva(@PathVariable Long id) {
        reservaService.eliminar(id);
        return "redirect:/reserva";
    }
}