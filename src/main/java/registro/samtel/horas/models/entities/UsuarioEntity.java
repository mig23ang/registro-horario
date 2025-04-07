package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import lombok.*;
import registro.samtel.horas.models.enums.RolUsuario;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Enumerated(EnumType.STRING) // Guardar enum como String en la base de datos
    @Column(nullable = false)
    private RolUsuario rol;

    private String password;

    @Column(nullable = false)
    private Boolean estado;
}
