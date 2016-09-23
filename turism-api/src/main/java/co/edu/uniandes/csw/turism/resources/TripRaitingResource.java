/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.turism.resources;

import co.edu.uniandes.csw.auth.provider.StatusCreated;
import co.edu.uniandes.csw.turism.api.IRaitingLogic;
import co.edu.uniandes.csw.turism.api.ITripLogic;
import co.edu.uniandes.csw.turism.dtos.detail.CategoryDetailDTO;
import co.edu.uniandes.csw.turism.dtos.detail.RaitingDetailDTO;
import co.edu.uniandes.csw.turism.entities.RaitingEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author da.salinas3247
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TripRaitingResource {
    
    @Inject private ITripLogic tripLogic;
    
    @Inject private IRaitingLogic raitingLogic;
    
    @Context private HttpServletResponse response;
    
    
    /**
     * Convierte una lista de RaitingEntity a una lista de RaitingDetailDTO.
     *
     * @param entityList Lista de RaitingEntity a convertir.
     * @return Lista de RaitingDetailDTO convertida.
     */
    private List<RaitingDetailDTO> raitingListEntity2DTO(List<RaitingEntity> entityList){
        List<RaitingDetailDTO> list = new ArrayList<>();
        for (RaitingEntity entity : entityList) {
            list.add(new RaitingDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Convierte una lista de RaitingDetailDTO a una lista de RaitingEntity.
     *
     * @param dtos Lista de RaitingDetailDTO a convertir.
     * @return Lista de RaitingEntity convertida.
     * @generated
     */
    private List<RaitingEntity> raitingListDTO2Entity(List<RaitingDetailDTO> dtos){
        List<RaitingEntity> list = new ArrayList<>();
        for (RaitingDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    /**
     * Obtiene una colección de instancias de RaitingDetailDTO asociadas a una
     * instancia de Trip
     *
     * @param tripsId Identificador de la instancia de Trip
     * @return Colección de instancias de RaitingDetailDTO asociadas a la instancia de Trip
     * @generated
     */
    @GET
    public List<RaitingDetailDTO> listRaiting(@PathParam("tripsId") Long tripsId) {
        return raitingListEntity2DTO(tripLogic.listRaiting(tripsId));
    }
    
    /**
     * Obtiene una instancia de Raiting asociada a una instancia de Trip
     *
     * @param tripsId Identificador de la instancia de Trip
     * @param raitingId Identificador de la instancia de Raiting
     * @generated
     */
    @GET
    @Path("{raitingId: \\d+}")
    public RaitingDetailDTO getRaiting(@PathParam("tripsId") Long tripsId, @PathParam("raitingId") Long raitingId) {
        return new RaitingDetailDTO(tripLogic.getRaiting(tripsId, raitingId));
    }
    
    /**
     * Crea un Raiting para un Trip desde la vist de Item
     *
     * @param clientsId Identificador de la instancia de Client
     * @param itemsId Identificador de la instancia de Item que tiene un producto para Calificar
     * @param dto Objeto de RaitingDetailDTO con los datos nuevos
     * @return Instancia de RatitingDetailDTO que creada y asociada a un Trip
     */
    @POST
    @StatusCreated
    public RaitingDetailDTO createRatingTripFromItem(@PathParam("clientsId") Long clientsId, @PathParam("itemsId") Long itemsId, RaitingDetailDTO dto) {   
        return new RaitingDetailDTO(raitingLogic.createRaitingFromItem(clientsId, itemsId, dto.toEntity()));
    }
   
    
}