package com.example.demo.audit;

import com.example.demo.ticket.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link AuditRepo}.
 */
@Generated
public class AuditRepoImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public AuditRepoImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link AuditRepo#findByTicketOrderByCreatedAtAsc(com.example.demo.ticket.Ticket)}.
   */
  public List<Audit> findByTicketOrderByCreatedAtAsc(Ticket ticket) {
    String queryString = "SELECT a FROM Audit a WHERE a.ticket = :ticket ORDER BY a.createdAt asc";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("ticket", ticket);

    return (List<Audit>) query.getResultList();
  }
}
