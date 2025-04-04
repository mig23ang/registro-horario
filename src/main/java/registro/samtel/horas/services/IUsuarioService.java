package registro.samtel.horas.models.services;

import registro.samtel.horas.models.entities.UsuarioEntity;
import java.util.List;

public interface IUsuarioService {
    List<UsuarioEntity> findAll();

}
