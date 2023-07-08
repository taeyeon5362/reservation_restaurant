package Team2.youngcha.hellospring.service;

import Team2.youngcha.hellospring.domain.Customer;
import Team2.youngcha.hellospring.domain.Income;
import Team2.youngcha.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomerService {

    private final MemberRepository memberRepository;

    public CustomerService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Boolean join(Customer customer) {
        try {
            validateDuplicateName(customer); // 중복회원 검증
            memberRepository.save(customer);
            return true;
        } catch(IllegalStateException e){
            return false;
        }
    }

    private void validateDuplicateName(Customer customer) {
        memberRepository.findByCid(customer)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    public String findEmailByCid(String cid){
        Optional<Customer> result = memberRepository.findEmailByCid(cid);
        if(result.isPresent())
            return result.get().getEmail();
        else
            return "0";
    }

    public String findNameByCid(String cid){
        Optional<Customer> result = memberRepository.findNameByCid(cid);
        if(result.isPresent())
            return result.get().getName();
        else return "";
    }
    public List<Customer> findMember() {
        return memberRepository.findAll();
    }

    public Boolean LogIn(String id, String psw) {
        return memberRepository.validateUser(id, psw);
    }

    public Boolean isAdmin(String id) {
        return memberRepository.isAdmin(id);
    }

    public static Boolean SToBConvert(String string) {
        return string.equals("Y");
    }

    public String isAlreadyJoined(String name, String phoneNumber) {
        Optional<Customer> result = memberRepository.findIdByNameAndPhoneNo(name, phoneNumber);
        if (result.isPresent()) return result.get().getCid();
        return "";
    }

    public Boolean findUserByPhoneNoAndNameAndCid(String phoneNo, String name, String cid) {
        Optional<Customer> result = memberRepository.findUserByPhoneNoAndNameAndCid(phoneNo, name, cid);
        return result.isPresent();
    }

    public Boolean changePSW(String cid, String psw) {
        return memberRepository.changePSW(cid, psw);
    }

    public Boolean checkIDDuplication(String cid){
        Optional<Customer> byId = memberRepository.findById(cid);
        return byId.isPresent();
    }

    public List<Income> getFavoriteMenu() {
        List<Income> incomeList = memberRepository.getFavoriteMenu();
        return incomeList;
    }
}