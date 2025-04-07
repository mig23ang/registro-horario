package registro.samtel.horas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.models.entities.RegistroHora;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.services.contract.IRegistroHoraService;
import registro.samtel.horas.services.impl.UsuarioServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RegistroHorasController {

    private static final Logger log = Logger.getLogger(RegistroHorasController.class.getName());

    private final IRegistroHoraService registroService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    public RegistroHorasController(IRegistroHoraService registroService) {
        this.registroService = registroService;
    }

    // --- Funcionalidades de Registro de Horas ---

    @PostMapping("/registro-horario/entrada/{idUsuario}")
    public ResponseEntity<RegistroHora> registrarEntrada(@PathVariable String idUsuario) {
        return ResponseEntity.ok(registroService.registrarEntrada(idUsuario));
    }

    @PutMapping("/registro-horario/salida/{id}")
    public ResponseEntity<RegistroHora> registrarSalida(@PathVariable Long id) {
        return ResponseEntity.ok(registroService.registrarSalida(id));
    }

    @GetMapping("/registro-horario/usuario/{idUsuario}")
    public ResponseEntity<List<RegistroHora>> obtenerPorUsuario(@PathVariable String idUsuario) {
        return ResponseEntity.ok(registroService.obtenerRegistrosPorUsuario(idUsuario));
    }

    @GetMapping("/registro-horario/usuario/{idUsuario}/fecha")
    public ResponseEntity<List<RegistroHora>> obtenerPorUsuarioYFecha(
            @PathVariable String idUsuario,
            @RequestParam(required = false) LocalDate fecha) {
        if (fecha == null) {
            fecha = LocalDate.now();
        }
        return ResponseEntity.ok(registroService.obtenerRegistrosPorUsuarioYFecha(idUsuario, fecha));
    }

    // --- Funcionalidades de Usuario ---

    @PostMapping("/v1/usuario")
    public UsuarioEntity crearUsuario(@RequestBody UsuarioEntity usuario) {
        log.info("Inicio metodo crearUsuario en RegistroHorasUsuarioController");
        usuarioService.crearUsuario(usuario);
        log.info("Termina metodo crearUsuario en RegistroHorasUsuarioController");
        return usuario;
    }

    @GetMapping("/v1/usuario/{id}")
    public UsuarioEntity consultarUsuarioPorId(@PathVariable Long id) {
        log.info("Inicio metodo consultarUsuarioPorId en RegistroHorasUsuarioController");
        UsuarioEntity usuario = usuarioService.consultarUsuarioPorId(id);
        log.info("Termina metodo consultarUsuarioPorId en RegistroHorasUsuarioController");
        return usuario;
    }

    @PutMapping("/v1/usuario/{id}")
    public UsuarioEntity editarUsuarioPorId(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        log.info("Inicio metodo editarUsuarioPorId en RegistroHorasUsuarioController");
        UsuarioEntity usuarioEditado = usuarioService.editarUsuarioPorId(id, usuario);
        log.info("Termina metodo editarUsuarioPorId en RegistroHorasUsuarioController");
        return usuarioEditado;
    }

    @PatchMapping("/v1/usuario/{id}")
    public Boolean eliminarUsuarioPorId(@PathVariable Long id, @RequestBody Boolean estado) {
        log.info("Inicio metodo eliminarUsuarioPorId en RegistroHorasUsuarioController");
        Boolean usuarioEliminado = usuarioService.eliminarUsuarioPorId(id, estado);
        log.info("Termina metodo eliminarUsuarioPorId en RegistroHorasUsuarioController");
        return usuarioEliminado;
    }

    @GetMapping("/v1/usuarios/todos")
    public List<UsuarioEntity> consultarTodosUsuarios() {
        log.info("Inicio metodo consultarTodosUsuarios en RegistroHorasUsuarioController");
        List<UsuarioEntity> usuarios = usuarioService.consultarTodosUsuarios();
        log.info("Termina metodo consultarTodosUsuarios en RegistroHorasUsuarioController");
        return usuarios;
    }
}
