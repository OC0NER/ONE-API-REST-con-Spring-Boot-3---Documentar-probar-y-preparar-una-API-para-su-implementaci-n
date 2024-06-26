package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoSinConsulta implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta datos) {
        var unaHoraAntes = datos.fecha().minusMinutes(59);
        var unaHoraDespues = datos.fecha().plusMinutes(59);

        var medicoConConsulta = consultaRepository.existsByMedicoIdAndFechaBetween(datos.idMedico(), unaHoraAntes, unaHoraDespues);

        if(medicoConConsulta) {
            throw new ValidationException("El médico ya tiene una consulta agendada en ese horario");
        }

    }
}
