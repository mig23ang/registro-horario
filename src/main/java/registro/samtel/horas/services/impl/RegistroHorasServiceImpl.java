package registro.samtel.horas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.samtel.horas.models.entities.RegistroHorasEntity;
import registro.samtel.horas.repositories.RegistroHorasRepository;
import registro.samtel.horas.services.contract.RegistroHorasService;
import registro.samtel.horas.utils.exceptions.RegistroNoEncontradoException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RegistroHorasServiceImpl implements RegistroHorasService {

    private static Logger log = Logger.getLogger(String.valueOf(RegistroHorasServiceImpl.class));

    @Autowired
    RegistroHorasRepository registroHorasRepository;

    @Override
    public RegistroHorasEntity crearRegistro(RegistroHorasEntity registro) {
        log.info("Inicio metodo crearRegistro en RegistroHorasServiceImpl");
        RegistroHorasEntity registroNuevo = registroHorasRepository.save(registro);
        log.info("Termina metodo crearUsuario en RegistroHorasServiceImpl");
        return registroNuevo;
    }

    @Override
    public List<RegistroHorasEntity> consultarTodosRegistros() {
        log.info("Inicio metodo consultarTodosRegistros en RegistroHorasServiceImpl");
        List<RegistroHorasEntity> registros = registroHorasRepository.findAll();
        if (registros.isEmpty()) {
            log.warning("No se encontraron usuarios en la base de datos");
            throw new RegistroNoEncontradoException("No se encontraron registros en la base de datos");
        }
        log.info("Termina metodo consultarTodosRegistros en RegistroHorasServiceImpl");
        return registros;
    }

    @Override
    public RegistroHorasEntity consultarRegistroPorId(Long id) {
        log.info("Inicio metodo consultarRegistroPorId en RegistroHorasServiceImpl");
        Optional<RegistroHorasEntity> RegistroHorasEntity = registroHorasRepository.findById(id);
        if (RegistroHorasEntity.isEmpty()) {
            log.warning("No se encontro usuario con id: " + id);

            throw new RegistroNoEncontradoException("No se encontro registro con id: " + id + " en la base de datos");
        }
        log.info("Termina metodo consultarRegistroPorId en RegistroHorasServiceImpl");
        return RegistroHorasEntity.get();
    }

    @Override
    public List<RegistroHorasEntity> consultarTodosRegistrosUsuario(Long idUsuario) {
        log.info("Inicio metodo consultarTodosRegistrosUsuario en RegistroHorasServiceImpl");
        List<RegistroHorasEntity> registroHoras = registroHorasRepository.findAllByUsuario_Id(idUsuario);
        if (registroHoras.isEmpty()) {
            log.warning("No se encontro usuario con id: " + idUsuario);

            throw new RegistroNoEncontradoException("No se encontro registro con id: " + idUsuario + " en la base de datos");
        }
        log.info("Termina metodo consultarTodosRegistrosUsuario en RegistroHorasServiceImpl");
        return registroHoras;
    }

    @Override
    public List<RegistroHorasEntity> consultarTodosRegistrosPorFecha(String fechaStr) {
        log.info("Inicio metodo consultarRegistrosPorFecha en RegistroHorasServiceImpl");
        LocalDate fecha = LocalDate.parse(fechaStr);
        List<RegistroHorasEntity> registroHoras = registroHorasRepository.findByFecha(fecha);
        if (registroHoras.isEmpty()) {
            log.warning("No se encontraron registros con fecha: " + fechaStr);
            throw new RegistroNoEncontradoException("No se encontraron registros con fecha: " + fechaStr + " en la base de datos");
        }
        log.info("Termina metodo consultarRegistrosPorFecha en RegistroHorasServiceImpl");
        return registroHoras;
    }

    /*
    @Override
    public RegistroHorasEntity consultarEstadoUsuario(Long id) {
        log.info("Inicio metodo consultarEstadoUsuario en RegistroHorasServiceImpl");
        Optional<RegistroHorasEntity> RegistroHorasEntity = registroHorasRepository.findById(id);
        if (RegistroHorasEntity.isEmpty()) {
            log.warning("No se encontro usuario con id: " + id);

            throw new UsuarioNoEncontradoException("No se encontro registro con id: " + id + " en la base de datos");
        }
        log.info("Termina metodo consultarEstadoUsuario en RegistroHorasServiceImpl");
        return RegistroHorasEntity.get();
    }
     */

    @Override
    public Boolean eliminarRegistro(Long id, Boolean estado) {
        log.info("Inicio metodo eliminarRegistro en UsuarioServiceImpl");

        Optional<RegistroHorasEntity> RegistroHorasEntity = registroHorasRepository.findById(id);
        if (RegistroHorasEntity.isPresent()) {
            RegistroHorasEntity registro = RegistroHorasEntity.get();
            registro.setEstado(estado);
            registroHorasRepository.save(registro); // 🔹 Guardar los cambios en la BD
            log.info("Termina metodo eliminarUsuarioPorId en UsuarioServiceImpl");
            return true;
        }
        log.warning("No se pudo cambiar el estado del usuario " + id);
        return false;
    }

}


