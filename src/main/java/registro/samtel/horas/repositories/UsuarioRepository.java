package registro.samtel.horas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.models.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
