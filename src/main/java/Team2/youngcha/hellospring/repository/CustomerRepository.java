package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.domain.Income;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements MemberRepository {

    private final EntityManager em;

    public CustomerRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Customer save(Customer customer) {
        em.persist(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(String cid) {
        try {
            return Optional.ofNullable(em.find(Customer.class, cid));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public Optional<Customer> findByCid(Customer customer) {
        try {
            Customer result = em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                    .setParameter("cid", customer.getCid())
                    .getSingleResult();
            return Optional.ofNullable(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Customer> findEmailByCid(String cid) {
        try {
            Customer customer = em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                    .setParameter("cid", cid)
                    .getSingleResult();
            return Optional.ofNullable(customer);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("select c from Customer c", Customer.class)
                .getResultList();
    }

    @Override
    public Boolean validateUser(String id, String pwd) {
        try {
            Customer customer = em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                    .setParameter("cid", id)
                    .getSingleResult();
            return customer.getPsw().equals(pwd);
        } catch (NoResultException e) {
            return false;
        }
    }


    @Override
    public Boolean isAdmin(String id) {
        try {
            return em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                    .setParameter("cid", id)
                    .getSingleResult()
                    .getAdmin();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Customer> findNameByCid(String cid) {
        try {
            Customer result = em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                    .setParameter("cid", cid)
                    .getSingleResult();
            return Optional.ofNullable(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> findIdByNameAndPhoneNo(String name, String phoneNumber) {
        try {
            Customer result = em.createQuery("select c from Customer c where c.name=:name and c.phoneNumber=:phoneNumber", Customer.class)
                    .setParameter("name", name)
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();
            return Optional.ofNullable(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> findUserByPhoneNoAndNameAndCid(String phoneNumber, String name, String cid) {
        try {
            return Optional.ofNullable(em.createQuery("select c from Customer c where c.phoneNumber=:phoneNumber and c.name=:name and c.cid=:cid", Customer.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .setParameter("name", name)
                    .setParameter("cid", cid)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    @Modifying(clearAutomatically = true)
    public Boolean changePSW(String cid, String psw) {
        try {
            Customer target = em.createQuery("select c from Customer c where c.cid=:cid", Customer.class)
                    .setParameter("cid", cid)
                    .getSingleResult();
            target.setPsw(psw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Income> getFavoriteMenu() {
        List<Income> incomeList = em.createQuery("select i from Income i order by i.dishCount desc", Income.class)
                .getResultList();
        return incomeList;
    }
}