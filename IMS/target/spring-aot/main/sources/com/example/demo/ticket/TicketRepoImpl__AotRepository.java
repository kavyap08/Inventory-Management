package com.example.demo.ticket;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link TicketRepo}.
 */
@Generated
public class TicketRepoImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public TicketRepoImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link TicketRepo#findByAssignedTo(java.lang.String)}.
   */
  public List<Ticket> findByAssignedTo(String assignedTo) {
    String queryString = "SELECT t FROM Ticket t WHERE t.assignedTo = :assignedTo";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("assignedTo", assignedTo);

    return (List<Ticket>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link TicketRepo#findByAssignedToAndStatus(java.lang.String,java.lang.String)}.
   */
  public List<Ticket> findByAssignedToAndStatus(String assignedTo, String status) {
    String queryString = "SELECT t FROM Ticket t WHERE t.assignedTo = :assignedTo AND t.status = :status";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("assignedTo", assignedTo);
    query.setParameter("status", status);

    return (List<Ticket>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link TicketRepo#findByAssignedToIsNull()}.
   */
  public List<Ticket> findByAssignedToIsNull() {
    String queryString = "SELECT t FROM Ticket t WHERE t.assignedTo IS NULL";
    Query query = this.entityManager.createQuery(queryString);

    return (List<Ticket>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link TicketRepo#findByAssignedToIsNullAndStatus(java.lang.String)}.
   */
  public List<Ticket> findByAssignedToIsNullAndStatus(String status) {
    String queryString = "SELECT t FROM Ticket t WHERE t.assignedTo IS NULL AND t.status = :status";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("status", status);

    return (List<Ticket>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link TicketRepo#findByStatus(java.lang.String)}.
   */
  public List<Ticket> findByStatus(String status) {
    String queryString = "SELECT t FROM Ticket t WHERE t.status = :status";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("status", status);

    return (List<Ticket>) query.getResultList();
  }
}
