package registro.samtel.horas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.samtel.horas.models.contract.IRegistroHorasRepository;
import registro.samtel.horas.models.entities.RegistroHorasEntity;
import registro.samtel.horas.services.contract.IRegistroHorasServiceImpl;
import registro.samtel.horas.utils.exceptions.RegistroNoEncontradoException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class RegistroHorasServiceImplImpl implements IRegistroHorasServiceImpl {

    private static Logger log = Logger.getLogger(String.valueOf(RegistroHorasServiceImplImpl.class));

    @Autowired
    private IRegistroHorasRepository registroHorasRepository;

    @Override
    public RegistroHorasEntity crearRegistro(RegistroHorasEntity registro) {
        log.info("Inicio metodo registroHoras en RegistroServiceImpl");
        RegistroHorasEntity registroHoras = registroHorasRepository.save(registro);
        log.info("Termina metodo registroHoras en RegistroServiceImpl");
        return registroHoras;
    }

    @Override
    public RegistroHorasEntity consultarRegistroPorId(Long id) {
        log.info("Inicio metodo consultarRegistroPorId en RegistroServiceImpl");
        Optional<RegistroHorasEntity> registroEntity = registroHorasRepository.findById(id);
        if (registroEntity.isEmpty()) {
            log.warning("No se encontró el registro con id: " + id);
            throw new RegistroNoEncontradoException("No se encontró registro con id: " + id + " en la base de datos");
        }
        log.info("Termina metodo consultarRegistroPorId en RegistroServiceImpl");
        return registroEntity.get();
    }

    @Override
    public List<RegistroHorasEntity> consultarTodosRegistros() {
        log.info("Inicio metodo consultarTodosRegistros en RegistroServiceImpl");
        List<RegistroHorasEntity> registros = registroHorasRepository.findAll();
        if (registros.isEmpty()) {
            log.warning("No se encontraron registros en la base de datos");
            throw new RegistroNoEncontradoException("No se encontraron registros en la base de datos");
        }
        log.info("Termina metodo consultarTodosregistros en RegistroServiceImpl");
        return registros;
    }

    @Override
    public List<RegistroHorasEntity> consultarTodosRegistrosUsuario(Long idUsuario) {
        log.info("Inicio metodo consultarTodosRegistrosUsuario en RegistroServiceImpl");
        List<RegistroHorasEntity> registrosUsuarios = registroHorasRepository.findByUsuarioId(idUsuario);
        if (registrosUsuarios.isEmpty()) {
            log.warning("No se encontraron registros del usuario con ID: " + idUsuario);
            throw new RegistroNoEncontradoException("No se encontraron registros del usuario con ID: " + idUsuario);
        }
        log.info("Termina metodo consultarTodosRegistrosUsuario en RegistroServiceImpl");
        return registrosUsuarios;
    }

//    @Override
//    public Optional<RegistroHorasEntity> consultarEstadoUsuario(Long id, Long idUsuario) {
//        return registroHorasRepository.findByIdAndUsuarioId(id, idUsuario);
//    }
    @Override
    public Optional<Map<String, Boolean>> consultarEstadoUsuario(Long id, Long idUsuario) {
        log.info("Inicio metodo consultarEstadoUsuario en RegistroServiceImpl");
        Optional<RegistroHorasEntity> registroOpt = registroHorasRepository.findByIdAndUsuarioId(id, idUsuario);
        if (registroOpt.isPresent()) {
            RegistroHorasEntity registro = registroOpt.get();
            Map<String, Boolean> estado = new HashMap<>();
            estado.put("estadoUsuario", registro.getUsuario().getEstado());
            estado.put("estadoRegistro", registro.getEstadoRegistro());

            log.info("Termina metodo consultarEstadoUsuario en RegistroServiceImpl");
            return Optional.of(estado);
        }
        log.warning("No se encontró el registro con id: " + id + " y usuario id: " + idUsuario);
        return Optional.empty();
    }

    @Override
    public Boolean eliminarRegistroPorId(Long id, Boolean estado) {
        log.info("Inicio metodo eliminarRegistroPorId en RegistroServiceImpl");
        Optional<RegistroHorasEntity> registroEntity = registroHorasRepository.findById(id);
        if (registroEntity.isPresent()) {
            RegistroHorasEntity registro = registroEntity.get();
            registro.setEstadoRegistro(estado);
            registroHorasRepository.save(registro);
            log.info("Termina metodo eliminarRegistroPorId en RegistroServiceImpl");
            return true;
        }
        log.warning("No se pudo cambiar el estado del registro con ID: " + id);
        throw new RegistroNoEncontradoException("No se pudo cambiar el estado porque el registro con ID: " + id + " no existe");
    }

    @Override
    public List<RegistroHorasEntity> consultarRegistrosPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        log.info("Inicio metodo consultarRegistrosPorFecha en RegistroServiceImpl");
        List<RegistroHorasEntity> registros = registroHorasRepository.consultarRegistrosPorFecha(fechaInicio, fechaFin);
        if (registros.isEmpty()) {
            log.warning("No se encontraron registros entre " + fechaInicio + " y " + fechaFin);
            throw new RegistroNoEncontradoException("No se encontraron registros entre " + fechaInicio + " y " + fechaFin);
        }
        log.info("Se encontraron " + registros.size() + " registros entre " + fechaInicio + " y " + fechaFin);
        log.info("Termina metodo consultarRegistrosPorFecha en RegistroServiceImpl");
        return registros;
    }

}
