package cl.ipss.eva2s70.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador principal que maneja la página de inicio del sistema de restaurante.
 * 
 * Este controlador es responsable de:
 * - Mostrar la página principal del sistema (index)
 * - Servir como punto de entrada para la navegación del usuario
 * - Presentar las opciones principales de gestión de mesas y reservas
 * 
 * Rutas manejadas:
 * - GET "/" : Muestra la página principal con las opciones de navegación
 * 
 * @author RocoBytes
 * @version 1.0
 * @since 2024-11-30
 */
@Controller
@RequestMapping("/")
public class homeController {
    @GetMapping
    public String index() {
        return "index";
    }
}

