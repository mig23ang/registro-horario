package registro.samtel.horas.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.samtel.horas.models.contract.IUsuarioEntity;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.services.contract.IUsuarioServiceImpl;

@Service
public class UsuarioServiceImpl implements IUsuarioServiceImpl {

    @Autowired
    IUsuarioEntity usuarioRepository;

    @Override
    public UsuarioEntity crearUsuario(UsuarioEntity usuario) {
        // crear usuario
        UsuarioEntity usuarioNuevo = usuarioRepository.save(usuario);
        return usuarioNuevo;
    }
}
