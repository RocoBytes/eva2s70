package cl.ipss.eva2s70.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.eva2s70.models.reserva;
import cl.ipss.eva2s70.repositories.reservaRepository;

/**
 * Servicio que gestiona la lógica de negocio para las reservas del restaurante
 * Sabor Gourmet.
 * 
 * Esta clase implementa las operaciones de negocio relacionadas con las
 * reservas:
 * - Gestión del listado completo de reservas
 * - Creación de nuevas reservas
 * - Actualización de reservas existentes
 * - Eliminación de reservas
 * - Manejo de la relación entre reservas y mesas
 * 
 * Funcionalidades principales:
 * - Intermediario entre el controlador y el repositorio de reservas
 * - Validación de horarios de reserva
 * - Verificación de disponibilidad de mesas
 * - Control de la persistencia de datos de reservas
 * - Gestión de la lógica de negocio específica de reservas
 * 
 * Operaciones disponibles:
 * - listarTodas(): Obtiene todas las reservas con sus mesas asociadas
 * - guardar(reserva): Crea o actualiza una reserva
 * - obtenerPorId(id): Busca una reserva específica
 * - eliminar(id): Elimina una reserva del sistema
 * 
 * @author RocoBytes
 * @version 1.0
 * @since 2024-30-11
 */

// Indica que esta clase es un servicio de Spring que maneja la lógica de negocio de reservas
@Service
public class reservaService {

    @Autowired
    private reservaRepository reservaRepository;

    public List<reserva> listarTodas() {
        return reservaRepository.findAllWithMesa();
    }
    public reserva guardar(reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }

}
