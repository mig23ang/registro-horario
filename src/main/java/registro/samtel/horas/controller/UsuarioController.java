package registro.samtel.horas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.services.impl.UsuarioServiceImpl;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    private static Logger log = Logger.getLogger(String.valueOf(UsuarioController.class));

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    /**
     * @ Body {UsuarioEntity} metodo para crear usuario
     */
    @PostMapping("/usuario")
    public UsuarioEntity crearUsuario(@RequestBody UsuarioEntity usuario) {
        log.info("Inicio metodo crearUsuario en RegistroHorasController");
        usuarioServiceImpl.crearUsuario(usuario);
        log.info("Termina metodo crearUsuario en RegistroHorasController");
        return usuario;
    }

    /**
     * @ Body {Long} metodo para obtener usuario por id
     */
    @GetMapping("/usuario/{id}")
    public UsuarioEntity consultarUsuarioPorId(@PathVariable Long id) {
        log.info("Inicio metodo obtenerUsuarioPorId en RegistroHorasController");
        UsuarioEntity usuario = usuarioServiceImpl.consultarUsuarioPorId(id);
        log.info("Termina metodo obtenerUsuarioPorId en RegistroHorasController");
        return usuario;
    }

    /**
     * @ Body {Long id} metodo para editar usuario por id
     */
    @PutMapping("/usuario/{id}")
    public UsuarioEntity editarUsuarioPorId(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        log.info("Inicio metodo editarUsuarioPorId en RegistroHorasController");
        UsuarioEntity usuarioEditado = usuarioServiceImpl.editarUsuarioPorId(id, usuario);
        log.info("Termina metodo editarUsuarioPorId en RegistroHorasController");
        return usuarioEditado;
    }

    /**
     * @ Body {Long, estado} metodo para eliminar usuario por id "cambiar estado"
     */
    @PatchMapping("/usuario/{id}")
    public Boolean eliminarUsuarioPorId(@PathVariable Long id, @RequestBody Boolean estado) {
        log.info("Inicio metodo eliminarUsuarioPorId en RegistroHorasController");
        Boolean usuarioEliminado = usuarioServiceImpl.eliminarUsuarioPorId(id, estado);
        log.info("Termina metodo eliminarUsuarioPorId en RegistroHorasController");
        return usuarioEliminado;
    }

    /**
     * @ metodo para obtener todos los usuarios
     */
    @GetMapping("/usuarios/todos")
    public List<UsuarioEntity> consultarTodosUsuarios() {
        log.info("Inicio metodo consultarTodosUsuarios en RegistroHorasController");
        List<UsuarioEntity> usuarios = usuarioServiceImpl.consultarTodosUsuarios();
        log.info("Termina metodo consultarTodosUsuarios en RegistroHorasController");
        return usuarios;
    }
}
