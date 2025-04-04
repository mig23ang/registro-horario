package registro.samtel.horas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.models.entities.RegistroEntity;
import registro.samtel.horas.services.impl.RegistroHorasServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class RegistroHorasController {

    private static Logger log = Logger.getLogger(String.valueOf(UsuarioController.class));

    @Autowired
    RegistroHorasServiceImpl registroHorasServiceImpl;

    /**
     * @ Body {RegistroEntity} metodo para crear registrar Horas
     */
    @PostMapping("/registro")
    public RegistroEntity crearRegistro(@RequestBody RegistroEntity registro) {
        log.info("Inicio metodo crearRegistro en RegistroHorasController");
        registroHorasServiceImpl.crearRegistro(registro);
        log.info("Termina metodo crearRegistro en RegistroHorasController");
        return registro;
    }

    /**
     * @ Body {Long} metodo para consultar registro por id
     */
    @GetMapping("/registro/{id}")
    public RegistroEntity consultarRegistroPorId(@PathVariable Long id) {
        log.info("Inicio metodo consultarRegistroPorId en RegistroHorasController");
        RegistroEntity registro = registroHorasServiceImpl.consultarRegistroPorId(id);
        log.info("Termina metodo consultarRegistroPorId en RegistroHorasController");
        return registro;
    }

    /**
     * @ metodo para obtener todos los registros
     */
    @GetMapping("/registros/todos")
    public List<RegistroEntity> consultarTodosRegistros() {
        log.info("Inicio metodo consultarTodosRegistros en RegistroHorasController");
        List<RegistroEntity> Registros = registroHorasServiceImpl.consultarTodosRegistros();
        log.info("Termina metodo consultarTodosRegistros en RegistroHorasController");
        return Registros;
    }

    /**
     * @ metodo para obtener todos los registros horas de un usuario
     */
    @GetMapping("/registros/usuario/{idUsuario}")
    public List<RegistroEntity> consultarTodosRegistrosUsuario(@PathVariable Long idUsuario) {
        log.info("Inicio metodo consultarTodosRegistrosUsuario en RegistroHorasController");
        List<RegistroEntity> registrosUsuario = registroHorasServiceImpl.consultarTodosRegistrosUsuario(idUsuario);
        log.info("Termina metodo consultarTodosRegistrosUusuario en RegistroHorasController");
        return registrosUsuario;
    }

    // Por evaluar si dejamos este metodo o no, ya que el estado se puede consultar en registro Por Id
    @GetMapping("registro/{id}/usuario/{idUsuario}")
    public ResponseEntity<RegistroEntity> consultarEstadoUsuario(@PathVariable Long id, @PathVariable Long idUsuario) {
        Optional<RegistroEntity> registro = registroHorasServiceImpl.consultarEstadoUsuario(id, idUsuario);
        return registro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}
