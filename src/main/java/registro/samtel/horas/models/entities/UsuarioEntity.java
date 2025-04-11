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

    @NotBlank(message = "TIENES QUE COLOCAR EL NOMBRE, GRACIAS!")
    @Size(min = 3, max = 50, message = "El NOMBRE DE TENER ENTRE 3 Y 50 CARACTERES")
    @Column(nullable = false, length = 50)
    private  String nombre;

    @NotBlank(message = "TIENES QUE COLOCAR EL CORREO, GRACIAS!")
    @Email(message = "EL CORREO DEBE SER VALIDO, GRACIAS!")
    @Size(max = 50, message = "El CORREO NO DEBER EXCEDER LOS 50 CARACTERES")
    @Column(nullable = false, length = 50, unique = true)
    private  String correo;

    @NotBlank(message = "TIENES QUE COLOCARLE EL ROL, GRACIAS!")
    @Enumerated(EnumType.STRING) // Guardar enum como String en la base de datos
    @Column(nullable = false)
    private RolUsuario rol;


    @NotBlank(message = "DEBES COLOCAR LA CONTRASEÑA, GRACIAS!")
    @Size(min = 8, message = "lA CONTRASEÑA TIENE QUE TENER MINIMO 8 CARACTERES, GRACIAS!")
    private String password;

    @NotBlank(message = "EL ESTADO NO PUEDE SER NULO, GRACIAS!")
    @Column(nullable = false)
    private Boolean estado;

}