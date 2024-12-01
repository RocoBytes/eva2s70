package cl.ipss.eva2s70.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.eva2s70.models.mesa;
import cl.ipss.eva2s70.repositories.mesaRepository;

/**
 * Servicio que gestiona la lógica de negocio para las mesas del restaurante Sabor Gourmet.
 * 
 * Esta clase implementa las operaciones de negocio relacionadas con las mesas:
 * - Obtención de listados de mesas
 * - Creación y actualización de mesas
 * - Búsqueda de mesas por ID
 * - Eliminación de mesas del sistema
 * 
 * Funcionalidades principales:
 * - Intermediario entre el controlador y el repositorio
 * - Validación de operaciones de mesa
 * - Gestión de la persistencia de datos
 * - Manejo de la lógica de negocio específica de mesas
 * 
 * Operaciones disponibles:
 * - listarTodas(): Obtiene todas las mesas
 * - guardar(mesa): Crea o actualiza una mesa
 * - obtenerPorId(id): Busca una mesa específica
 * - eliminar(id): Elimina una mesa del sistema
 * 
 * @author RocoBytes
 * @version 1.0
 * @since 2024-30-11
 */


@Service
public class mesaService {

    @Autowired
    private mesaRepository mesaRepository;

    /**
     * Obtiene todas las mesas existentes en la base de datos.
     * 
     * @return Lista con todas las mesas del sistema
     */
    public List<mesa> listarTodas(){
        return mesaRepository.findAll();
    }

    /**
     * Guarda o actualiza una mesa en la base de datos.
     * 
     * @param mesa Objeto mesa a guardar
     * @return Mesa guardada con su ID generado
     */
    public mesa guardar(mesa mesa) {
        return mesaRepository.save(mesa);
    }   
   
    /**
     * Busca una mesa por su ID.
     * 
     * @param id ID de la mesa a buscar
     * @return Mesa encontrada o null si no existe
     */
    public mesa obtenerPorId(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

    /**
     * Elimina una mesa de la base de datos por su ID.
     * 
     * @param id ID de la mesa a eliminar
     */
    public void eliminar(Long id) {
        mesaRepository.deleteById(id);
    }
}