package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validaciones.DatosCancelarConsulta;
import med.voll.api.domain.consulta.validaciones.ValidadorDeCancelacionDeConsulta;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelarConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorDeCancelacionDeConsulta> validadorCancelamiento;

    public void cancelarConsulta(DatosCancelarConsulta datos) {
        if(!consultaRepository.existsById(datos.id())) {
            throw new ValidacionDeIntegridad("No se encuentra éste ID de consulta");
        }

        validadorCancelamiento.forEach(v -> v.validar(datos));

        var consulta = consultaRepository.getReferenceById(datos.id());
        consulta.cancelarConsulta(datos.motivoDeCancelacion());
    }
}

