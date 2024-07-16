package dynamic.foro.api.domain.topico;

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
