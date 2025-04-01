package registro.samtel.horas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.services.impl.UsuarioServiceImpl;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class RegistroHorasController {

    private static Logger log = Logger.getLogger(String.valueOf(RegistroHorasController.class));

    @Autowired
    UsuarioServiceImpl usuarioService;

    /**
     * @ Body {UsuarioEntity} metodo para crear usuario
     * */
    @PostMapping
    public UsuarioEntity crearUsuario(@RequestBody UsuarioEntity usuario) {
        log.info("Inicio metodo crearUsuario en RegistroHorasController");
        usuarioService.crearUsuario(usuario);
        log.info("Termina metodo crearUsuario en RegistroHorasController");
        return usuario;
    }

}
