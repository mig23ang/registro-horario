package registro.samtel.horas.services.contract;

import registro.samtel.horas.models.entities.RegistroEntity;

import java.util.List;

public interface IRegistroHorasService {
    RegistroEntity crearRegistro(RegistroEntity registro);

    RegistroEntity consultarRegistroPorId(Long id);

    List<RegistroEntity> consultarTodosRegistros();

}
