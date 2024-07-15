package dynamic.foro.api.topico;

import jakarta.validation.constraints.NotBlank;

public record RegistroTopicoDto(
        @NotBlank
        String idUsuario,
        @NotBlank
        String mensaje,
        @NotBlank
        String nombreCurso,
        @NotBlank
        String titulo


) {
}
