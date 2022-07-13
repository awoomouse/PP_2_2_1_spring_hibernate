package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   @Transactional
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @Transactional
   public User getCarOwner(int series, String model) {
      Query query = sessionFactory.getCurrentSession().createQuery("from User where car.series=:seriesParam and car.model=:modelParam")
              .setParameter("seriesParam", series).setParameter("modelParam", model);
      return (User) query.stream().findAny().orElse(null);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
