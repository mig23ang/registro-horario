package registro.samtel.horas.models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.models.entities.RegistroEntity;

import java.util.List;
import java.util.Optional;


public interface IRegistroHorasRepository extends JpaRepository<RegistroEntity, Long> {

    //crear metodos para la consulta de la base de datos
    List<RegistroEntity> findByUsuarioId(Long idUsuario);

    Optional<RegistroEntity> findByIdAndUsuarioId(Long id, Long idUsuario);

}
