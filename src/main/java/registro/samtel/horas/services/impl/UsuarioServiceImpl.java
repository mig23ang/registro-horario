package registro.samtel.horas.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.samtel.horas.models.contract.IUsuarioEntity;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.models.enums.RolUsuario;
import registro.samtel.horas.services.contract.IUsuarioServiceImpl;
import registro.samtel.horas.utils.exceptions.UsuarioNoEncontradoException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UsuarioServiceImpl implements IUsuarioServiceImpl {

    private static Logger log = Logger.getLogger(String.valueOf(UsuarioServiceImpl.class));
    @Autowired
    IUsuarioEntity usuarioRepository;

    @Override
    public UsuarioEntity crearUsuario(UsuarioEntity usuario) {
        log.info("Inicio metodo crearUsuario en UsuarioServiceImpl");
        // crear usuario
        UsuarioEntity usuarioNuevo = usuarioRepository.save(usuario);
        log.info("Termina metodo crearUsuario en UsuarioServiceImpl");
        return usuarioNuevo;
    }

    @Override
    public UsuarioEntity consultarUsuarioPorId(Long id) {
        log.info("Inicio metodo obtenerUsuarioPorId en UsuarioServiceImpl");
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
        if (usuarioEntity.isEmpty()) {
            log.warning("No se encontro usuario con id: " + id);

            throw new UsuarioNoEncontradoException("No se encontro usuario con id: " + id + " en la base de datos");
        }
        log.info("Termina metodo obtenerUsuarioPorId en UsuarioServiceImpl");
        return usuarioEntity.get();
    }

    @Override
    public UsuarioEntity editarUsuarioPorId(Long id, UsuarioEntity usuario) {
        log.info("Inicio metodo editarUsuarioPorId en UsuarioServiceImpl");
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
        if (usuarioEntity.isPresent() && usuarioEntity.get().getRol() != RolUsuario.SUPER_ADMIN) {
            UsuarioEntity usuarioActualizado = usuarioEntity.get(); // inicializar usuario
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setCorreo(usuario.getCorreo());
            usuarioActualizado.setRol(usuario.getRol());
            usuarioActualizado.setRol(usuario.getRol());
            usuarioActualizado.setEstado(usuario.getEstado());
            log.info("Termina metodo editarUsuarioPorId en UsuarioServiceImpl");
            return usuarioRepository.save(usuarioActualizado);
        }
        log.warning("Usuario con rol administrador no se puede editar: " + RolUsuario.SUPER_ADMIN);
        throw new RuntimeException("Usuario con rol administrador no se puede editar");
    }


    @Override
    public Boolean eliminarUsuarioPorId(Long id, Boolean estado) {
        log.info("Inicio metodo eliminarUsuarioPorId en UsuarioServiceImpl");

        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
        if (usuarioEntity.isPresent()) {
            // editar su estado a inactivo
            UsuarioEntity usuario = usuarioEntity.get();
            usuario.setEstado(estado);
            usuarioRepository.save(usuario); // 🔹 Guardar los cambios en la BD
            log.info("Termina metodo eliminarUsuarioPorId en UsuarioServiceImpl");
            return true;
        }
        log.warning("No se pudo cambiar el estado del usuario " + id);
        return false;
    }

    @Override
    public List<UsuarioEntity> consultarTodosUsuarios() {
        log.info("Inicio metodo consultarTodosUsuarios en UsuarioServiceImpl");
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            log.warning("No se encontraron usuarios en la base de datos");
            throw new UsuarioNoEncontradoException("No se encontraron usuarios en la base de datos");
        }
        log.info("Termina metodo consultarTodosUsuarios en UsuarioServiceImpl");
        return usuarios;
    }
}
