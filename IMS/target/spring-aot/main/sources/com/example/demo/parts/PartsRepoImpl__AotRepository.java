package com.example.demo.parts;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link PartsRepo}.
 */
@Generated
public class PartsRepoImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public PartsRepoImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link PartsRepo#findBySku(java.lang.String)}.
   */
  public Parts findBySku(String sku) {
    String queryString = "SELECT p FROM Parts p WHERE p.sku = :sku";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("sku", sku);

    return (Parts) convertOne(query.getSingleResultOrNull(), false, Parts.class);
  }

  /**
   * AOT generated implementation of {@link PartsRepo#findBySkuContainingIgnoreCaseOrPartNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(java.lang.String,java.lang.String,java.lang.String)}.
   */
  public List<Parts> findBySkuContainingIgnoreCaseOrPartNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(
      String sku, String partName, String category) {
    String queryString = "SELECT p FROM Parts p WHERE UPPER(p.sku) LIKE UPPER(:sku) ESCAPE '\\' OR UPPER(p.partName) LIKE UPPER(:partName) ESCAPE '\\' OR UPPER(p.category) LIKE UPPER(:category) ESCAPE '\\'";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("sku", "%%%s%%".formatted(sku != null ? sku.toUpperCase() : sku));
    query.setParameter("partName", "%%%s%%".formatted(partName != null ? partName.toUpperCase() : partName));
    query.setParameter("category", "%%%s%%".formatted(category != null ? category.toUpperCase() : category));

    return (List<Parts>) query.getResultList();
  }
}
