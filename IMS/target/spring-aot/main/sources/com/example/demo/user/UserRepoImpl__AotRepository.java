package com.example.demo.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link UserRepo}.
 */
@Generated
public class UserRepoImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public UserRepoImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link UserRepo#findByIdAndUsername(java.lang.Long,java.lang.String)}.
   */
  public User findByIdAndUsername(Long id, String username) {
    String queryString = "SELECT u FROM User u WHERE u.id = :id AND u.username = :username";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("id", id);
    query.setParameter("username", username);

    return (User) convertOne(query.getSingleResultOrNull(), false, User.class);
  }

  /**
   * AOT generated implementation of {@link UserRepo#findByRole(java.lang.String)}.
   */
  public List<User> findByRole(String role) {
    String queryString = "SELECT u FROM User u WHERE u.role = :role";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("role", role);

    return (List<User>) query.getResultList();
  }

  /**
   * AOT generated implementation of {@link UserRepo#findByUsername(java.lang.String)}.
   */
  public User findByUsername(String username) {
    String queryString = "SELECT u FROM User u WHERE u.username = :username";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("username", username);

    return (User) convertOne(query.getSingleResultOrNull(), false, User.class);
  }

  /**
   * AOT generated implementation of {@link UserRepo#findByUsernameAndPassword(java.lang.String,java.lang.String)}.
   */
  public User findByUsernameAndPassword(String username, String password) {
    String queryString = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("username", username);
    query.setParameter("password", password);

    return (User) convertOne(query.getSingleResultOrNull(), false, User.class);
  }
}
