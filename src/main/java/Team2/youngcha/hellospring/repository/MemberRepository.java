package Team2.youngcha.hellospring.repository;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.domain.Income;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(String cid);
    Optional<Customer> findByCid(Customer customer);
    List<Customer> findAll();
    Boolean validateUser(String id, String pwd);
    Boolean isAdmin(String id);
    Optional<Customer> findEmailByCid(String cid);
    Optional<Customer> findNameByCid(String cid);
    Optional<Customer> findIdByNameAndPhoneNo(String name, String email);
    Optional<Customer> findUserByPhoneNoAndNameAndCid(String phoneNo, String name, String cid);
    Boolean changePSW(String cid, String psw);
    List<Income> getFavoriteMenu();
}