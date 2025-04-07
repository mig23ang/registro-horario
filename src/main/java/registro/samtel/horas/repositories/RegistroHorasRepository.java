package registro.samtel.horas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.models.entities.RegistroHorasEntity;

import java.time.LocalDate;
import java.util.List;

public interface RegistroHorasRepository extends JpaRepository<RegistroHorasEntity, Long> {

    List<RegistroHorasEntity> findAllByUsuario_Id(Long idUsuario);

    List<RegistroHorasEntity> findByFecha(LocalDate fecha);
}
