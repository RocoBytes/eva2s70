package cl.ipss.eva2s70.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad que representa una mesa en el sistema del restaurante Sabor Gourmet.
 * 
 * Esta clase modela las características y comportamientos de una mesa:
 * - Identificación única de cada mesa
 * - Número de mesa en el restaurante
 * - Capacidad de asientos
 * - Estado de disponibilidad
 * - Relación con las reservas asociadas
 * 
 * Características principales:
 * - Mapeo a tabla 'mesa' en la base de datos
 * - Generación automática de ID
 * - Relación OneToMany con la entidad Reserva
 * - Gestión de disponibilidad para reservas
 * 
 * Atributos principales:
 * - id: Identificador único
 * - numero: Número de mesa en el restaurante
 * - asientos: Capacidad de personas
 * - disponible: Estado actual de la mesa
 * - reserva: Lista de reservas asociadas
 * 
 * @author RocoBytes
 * @version 1.0
 * @since 2024-11-30
 */

@Entity
@Table(name = "reserva")
public class reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nombre;
    private String hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa")
    private mesa mesa;

    public reserva() {
    }

    public reserva(String nombre, String hora) {
        this.nombre = nombre;
        this.hora = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public mesa getMesa() {
        return mesa;
    }

    public void setMesa(mesa mesa) {
        this.mesa = mesa;
    }

}
