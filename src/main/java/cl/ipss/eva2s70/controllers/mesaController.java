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

@Controller
@RequestMapping("/mesa")
public class mesaController {

    @Autowired
    private mesaService mesaService;

    
    @GetMapping
    public String listarmesas(Model model) {
        model.addAttribute("titulo", "Listado de mesas");
        model.addAttribute("mesa", mesaService.listarTodas());
        return "mesaListar";
    }
    @GetMapping("/nuevo")
      public String nuevamesa(Model model) {
          model.addAttribute("mesa", new mesa());
          return "mesaCrear";
      }
  
      @PostMapping("/guardar")
      public String guardarPersona(mesa mesa, RedirectAttributes redirectAttributes) {
          mesaService.guardar(mesa);
          redirectAttributes.addFlashAttribute("msg", "mesa guardada con éxito!");
          return "redirect:/mesa";
      }
  
      @GetMapping("/editar/{id}")
      public String editarmesa(@PathVariable Long id, Model model) {
          model.addAttribute("mesa", mesaService.obtenerPorId(id));
          return "mesaCrear";
      }
  
      @GetMapping("/eliminar/{id}")
      public String eliminarmesa(@PathVariable Long id) {
        mesaService.eliminar(id);
          return "redirect:/mesa";
      }
}
