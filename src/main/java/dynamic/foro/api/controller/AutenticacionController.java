package dynamic.foro.api.controller;

import dynamic.foro.api.domain.usuario.Usuario;
import dynamic.foro.api.domain.usuario.UsuarioAutenticacionDto;
import dynamic.foro.api.infra.security.DAtosJWTToken;
import dynamic.foro.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioAutenticacionDto usuarioAutenticacionDto) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuarioAutenticacionDto.email(),
                usuarioAutenticacionDto.clave());
        var usuarioAutenticado=authenticationManager.authenticate(authToken);
        var JWTtoken=tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
       return ResponseEntity.ok(new DAtosJWTToken(JWTtoken));
    }
}
