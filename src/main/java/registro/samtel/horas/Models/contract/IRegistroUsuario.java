package registro.samtel.horas.Models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.Models.entities.RegistroEntity;


public interface IRegistroUsuario extends JpaRepository<RegistroEntity, Long> {

    //crear metodos para la consulta de la base de datos

}
