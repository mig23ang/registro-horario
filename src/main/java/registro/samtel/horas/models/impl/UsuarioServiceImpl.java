package registro.samtel.horas.models.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.models.repository.UsuarioRepository;
import registro.samtel.horas.models.services.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    // Agrega más métodos según tu interfaz
}
