package cl.ipss.eva2s70.models;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;
    private String hora;

    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa")
    private mesa mesa;

    public reserva() {
    }

    public reserva(String hora) {
        this.hora = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
