package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import registro.samtel.horas.models.enums.RolUsuario;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, length = 50)
    private  String nombre;

    @Column(nullable = false, length = 50, unique = true)
    private  String correo;

    private RolUsuario rol;

    private String password;

    @Column(nullable = false)
    private Boolean estado;

}
