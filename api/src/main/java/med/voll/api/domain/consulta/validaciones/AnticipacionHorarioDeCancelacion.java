package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AnticipacionHorarioDeCancelacion implements ValidadorDeCancelacionDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void validar(DatosCancelarConsulta datos) {
        var consulta = consultaRepository.getReferenceById(datos.id());
        var ahora = LocalDateTime.now();
        var menosDe24Horas = consulta.getFecha().isBefore(ahora.plusHours(24));

        if (menosDe24Horas) {
            throw new ValidationException("Consulta solamente puede ser cancelada con antecedencia mínima de 24h!");
        }
    }
}
