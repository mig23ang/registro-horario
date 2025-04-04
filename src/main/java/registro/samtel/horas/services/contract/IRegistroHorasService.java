package registro.samtel.horas.services.contract;

import registro.samtel.horas.models.entities.RegistroEntity;

public interface IRegistroHorasService {
    RegistroEntity crearRegistro(RegistroEntity registro);

    RegistroEntity consultarRegistroPorId(Long id);

}
