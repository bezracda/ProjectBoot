package com.projectboot.ProjectBoot.UserDao;

import com.projectboot.ProjectBoot.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao implements UserDaoInt {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public User show(int id) {
        User userId = entityManager.find(User.class, id);
        return userId;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User userUpDate) {
        User user = show(id);
        user.setName(userUpDate.getName());
        user.setLevel(userUpDate.getLevel());
    }

    @Override
    public void delete(int id) {
        User user = show(id);
        entityManager.remove(user);
    }

}
