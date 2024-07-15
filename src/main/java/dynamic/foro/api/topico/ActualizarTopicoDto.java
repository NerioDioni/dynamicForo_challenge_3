package dynamic.foro.api.topico;

public record ActualizarTopicoDto(
        String Id,
        String idUsuario,
        String mensaje,
        String Curso,
        String titulo
) {
}
