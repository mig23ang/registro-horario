package registro.samtel.horas.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.samtel.horas.controller.RegistroHorasController;
import registro.samtel.horas.models.contract.IUsuarioEntity;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.services.contract.IUsuarioServiceImpl;
import registro.samtel.horas.utils.exceptions.UsuarioNoEncontradoException;

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
    public UsuarioEntity obtenerUsuarioPorId(Long id) {
        log.info("Inicio metodo obtenerUsuarioPorId en UsuarioServiceImpl");
        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(id);
        if (usuarioEntity.isEmpty()) {
            log.warning("No se encontro usuario con id: " + id);

            throw new UsuarioNoEncontradoException("No se encontro usuario con id: " + id + " en la base de datos");
        }
        log.info("Termina metodo obtenerUsuarioPorId en UsuarioServiceImpl");
        return usuarioEntity.get();
    }


}
