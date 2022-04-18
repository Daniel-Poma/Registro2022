/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package pe.company.ws;

import java.io.File;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import pe.company.dao.PersonaDAO;
import pe.company.vo.Persona;

/**
 * REST Web Service
 *
 * @author danip
 */
@Path("v1")
public class RedesSociales {

    @Context
    private UriInfo context;

    PersonaDAO personaDAO = new PersonaDAO();
    /**
     * Creates a new instance of RedesSociales
     */
    public RedesSociales() {
    }

    /**
     * Retrieves representation of an instance of pe.company.ws.RedesSociales
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RedesSociales
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @Path("persona")// rest/v1/persona?red=Facebook&limite=1
    @GET
    @Produces(MediaType.APPLICATION_JSON)  
    public List<Persona> buscarPersonas(@QueryParam("red") String nombreRedSocial, @QueryParam("limite") int limite){
        
        List<Persona> resultado = personaDAO.buscarPersonaPorRedSocial(nombreRedSocial, limite);
        
        File archivoResultado = new File(".\\persona.xml");
        
        try{
            JAXBContext context = JAXBContext.newInstance(Persona.class);
            Marshaller conversor = context.createMarshaller();
            conversor.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            if(resultado.size()> 0){
                Persona persona = resultado.get(0);
                conversor.marshal(persona, System.out);
                conversor.marshal(persona, archivoResultado);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return resultado;
    }
    
}
