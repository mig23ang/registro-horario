package registro.samtel.horas.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registro")
public class RegistroHorasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha de registro es obligatoria")
    @Column(name = "fecha_de_registro", nullable = false)
    private LocalDate fechaDeRegistro;

    @NotBlank(message = "La hora de entrada es obligatoria")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Formato de horaEntrada inválido. Debe ser HH:mm")
    @Column(name = "hora_entrada", nullable = false)
    private String horaEntrada;

    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Formato de horaSalida inválido. Debe ser HH:mm")
    @Column(name = "hora_salida")
    private String horaSalida;

    @NotNull(message = "El estado del registro es obligatorio")
    @Column(name = "estado_registro", nullable = false)
    private Boolean estadoRegistro;

    @NotNull(message = "El usuario es obligatorio")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;
}
