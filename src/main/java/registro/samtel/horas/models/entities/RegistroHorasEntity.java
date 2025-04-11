package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Table(name = "registro")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegistroHorasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank

    private String fechaDeRegistro;

    @Pattern(
            regexp = "^(1[0-2]|0?[1-9])\\s?(am|pm)$",
            message = "La hora debe estar en formato 12 horas, como '1 am' o '12 pm'"
    )

    private String horaEntrada;
    @NotBlank
    @Pattern(
            regexp = "^(1[0-2]|0?[1-9])\\s?(am|pm)$",
            message = "La hora debe estar en formato 12 horas, como '1 am' o '12 pm'"
    )
    private String horaSalida;


    private Boolean estadoRegistro;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

}
