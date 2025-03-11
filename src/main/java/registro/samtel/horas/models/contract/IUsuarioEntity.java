package registro.samtel.horas.models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.models.entities.UsuarioEntity;

import java.util.List;

public interface IUsuarioEntity extends JpaRepository<UsuarioEntity, Long> {


}
