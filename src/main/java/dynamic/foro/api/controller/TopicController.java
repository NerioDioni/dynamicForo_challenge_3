package dynamic.foro.api.controller;

import dynamic.foro.api.domain.curso.CursoDto;
import dynamic.foro.api.domain.curso.CursoRepository;
import dynamic.foro.api.domain.topico.*;
import dynamic.foro.api.domain.usuario.UsuarioDto;
import dynamic.foro.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public ResponseEntity<TopicoDto>registrarTopico(@RequestBody @Valid RegistroTopicoDto registro, UriComponentsBuilder uriComponentsBuilder){
        var curso=cursoRepository.findByNombreContains(registro.nombreCurso());
        var usuario=usuarioRepository.getReferenceById(Long.parseLong(registro.idUsuario()));
        Topico topico=new Topico(registro,curso,usuario);
        topicoRepository.save(topico);
        System.out.println(topico);
        var cursoDto=new CursoDto(topico.getCurso().getNombre(),
                topico.getCurso().getCategoria());
        var autorDto=new UsuarioDto(topico.getAutor().getId(),topico.getAutor().
                getNombre(),topico.getAutor().getEmail());
        var topicoDatos=new TopicoDto(topico.getId(),topico.getTitulo(),
                topico.getMensaje(),topico.getEstado().toString(),
                topico.getFechaCreacion().toString(),cursoDto,autorDto);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(topicoDatos);


    }
    @GetMapping
    public ResponseEntity<Page<ListadoTopicoDto>> listadoTopicos(
            @PageableDefault(size = 6) Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(topicoRepository.findByEstadoTrue(paginacion)
                .map(ListadoTopicoDto::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> retornaDatosTopico(@PathVariable Long id)throws RuntimeException {

            var topico=topicoRepository.getReferenceById(id);
            var curso=new CursoDto(topico.getCurso().getNombre(),
                    topico.getCurso().getCategoria());
            var autor=new UsuarioDto(topico.getAutor().getId(),topico.getAutor().
                    getNombre(),topico.getAutor().getEmail());
            var topicoDatos=new TopicoDto(topico.getId(),topico.getTitulo(),
                    topico.getMensaje(),topico.getEstado().toString(),
                    topico.getFechaCreacion().toString(),curso,autor);

            return ResponseEntity.ok(topicoDatos);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity cerrarTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.cerrarTopico();
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarMedico(@PathVariable Long id,
                                           @RequestBody @Valid RegistroTopicoDto actualizarTopicoDto) {
        var topico = topicoRepository.getReferenceById(id);
        var curso=cursoRepository.findByNombreContains(actualizarTopicoDto.nombreCurso());
        var autor=usuarioRepository.getReferenceById(Long.parseLong(actualizarTopicoDto.idUsuario()));
        topico.actualizarTopico(actualizarTopicoDto,curso,autor);

        var cursoDto=new CursoDto(curso.getNombre(), curso.getCategoria());
        var autorDto=new UsuarioDto(autor.getId(),autor.getNombre(),autor.getEmail());
        var topicoDatos=new TopicoDto(topico.getId(),topico.getTitulo(),
                topico.getMensaje(),topico.getEstado().toString(),
                topico.getFechaCreacion().toString(),cursoDto,autorDto);
        return ResponseEntity.ok(topicoDatos);
    }
}
