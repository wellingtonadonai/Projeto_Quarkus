package org.wellington;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("/entity")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class EntityResource {

    private int numero = 1;

    @GET
    public int getNumero() {
        return numero;
    }

    @GET
    @Path("/diferente")
    public int getDiferentao(){
        return LocalDateTime.now().getNano();
    }

    @POST
    public void addNumero() {
        numero++;
    }

    @DELETE
    public void removeNumero(){
        numero--;
    }

    @PUT
    public void setNumero(int numero){
        this.numero = numero;
    }
}

