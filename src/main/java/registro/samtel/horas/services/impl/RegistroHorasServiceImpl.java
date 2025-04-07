package registro.samtel.horas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.samtel.horas.models.contract.IRegistroHorasRepository;
import registro.samtel.horas.models.entities.RegistroHorasEntity;
import registro.samtel.horas.services.contract.IRegistroHorasService;
import registro.samtel.horas.utils.exceptions.UsuarioNoEncontradoException;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

@Service
public class RegistroHorasServiceImpl implements IRegistroHorasService {

    private static Logger log = Logger.getLogger(String.valueOf(RegistroHorasServiceImpl.class));

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
        log.info("Inicio metodo consultarRegistroPorId en UsuarioServiceImpl");
        Optional<RegistroHorasEntity> registroEntity = registroHorasRepository.findById(id);
        if (registroEntity.isEmpty()) {
            log.warning("No se encontro el registro con id: " + id);

            throw new UsuarioNoEncontradoException("No se encontro registro con id: " + id + " en la base de datos");
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
            throw new UsuarioNoEncontradoException("No se encontraron registros en la base de datos");
        }
        log.info("Termina metodo consultarTodosregistros en RegistroServiceImpl");
        return registros;
    }

    @Override
    public List<RegistroHorasEntity> consultarTodosRegistrosUsuario(Long idUsuario) {
       log.info("Inicio metodo consultarTodosRegistrosUsuario en RegistroServiceImpl");
       List<RegistroHorasEntity> registrosUsuarios = registroHorasRepository.findByUsuarioId(idUsuario);
        if (registrosUsuarios.isEmpty()) {
            log.warning("No se encontraron registros de usuarios en la base de datos");
            throw new UsuarioNoEncontradoException("No se encontraron registros de usuarios en la base de datos");
        }
        log.info("Termina metodo consultarTodosregistrosUsuario en RegistroServiceImpl");
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
        log.warning("No se encontro el registro con id: " + id + " y usuario id: " + idUsuario);
        return Optional.empty();
    }

    @Override
    public Boolean eliminarRegistroPorId(Long id, Boolean estado) {
        log.info("Inicio metodo eliminarRegistroPorId en RegistroServiceImpl");
        Optional<RegistroHorasEntity> registroEntity = registroHorasRepository.findById(id);
        if (registroEntity.isPresent()) {
            // editar su estado a inactivo
            RegistroHorasEntity registro = registroEntity.get();
            registro.setEstadoRegistro(estado);
            registroHorasRepository.save(registro); // 🔹 Guardar los cambios en la BD
            log.info("Termina metodo eliminarRegistroPorId en RegistroServiceImpl");
            return true;
        }
        log.warning("No se pudo cambiar el estado del registro " + id);
        return false;
    }

    @Override
    public List<RegistroHorasEntity> consultarRegistrosPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        log.info("Inicio metodo consultarRegistrosPorFecha en RegistroServiceImpl");
        List<RegistroHorasEntity> registros = registroHorasRepository.consultarRegistrosPorFecha(fechaInicio, fechaFin);
        if (registros.isEmpty()) {
            log.warning("No se encontraron registros entre " + fechaInicio + " y " + fechaFin);
        } else {
            log.info("Se encontraron " + registros.size() + " registros entre " + fechaInicio + " y " + fechaFin);
        }
        log.info("Termina metodo consultarRegistrosPorFecha en RegistroServiceImpl");
        return registros;
    }



}
