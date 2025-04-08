package registro.samtel.horas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.models.entities.RegistroHorasEntity;
import registro.samtel.horas.services.impl.RegistroHorasServiceImplImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class RegistroHorasController {

    private static Logger log = Logger.getLogger(String.valueOf(RegistroHorasController.class));

    @Autowired
    RegistroHorasServiceImplImpl registroHorasServiceImpl;

    /**
     * @ Body {RegistroEntity} metodo para crear registrar Horas
     */
    @PostMapping("/registro")
    public RegistroHorasEntity crearRegistro(@RequestBody RegistroHorasEntity registro) {
        log.info("Inicio metodo crearRegistro en RegistroHorasController");
        RegistroHorasEntity creado = registroHorasServiceImpl.crearRegistro(registro);
        log.info("Termina metodo crearRegistro en RegistroHorasController");
        return creado;
    }

    /**
     * @ Body {Long} metodo para consultar registro por id
     */
    @GetMapping("/registro/{id}")
    public RegistroHorasEntity consultarRegistroPorId(@PathVariable Long id) {
        log.info("Inicio metodo consultarRegistroPorId en RegistroHorasController");
        RegistroHorasEntity registro = registroHorasServiceImpl.consultarRegistroPorId(id);
        log.info("Termina metodo consultarRegistroPorId en RegistroHorasController");
        return registro;
    }

    /**
     * @ metodo para obtener todos los registros
     */
    @GetMapping("/registros/todos")
    public List<RegistroHorasEntity> consultarTodosRegistros() {
        log.info("Inicio metodo consultarTodosRegistros en RegistroHorasController");
        List<RegistroHorasEntity> registros = registroHorasServiceImpl.consultarTodosRegistros();
        log.info("Termina metodo consultarTodosRegistros en RegistroHorasController");
        return registros;
    }

    /**
     * @ metodo para obtener todos los registros horas de un usuario
     */
    @GetMapping("/registros/usuario/{idUsuario}")
    public List<RegistroHorasEntity> consultarTodosRegistrosUsuario(@PathVariable Long idUsuario) {
        log.info("Inicio metodo consultarTodosRegistrosUsuario en RegistroHorasController");
        List<RegistroHorasEntity> registrosUsuario = registroHorasServiceImpl.consultarTodosRegistrosUsuario(idUsuario);
        log.info("Termina metodo consultarTodosRegistrosUsuario en RegistroHorasController");
        return registrosUsuario;
    }

    /**
     * @ metodo para consultar estado del usuario y del registro
     */
    @GetMapping("registro/{id}/usuario/{idUsuario}")
    public ResponseEntity<Map<String, Boolean>> consultarEstadoUsuario(@PathVariable Long id, @PathVariable Long idUsuario) {
        log.info("Inicio metodo consultarEstadoUsuario en RegistroHorasController");
        Optional<Map<String, Boolean>> estado = registroHorasServiceImpl.consultarEstadoUsuario(id, idUsuario);

        if (estado.isPresent()) {
            log.info("Termina metodo consultarEstadoUsuario en RegistroHorasController con éxito");
            return ResponseEntity.ok(estado.get());
        } else {
            log.warning("No se encontró estado para registro con id: " + id + " y usuario id: " + idUsuario);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * @ Body {Long, estado} metodo para eliminar registro por id "cambiar estado"
     */
    @PatchMapping("/registro/{id}")
    public Boolean eliminarRegistroPorId(@PathVariable Long id, @RequestBody Boolean estado) {
        log.info("Inicio metodo eliminarRegistroPorId en RegistroHorasController");
        Boolean eliminado = registroHorasServiceImpl.eliminarRegistroPorId(id, estado);
        if (eliminado) {
            log.info("Registro con id " + id + " actualizado correctamente");
        } else {
            log.warning("No se pudo actualizar el registro con id " + id);
        }
        log.info("Termina metodo eliminarRegistroPorId en RegistroHorasController");
        return eliminado;
    }

    /**
     * @ metodo para consultar registros por rango de fechas
     */
    @GetMapping("/registro/fecha")
    public ResponseEntity<List<RegistroHorasEntity>> consultarRegistrosPorFecha(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        log.info("Inicio metodo consultarRegistrosPorFecha en RegistroHorasController. Rango: " + fechaInicio + " a " + fechaFin);
        List<RegistroHorasEntity> registros = registroHorasServiceImpl.consultarRegistrosPorFecha(fechaInicio, fechaFin);
        log.info("Termina metodo consultarRegistrosPorFecha en RegistroHorasController con " + registros.size() + " registros encontrados");
        return ResponseEntity.ok(registros);
    }
}

