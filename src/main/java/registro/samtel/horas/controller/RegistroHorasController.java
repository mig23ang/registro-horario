package registro.samtel.horas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.models.entities.RegistroHorasEntity;
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
    public RegistroHorasEntity crearRegistro(@RequestBody RegistroHorasEntity registro) {
        log.info("Inicio metodo crearRegistro en RegistroHorasController");
        registroHorasServiceImpl.crearRegistro(registro);
        log.info("Termina metodo crearRegistro en RegistroHorasController");
        return registro;
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
        List<RegistroHorasEntity> Registros = registroHorasServiceImpl.consultarTodosRegistros();
        log.info("Termina metodo consultarTodosRegistros en RegistroHorasController");
        return Registros;
    }

    /**
     * @ metodo para obtener todos los registros horas de un usuario
     */
    @GetMapping("/registros/usuario/{idUsuario}")
    public List<RegistroHorasEntity> consultarTodosRegistrosUsuario(@PathVariable Long idUsuario) {
        log.info("Inicio metodo consultarTodosRegistrosUsuario en RegistroHorasController");
        List<RegistroHorasEntity> registrosUsuario = registroHorasServiceImpl.consultarTodosRegistrosUsuario(idUsuario);
        log.info("Termina metodo consultarTodosRegistrosUusuario en RegistroHorasController");
        return registrosUsuario;
    }

    // Por evaluar si dejamos este metodo o no, ya que el estado se puede consultar en registro Por Id
    @GetMapping("registro/{id}/usuario/{idUsuario}")
    public ResponseEntity<RegistroHorasEntity> consultarEstadoUsuario(@PathVariable Long id, @PathVariable Long idUsuario) {
        Optional<RegistroHorasEntity> registro = registroHorasServiceImpl.consultarEstadoUsuario(id, idUsuario);
        return registro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * @ Body {Long, estado} metodo para eliminar registro por id "cambiar estado"
     */
    @PatchMapping("/registro/{id}")
    public Boolean eliminarRegistroPorId(@PathVariable Long id, @RequestBody Boolean estado) {
        log.info("Inicio metodo eliminarRegistroPorId en RegistroHorasController");
        Boolean usuarioEliminado = registroHorasServiceImpl.eliminarRegistroPorId(id, estado);
        log.info("Termina metodo eliminarRegistroPorId en RegistroHorasController");
        return usuarioEliminado;
    }



}
