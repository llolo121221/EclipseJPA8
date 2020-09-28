package mx.com.gm.sga.datos;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.PersonaService;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;



@WebServlet("/personas")
public class PersonaServlet extends HttpServlet{
    
    @EJB
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Persona> personas = personaService.listaPersona();
        List<Usuario> usuarios = personaService.listaUsuario();
        System.out.println("personas:" + personas);
        request.setAttribute("personas", personas);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
}