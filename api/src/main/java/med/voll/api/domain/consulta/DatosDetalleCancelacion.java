package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DatosDetalleCancelacion(
        Long id,
        Long idPaciente,
        Long idMedico,
        LocalDateTime fecha,
        MotivoDeCancelacion motivoDeCancelacion,
        Boolean activo
) {
    public DatosDetalleCancelacion(Consulta consulta) {
        this(consulta.getId(), consulta.getPaciente().getId(), consulta.getMedico().getId(), consulta.getFecha(), consulta.getMotivoDeCancelacion(), consulta.getActivo());
    }
}
