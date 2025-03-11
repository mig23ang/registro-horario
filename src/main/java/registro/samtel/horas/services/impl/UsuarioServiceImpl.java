package registro.samtel.horas.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import registro.samtel.horas.models.contract.IUsuarioRepository;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.services.contract.IUsuarioService;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public UsuarioEntity guardarUsuario(UsuarioEntity usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("El correo " + usuario.getCorreo() + " ya está registrado.");
        }
    }

    @Override
    public Optional<UsuarioEntity> actualizarUsuario(Long id, UsuarioEntity usuarioActualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setId(id);
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setRol(usuarioActualizado.getRol());
            usuario.setPassword(usuarioActualizado.getPassword());
            return usuarioRepository.save(usuario);
        });
    }

    @Override
    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
