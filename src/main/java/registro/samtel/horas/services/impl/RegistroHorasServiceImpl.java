package registro.samtel.horas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registro.samtel.horas.models.contract.IRegistroHorasRepository;
import registro.samtel.horas.models.entities.RegistroEntity;
import registro.samtel.horas.models.entities.UsuarioEntity;
import registro.samtel.horas.services.contract.IRegistroHorasService;
import registro.samtel.horas.utils.exceptions.UsuarioNoEncontradoException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RegistroHorasServiceImpl implements IRegistroHorasService {

    private static Logger log = Logger.getLogger(String.valueOf(RegistroHorasServiceImpl.class));

    @Autowired
    private IRegistroHorasRepository registroHorasRepository;

    @Override
    public RegistroEntity crearRegistro(RegistroEntity registro) {
        log.info("Inicio metodo registroHoras en RegistroServiceImpl");
        RegistroEntity registroHoras = registroHorasRepository.save(registro);
        log.info("Termina metodo registroHoras en RegistroServiceImpl");
        return registroHoras;
    }

    @Override
    public RegistroEntity consultarRegistroPorId(Long id) {
        log.info("Inicio metodo consultarRegistroPorId en UsuarioServiceImpl");
        Optional<RegistroEntity> registroEntity = registroHorasRepository.findById(id);
        if (registroEntity.isEmpty()) {
            log.warning("No se encontro el registro con id: " + id);

            throw new UsuarioNoEncontradoException("No se encontro registro con id: " + id + " en la base de datos");
        }
        log.info("Termina metodo consultarRegistroPorId en RegistroServiceImpl");
        return registroEntity.get();
    }

    @Override
    public List<RegistroEntity> consultarTodosRegistros() {
        log.info("Inicio metodo consultarTodosRegistros en RegistroServiceImpl");
        List<RegistroEntity> registros = registroHorasRepository.findAll();
        if (registros.isEmpty()) {
            log.warning("No se encontraron registros en la base de datos");
            throw new UsuarioNoEncontradoException("No se encontraron registros en la base de datos");
        }
        log.info("Termina metodo consultarTodosregistros en RegistroServiceImpl");
        return registros;
    }
}
