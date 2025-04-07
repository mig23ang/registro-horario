package registro.samtel.horas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.samtel.horas.models.entities.RegistroHora;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.services.contract.IRegistroHoraService;
import registro.samtel.horas.utils.exceptions.RegistroNoEncontradoException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class RegistroHoraServiceImpl implements IRegistroHoraService {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    private final List<RegistroHora> registros = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public RegistroHora registrarEntrada(String idUsuario) {
        UsuarioEntity usuario = usuarioService.buscarUsuarioPorIdentificacion(idUsuario);
        if (usuario == null) {
            throw new RegistroNoEncontradoException("Usuario no encontrado con ID: " + idUsuario);
        }

        RegistroHora registro = new RegistroHora();
        registro.setId(String.valueOf(idGenerator.getAndIncrement()));
        registro.setFecha(LocalDate.now());
        registro.setHoraEntrada(String.valueOf(LocalTime.now()));
        registro.setUsuario(usuario);

        registros.add(registro);
        return registro;
    }

    @Override
    public RegistroHora registrarSalida(Long idRegistro) {
        RegistroHora registro = registros.stream()
                .filter(r -> r.getId().equals(String.valueOf(idRegistro)))
                .findFirst()
                .orElseThrow(() -> new RegistroNoEncontradoException("Registro no encontrado con ID: " + idRegistro));

        registro.setHoraSalida(String.valueOf(LocalTime.now()));
        return registro;
    }

    @Override
    public List<RegistroHora> obtenerRegistrosPorUsuario(String idUsuario) {
        return registros.stream()
                .filter(r -> r.getUsuario() != null && idUsuario.equals(r.getUsuario().getClass()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RegistroHora> obtenerRegistrosPorUsuarioYFecha(String idUsuario, LocalDate fecha) {
        return registros.stream()
                .filter(r -> r.getUsuario() != null
                        && idUsuario.equals(r.getUsuario().getClass())
                        && fecha.equals(r.getFecha()))
                .collect(Collectors.toList());
    }
}
