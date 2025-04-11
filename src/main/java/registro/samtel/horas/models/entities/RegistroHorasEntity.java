package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "registro")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegistroHorasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "TIENES QUE COLOCAR LA FECHA, GRACIAS!")
    private String fechaDeRegistro;

    @NotBlank(message = "TIENES QUE COLOCAR LA HORA DE ENTRADA, GRACIAS!")
    private String horaEntrada;

    @NotBlank(message = "TIENES QUE COLOCAR LA HORA DE SALIDA, GRACIAS!")
    private String horaSalida;

    @NotBlank(message = "EL ESTADO NO PUEDE SER NULO, GRACIAS!")
    private Boolean estadoRegistro;

    @NotBlank(message = "DEBES COLOCAR EL ID DEL USUARIO, GRACIAS!")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

}