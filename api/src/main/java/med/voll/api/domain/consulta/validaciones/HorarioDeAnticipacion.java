package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HorarioDeAnticipacion implements ValidadorDeConsultas {
    public void validar(DatosAgendarConsulta datos) {
        var ahora = LocalDateTime.now();
        var menosDe30min = datos.fecha().isBefore(ahora.plusMinutes(30));

        if (menosDe30min) {
            throw new ValidationException("La consulta debe ser agendada con al menos 30 minutos de anticipacion");
        }
    }
}
