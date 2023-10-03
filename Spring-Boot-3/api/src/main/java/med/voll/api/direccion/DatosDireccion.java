package med.voll.api.direccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosDireccion(
    @NotBlank 
        String calle,
    @NotBlank 
        String distrito,
    @NotBlank 
        String ciudad,
    @NotNull 
        int numero,
    @NotBlank 
        String complemento) {
}
