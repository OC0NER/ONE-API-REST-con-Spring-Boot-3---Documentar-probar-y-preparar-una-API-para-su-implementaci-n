package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.*;
import med.voll.api.domain.consulta.validaciones.DatosCancelarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaConsultaService AgendarConsultaService;

    @Autowired
    private CancelarConsultaService cancelarConsultaService;

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos) {

        var response = AgendarConsultaService.agendar(datos);

        return  ResponseEntity.ok(response);
    }

    @DeleteMapping()
    @Transactional
    public ResponseEntity cancelarConsulta(@RequestBody @Valid DatosCancelarConsulta datos) {
        cancelarConsultaService.cancelarConsulta(datos);
        Consulta consulta = consultaRepository.getReferenceById(datos.id());
        return ResponseEntity.ok(new DatosDetalleCancelacion(consulta));
    }


}
