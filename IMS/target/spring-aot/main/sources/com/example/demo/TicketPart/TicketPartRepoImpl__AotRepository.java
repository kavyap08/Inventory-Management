package com.example.demo.TicketPart;

import com.example.demo.parts.Parts;
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
 * AOT generated JPA repository implementation for {@link TicketPartRepo}.
 */
@Generated
public class TicketPartRepoImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public TicketPartRepoImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link TicketPartRepo#findByTicket(com.example.demo.ticket.Ticket)}.
   */
  public List<TicketPart> findByTicket(Ticket ticket) {
    String queryString = "SELECT t FROM TicketPart t WHERE t.ticket = :ticket";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("ticket", ticket);

    return (List<TicketPart>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link TicketPartRepo#findByTicketAndPart(com.example.demo.ticket.Ticket,com.example.demo.parts.Parts)}.
   */
  public TicketPart findByTicketAndPart(Ticket ticket, Parts part) {
    String queryString = "SELECT t FROM TicketPart t WHERE t.ticket = :ticket AND t.part = :part";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("ticket", ticket);
    query.setParameter("part", part);

    return (TicketPart) convertOne(query.getSingleResultOrNull(), false, TicketPart.class);
  }
}
