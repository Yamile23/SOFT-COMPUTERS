/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import dao.UsuariopruebaDao;
import dto.Usuarioprueba;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author josec
 */
@Path("/usuarios")
public class UsuarioService {
    
    
    // /api/usuario/login
    @Path("/login" )
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta login(Usuarioprueba datosLogin){
        try {
            UsuariopruebaDao dao = factory.FactoryDao.getFactoryInstance().getUsuariopruebaDao();
            Usuarioprueba obj = dao.get(datosLogin.getUsername());
            if(obj == null){
                return new Respuesta(false, "Nombre de Usuario y/o Contraseña incorrectos");
            }
            if(obj.getUsername().equals(datosLogin.getUsername())){
                String json = " { " +
                        "\"nombreCompleto\" : \"" + obj.getUsername()+ "\"," +
                        "\"username\" : \"" + obj.getUsername()+ "\"," +
                        "\"usuarioId\" : " + obj.getPassword()+ "" +
                        "}";               
                
                return new Respuesta(true, json);
            }else{
                return new Respuesta(false, "Nombre de Usuario y/o Contraseña incorrectos"); 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new Respuesta(false, "Ocurrió un error al verificar el usuario"); 
    }
    
    
}
