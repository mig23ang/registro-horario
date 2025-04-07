package registro.samtel.horas.services.contract;

import registro.samtel.horas.models.entities.RegistroHora;

import java.time.LocalDate;
import java.util.List;

public interface IRegistroHoraService {

    RegistroHora registrarEntrada(String idUsuario);

    RegistroHora registrarSalida(Long idRegistro);

    List<RegistroHora> obtenerRegistrosPorUsuario(String idUsuario);

    List<RegistroHora> obtenerRegistrosPorUsuarioYFecha(String idUsuario, LocalDate fecha);
}
