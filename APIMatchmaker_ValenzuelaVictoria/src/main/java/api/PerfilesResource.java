/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package api;

import dtos.ProfileDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author victoria
 */
@Path("perfiles")
@RequestScoped
public class PerfilesResource {

    private static List<ProfileDTO> baseDeDatos = new ArrayList<>(); //es la base de datos de los perfiles

    @Context
    private UriInfo context;

    public PerfilesResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(
            @QueryParam("edad") int edad, 
            @QueryParam("pais") String pais, 
            @QueryParam("genero") String genero) {
        
        List<ProfileDTO> candidatos = new ArrayList<>();

        for (ProfileDTO p : baseDeDatos) {
            int coincidencias = 0;

            if (edad > 0 && p.getEdad() == edad) {
                coincidencias++;
            }
            if (pais != null && !pais.isEmpty() && pais.equalsIgnoreCase(p.getPais())) {
                coincidencias++;
            }
            if (genero != null && !genero.isEmpty() && genero.equalsIgnoreCase(p.getGenero())) {
                coincidencias++;
            }

            if (coincidencias >= 1) { 
                candidatos.add(p);
            }
        }

        if (candidatos.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No se encontraron perfiles").build();
        }
        
        Random rand = new Random();
        ProfileDTO perfilGanador = candidatos.get(rand.nextInt(candidatos.size()));
        
        return Response.ok(perfilGanador).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(ProfileDTO nuevoPerfil) {
        // Agregamos a la lista estática
        baseDeDatos.add(nuevoPerfil);
        return Response.ok(nuevoPerfil).build();
    }
}