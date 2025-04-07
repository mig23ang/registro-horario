package registro.samtel.horas.models.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import registro.samtel.horas.models.entities.RegistroHora;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IRegistroHoraRepository extends JpaRepository<RegistroHora, Long> {

    // Buscar todos los registros de un usuario
    List<RegistroHora> findByUsuario_Id(String idUsuario);

    // Buscar registros de un usuario en una fecha específica
    List<RegistroHora> findByUsuario_IdAndFecha(String idUsuario, LocalDate fecha);

    // Buscar el último registro de entrada para un usuario en una fecha específica
    @Query("SELECT r FROM RegistroHora r WHERE r.usuario.id = :idUsuario AND r.fecha = :fecha ORDER BY r.horaEntrada DESC")
    Optional<RegistroHora> findUltimoRegistroPorUsuarioYFecha(String idUsuario, LocalDate fecha);

    // Verificar si ya existe un registro de entrada hoy
    boolean existsByUsuario_IdAndFecha(String idUsuario, LocalDate fecha);

    // Verificar si ya se registró la salida
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RegistroHora r WHERE r.id = :id AND r.horaSalida IS NOT NULL")
    boolean existsByIdAndHoraSalidaNotNull(Long id);
}
