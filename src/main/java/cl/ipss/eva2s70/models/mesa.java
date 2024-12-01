package cl.ipss.eva2s70.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * Controlador que gestiona las operaciones CRUD para las reservas del restaurante Sabor Gourmet.
 * 
 * Este controlador maneja todas las operaciones relacionadas con las reservas:
 * - Visualización del listado completo de reservas
 * - Creación de nuevas reservas en el sistema
 * - Actualización de información de reservas existentes
 * - Eliminación de reservas del sistema
 * - Gestión de la relación entre reservas y mesas
 * 
 * Funcionalidades principales:
 * - Gestión de horarios de reserva
 * - Asignación de mesas a las reservas
 * - Control de disponibilidad de mesas
 * - Mantenimiento del registro de reservas
 * 
 * Rutas disponibles:
 * - GET "/reserva" : Muestra todas las reservas
 * - GET "/reserva/nuevo" : Formulario de nueva reserva
 * - POST "/reserva/guardar" : Guarda/actualiza reserva
 * - GET "/reserva/editar/{id}" : Edita reserva existente
 * - GET "/reserva/eliminar/{id}" : Elimina reserva
 * 
 * @author RocoBytes
 * @version 1.0
 * @since 2024-30-11
 */


@Entity
@Table(name = "mesa")
public class mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numero;
    private String asientos;
    private boolean disponible;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mesa", cascade = CascadeType.ALL)
    private List<reserva> reserva;

    public mesa() {
    }

    

    public mesa(String asientos) {
        this.asientos = asientos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAsientos() {
        return asientos;
    }

    public void setAsientos(String asientos) {
        this.asientos = asientos;
    }

    public List<reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<reserva> reserva) {
        this.reserva = reserva;
    }



    public int getNumero() {
        return numero;
    }



    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    
}
