package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.consulta.MotivoDeCancelacion;

public record DatosCancelarConsulta(
        @NotNull
        Long id,
        @NotNull
        MotivoDeCancelacion motivoDeCancelacion
) {
}
