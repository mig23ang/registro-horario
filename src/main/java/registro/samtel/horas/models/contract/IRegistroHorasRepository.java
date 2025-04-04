package registro.samtel.horas.models.contract;


import org.springframework.data.jpa.repository.JpaRepository;
import registro.samtel.horas.models.entities.RegistroEntity;


public interface IRegistroRepository extends JpaRepository<RegistroEntity, Long> {

    //crear metodos para la consulta de la base de datos

}
