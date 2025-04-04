package registro.samtel.horas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.Models.entities.UsuarioEntity;
import registro.samtel.horas.services.impl.UsuarioServiceImpl;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController{

    private static Logger log = Logger.getLogger(String.valueOf(UsuarioController.class));

    @Autowired
    UsuarioServiceImpl usuarioService;

    @PostMapping("/crear")
    public UsuarioEntity crearUsuario(@RequestBody UsuarioEntity usuario){
        log.info("Inicia metodo crearUsuario en UsuarioController");
        usuarioService.crearUsuario(usuario);
        log.info("Termina metodo crearUsuario en UsuarioController");
        return usuario;
    }

    @GetMapping
    public List<UsuarioEntity> consultarTodosUsuarios(){
        log.info("Inicia metodo consultarTodosUsuarios en UsuarioController");
        List<UsuarioEntity> usuarios = usuarioService.consultarTodosUsuarios();
        log.info("Termina metodo consultarTodosUsuarios en UsuarioController");
        return usuarios;
    }

    @GetMapping("/{id}")
    public UsuarioEntity consultarUsuarioPorId(@PathVariable Long id){
        log.info("Inicio metodo consultarUsuarioPorId en UsuarioController");
        UsuarioEntity usuario = usuarioService.consultarUsuarioPorId(id);
        log.info("Termina metodo consultarUsuarioPorId en UsuarioController");
        return usuario;
    }

    @PutMapping("/editar/{id}")
    public UsuarioEntity editarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        log.info("Inicio metodo editarUsuario en UsuarioController");
        UsuarioEntity usuarioEditado = usuarioService.editarUsuarioPorId(id, usuario);
        log.info("Termina metodo editarUsuario en UsuarioController");
        return usuarioEditado;
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminarUsuario(@PathVariable Long id, @RequestBody Boolean estado){
        log.info("Inicio metodo editarUsuario en UsuarioController");
        Boolean usuarioEliiminado = usuarioService.eliminarUsuarioPorId(id, estado);
        log.info("Termina metodo editarUsuario en UsuarioController");
        return usuarioEliiminado;
    }
}
