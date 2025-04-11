package registro.samtel.horas.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.models.entities.RegistroHorasEntity;
import registro.samtel.horas.services.impl.RegistroHorasServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class RegistroHorasController {

    private static final Logger log = Logger.getLogger(RegistroHorasController.class.getName());

    @Autowired
    private RegistroHorasServiceImpl registroHorasServiceImpl;

    @PostMapping("/registro")
    public ResponseEntity<RegistroHorasEntity> crearRegistro(@Valid @RequestBody RegistroHorasEntity registro) {
        log.info("Inicio método crearRegistro");
        RegistroHorasEntity creado = registroHorasServiceImpl.crearRegistro(registro);
        log.info("Registro creado exitosamente");
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/registro/{id}")
    public ResponseEntity<RegistroHorasEntity> consultarRegistroPorId(@PathVariable Long id) {
        log.info("Consultando registro por ID: " + id);
        RegistroHorasEntity registro = registroHorasServiceImpl.consultarRegistroPorId(id);
        return ResponseEntity.ok(registro);
    }

    @GetMapping("/registros/todos")
    public ResponseEntity<List<RegistroHorasEntity>> consultarTodosRegistros() {
        log.info("Consultando todos los registros");
        List<RegistroHorasEntity> registros = registroHorasServiceImpl.consultarTodosRegistros();
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/registros/usuario/{idUsuario}")
    public ResponseEntity<List<RegistroHorasEntity>> consultarTodosRegistrosUsuario(@PathVariable Long idUsuario) {
        log.info("Consultando registros del usuario ID: " + idUsuario);
        List<RegistroHorasEntity> registrosUsuario = registroHorasServiceImpl.consultarTodosRegistrosUsuario(idUsuario);
        return ResponseEntity.ok(registrosUsuario);
    }

    @GetMapping("/registro/{id}/usuario/{idUsuario}")
    public ResponseEntity<Map<String, Boolean>> consultarEstadoUsuario(
            @PathVariable Long id,
            @PathVariable Long idUsuario
    ) {
        log.info("Consultando estado de usuario en registro ID: " + id + " y usuario ID: " + idUsuario);
        Optional<Map<String, Boolean>> estado = registroHorasServiceImpl.consultarEstadoUsuario(id, idUsuario);
        return estado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/registro/{id}")
    public ResponseEntity<Boolean> eliminarRegistroPorId(
            @PathVariable Long id,
            @RequestBody Boolean estado
    ) {
        log.info("Actualizando estado del registro ID: " + id);
        boolean actualizado = registroHorasServiceImpl.eliminarRegistroPorId(id, estado);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/registro/fecha")
    public ResponseEntity<List<RegistroHorasEntity>> consultarRegistrosPorFecha(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin
    ) {
        log.info("Consultando registros entre " + fechaInicio + " y " + fechaFin);
        List<RegistroHorasEntity> registros = registroHorasServiceImpl.consultarRegistrosPorFecha(fechaInicio, fechaFin);
        return ResponseEntity.ok(registros);
    }
}
