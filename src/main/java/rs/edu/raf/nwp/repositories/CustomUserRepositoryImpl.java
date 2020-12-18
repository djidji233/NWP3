package rs.edu.raf.nwp.repositories;

import rs.edu.raf.nwp.model.Group;
import rs.edu.raf.nwp.model.User;
import rs.edu.raf.nwp.model.UserType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomUserRepositoryImpl  implements CustomUserRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> searchUsers(String ime, String prezime, UserType tip, Group grupa) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        Root<User> root = query.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(root.get("ime"), ime));
        predicates.add(criteriaBuilder.equal(root.get("prezime"), prezime));
        predicates.add(criteriaBuilder.equal(root.get("tip"), tip));
        predicates.add(criteriaBuilder.equal(root.get("grupa"), grupa));

        query.select(root).where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(query).getResultList();
    }
}
