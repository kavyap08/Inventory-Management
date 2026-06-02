package com.example.demo;

import com.example.demo.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link HomeRepo}.
 */
@Generated
public class HomeRepoImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public HomeRepoImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link HomeRepo#findByUsernameAndPassword(java.lang.String,java.lang.String)}.
   */
  public User findByUsernameAndPassword(String username, String password) {
    String queryString = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("username", username);
    query.setParameter("password", password);

    return (User) convertOne(query.getSingleResultOrNull(), false, User.class);
  }
}
