package registro.samtel.horas.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @NotNull(message = "La fecha no puede ser nula")
    @Column(nullable = false)
    private LocalDate fechaDeRegistro;

    @NotBlank(message = "La hora de entrada no puede estar vacía")
    @Column(nullable = false)
    private String horaEntrada;

    @NotBlank(message = "La hora de salida no puede estar vacía")
    @Column(nullable = true)
    private String horaSalida;

    @Column(nullable = false)
    private Boolean estadoRegistro;

    @NotNull(message = "Debe existir un usuario para el registro")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

}
