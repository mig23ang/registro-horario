package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 3,max= 12, message = "El nombre es necesario")
    @NotBlank(message = "solo su primer nombre")

    private  String nombre;

    @Column(nullable = false, length = 50, unique = true)
    @Email(message = "El correo deve ser valido")
    @NotBlank(message = "Correo de la empresa")
    private  String correo;

    @Enumerated(EnumType.STRING) // Guardar enum como String en la base de datos
    @Column(nullable = false)
    private RolUsuario rol;

    @NotBlank
    private String password;

    @Column(nullable = false)
    private Boolean estado;

}
