package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(
    @NotBlank(message = "Este campo es obligatorio")
        String nombre,
    @NotBlank(message = "Este campo es obligatorio")
        @Email(message = "Formato del Email inválido")
            String email,
    @NotBlank(message = "Este campo es obligatorio") 
        String telefono,
    @NotBlank(message = "Este campo es obligatorio") 
        @Pattern(regexp = "\\d{4,6}", message = "Formato del documento inválido") 
            String documento,
    @NotNull(message = "Este campo es obligatorio") 
        Especialidad especialidad,
    @NotNull(message = "Este campo es obligatorio") 
        @Valid 
            DatosDireccion direccion) {
}
