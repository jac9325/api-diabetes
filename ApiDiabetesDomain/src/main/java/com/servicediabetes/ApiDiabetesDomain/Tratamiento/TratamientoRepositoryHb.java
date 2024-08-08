package com.servicediabetes.ApiDiabetesDomain.Tratamiento;


//import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;




@Repository
public class TratamientoRepositoryHb {
    @PersistenceContext
    private EntityManager entityManager;

    public Tratamiento getTratamientoById(Long id){
        String hql = "SELECT t FROM Tratamiento t WHERE t.id_tratamiento = :id";
        Query query = entityManager.createQuery(hql, Tratamiento.class)
                        .setParameter("id", id);
        Tratamiento tratamiento = (Tratamiento) query.getSingleResult();
        return tratamiento;
    }

    public List<Tratamiento> getAllTratamientos(){
        String hql = "SELECT t FROM Tratamiento t";
        Query query = entityManager.createQuery(hql, Tratamiento.class);
        List<Tratamiento> tratamientos = query.getResultList();
        return tratamientos;
    }
    
    /*

    public List<Tratamiento> getAllTratamientosByUsuario(Long id){
        String hql = "SELECT t FROM Tratamiento t " +
                    "JOIN t.usuario u " +
                    "WHERE u.id_usuario = :id";
        Query query = entityManager.createQuery(hql, Tratamiento.class)
                        .setParameter("id", id);
        List<Tratamiento> tratamientos = query.getResultList();
        return tratamientos;
    }*/

    public List<Tratamiento> getAllTratamientosByTipo(String tipo){
        String hql = "SELECT t FROM Tratamiento t WHERE t.tipo = :tipo";
        Query query = entityManager.createQuery(hql, Tratamiento.class)
                        .setParameter("tipo", tipo);
        List<Tratamiento> tratamientos = query.getResultList();
        return tratamientos;
    }

    public List<Tratamiento> getAllTratamientosHabilitados(){
        String hql = "SELECT t FROM Tratamiento t WHERE t.estado = 1";
        Query query = entityManager.createQuery(hql, Tratamiento.class);
        List<Tratamiento> tratamientos = query.getResultList();
        return tratamientos;
    }
    
    public Tratamiento getTratamientoHabilitadoByIdUsuario(Long id) {
        try {
            String hql = "SELECT t.tratamiento FROM UsuarioTratamiento t WHERE t.usuario. id_usuario =: id and t.estado = 1";
            Query query = entityManager.createQuery(hql, Tratamiento.class)
                            .setParameter("id", id);
            Tratamiento tratamiento = (Tratamiento) query.getSingleResult();
            return tratamiento;
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
