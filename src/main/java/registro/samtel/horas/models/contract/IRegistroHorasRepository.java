package registro.samtel.horas.models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.models.entities.RegistroHorasEntity;

import java.util.List;
import java.util.Optional;


public interface IRegistroHorasRepository extends JpaRepository<RegistroHorasEntity, Long> {

    //crear metodos para la consulta de la base de datos
    List<RegistroHorasEntity> findByUsuarioId(Long idUsuario);

    Optional<RegistroHorasEntity> findByIdAndUsuarioId(Long id, Long idUsuario);

}
