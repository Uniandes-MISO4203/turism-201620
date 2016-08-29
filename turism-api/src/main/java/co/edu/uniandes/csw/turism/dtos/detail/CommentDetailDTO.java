/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.turism.dtos.detail;

import co.edu.uniandes.csw.turism.dtos.minimum.ClientDTO;
import co.edu.uniandes.csw.turism.dtos.minimum.CommentDTO;
import co.edu.uniandes.csw.turism.dtos.minimum.TripDTO;
import co.edu.uniandes.csw.turism.entities.CommentEntity;
import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author da.prieto1
 */
@XmlRootElement
public class CommentDetailDTO extends CommentDTO {

    @PodamExclude
    private TripDTO trip;

    @PodamExclude
    private ClientDTO client;

    public CommentDetailDTO() {
        super();
    }

    public CommentDetailDTO(CommentEntity entity) {
        super(entity);
        if (entity.getTrip() != null) {
            this.trip = new TripDTO(entity.getTrip());
        }
        if (entity.getClient() != null) {
            this.client = new ClientDTO(entity.getClient());
        }
    }

    @Override
    public CommentEntity toEntity() {
        CommentEntity entity = super.toEntity();
        if (this.getTrip() != null) {
            entity.setTrip(this.getTrip().toEntity());
        }
        if (this.getClient() != null) {
            entity.setClient(this.getClient().toEntity());
        }
        return entity;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

}