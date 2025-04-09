package registro.samtel.horas.models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.models.entities.UsuarioEntity;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


}
