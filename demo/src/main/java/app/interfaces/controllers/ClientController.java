package app.interfaces.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @GetMapping("/ping")
    public String ping() {
        return "Conexión exitosa. ¡La API está funcionando y conectada a la base de datos!";
    }
}
