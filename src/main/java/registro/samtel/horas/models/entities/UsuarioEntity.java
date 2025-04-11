package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank (message = "El nombre no puede estar vacío")
    @Column(nullable = false, length = 50)
    private  String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Email(message = "El correo no es válido")
    @Column(nullable = false, length = 50, unique = true)
    private  String correo;

    @NotNull(message = "El rol no puede ser Nulo")
    @Enumerated(EnumType.STRING) // Guardar enum como String en la base de datos
    @Column(nullable = false)
    private RolUsuario rol;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;


    @Column(nullable = false)
    private Boolean estado;

}
