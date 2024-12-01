package cl.ipss.eva2s70.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.eva2s70.models.reserva;
import cl.ipss.eva2s70.repositories.reservaRepository;





@Service
public class reservaService {

    @Autowired
    private reservaRepository reservaRepository;

    public List<reserva> listarTodas(){
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
