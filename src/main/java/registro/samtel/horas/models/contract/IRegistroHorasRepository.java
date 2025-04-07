package registro.samtel.horas.models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import registro.samtel.horas.models.entities.RegistroHorasEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface IRegistroHorasRepository extends JpaRepository<RegistroHorasEntity, Long> {

    List<RegistroHorasEntity> findByUsuarioId(Long idUsuario);

    Optional<RegistroHorasEntity> findByIdAndUsuarioId(Long id, Long idUsuario);

    @Query("SELECT r FROM RegistroHorasEntity r WHERE r.fechaDeRegistro BETWEEN :fechaInicio AND :fechaFin")
    List<RegistroHorasEntity> consultarRegistrosPorFecha(LocalDate fechaInicio, LocalDate fechaFin);
}
