/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.turism.ejbs;

import co.edu.uniandes.csw.turism.api.IClientLogic;
import co.edu.uniandes.csw.turism.api.ICommentLogic;
import co.edu.uniandes.csw.turism.api.ITripLogic;
import co.edu.uniandes.csw.turism.entities.ClientEntity;
import co.edu.uniandes.csw.turism.entities.CommentEntity;
import co.edu.uniandes.csw.turism.entities.TripEntity;
import co.edu.uniandes.csw.turism.persistence.CommentPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author da.prieto1
 */
public class CommentLogic implements ICommentLogic {

    @Inject
    private CommentPersistence persistence;

    @Inject
    private IClientLogic clientLogic;

    @Inject
    private ITripLogic tripLogic;

    @Override
    public int countComments() {
        return persistence.count();
    }

    @Override
    public List<CommentEntity> getCommentsByTrip(Long tripId) {
        TripEntity tripEntity = tripLogic.getTrip(tripId);
        return tripEntity.getComments();
    }

    @Override
    public List<CommentEntity> getCommentsByTrip(Integer page, Integer maxRecords, Long tripId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommentEntity> getCommentsByClient(Long clientId) {
        ClientEntity clientEntity = clientLogic.getClient(clientId);
        return clientEntity.getComments();
    }

    @Override
    public List<CommentEntity> getCommentsByClient(Integer page, Integer maxRecords, Long clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CommentEntity getComment(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CommentEntity createComment(Long clientId, Long tripId, CommentEntity entity) {
        ClientEntity client = clientLogic.getClient(clientId);
        entity.setClient(client);

        TripEntity trip = tripLogic.getTrip(tripId);
        entity.setTrip(trip);

        entity = persistence.create(entity);
        return entity;
    }

}