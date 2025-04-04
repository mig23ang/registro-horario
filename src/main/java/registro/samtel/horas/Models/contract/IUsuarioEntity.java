package registro.samtel.horas.Models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.Models.entities.UsuarioEntity;

public interface IUsuarioEntity extends JpaRepository<UsuarioEntity, Long> {


}
