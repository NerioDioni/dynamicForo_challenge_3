package dynamic.foro.api.domain.topico;

import dynamic.foro.api.domain.curso.Curso;
import dynamic.foro.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String mensaje;
    private LocalDate fechaCreacion;
    private Boolean estado;
    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Curso curso;


    public Topico(RegistroTopicoDto registro,Curso curso,Usuario usuario) {
        this.titulo= registro.titulo();
        this.mensaje= registro.mensaje();
        this.fechaCreacion=LocalDate.now();
        this.estado =true;
        this.autor=usuario;
        this.curso=curso;


    }
    public void actualizarTopico(RegistroTopicoDto registro,Curso curso,Usuario usuario){
        if (registro.titulo() != null) {
            this.titulo= registro.titulo();
        }
        if (registro.mensaje() != null) {
            this.mensaje= registro.mensaje();
        }
        if (curso != null) {
            this.curso= curso;
        }
        if (usuario!= null) {
            this.autor= usuario;
        }

    }
    @Override
    public String toString() {
        return  "topico: \n"+
                "--titulo= " + titulo + "\n" +
                "--Mensaje = " + mensaje +"\n" +
                "--Activo = " + estado +"\n" +
                "--fechaCreacion = " + fechaCreacion +"\n"+
                 autor+""+
                curso+"\n"
                ;

    }
    public void cerrarTopico() {
        this.estado = false;
    }

}
