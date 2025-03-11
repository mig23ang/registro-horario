package registro.samtel.horas.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.services.impl.UsuarioServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioEntity> guardarUsuario(@RequestBody UsuarioEntity usuario) {
        return ResponseEntity.status(201).body(usuarioService.guardarUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuarioActualizado) {
        return usuarioService.actualizarUsuario(id, usuarioActualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        if (usuarioService.eliminarUsuario(id)) {
            return ResponseEntity.ok("El usuario con ID " + id + " fue eliminado correctamente.");
        }
        return ResponseEntity.notFound().build();
    }

}


