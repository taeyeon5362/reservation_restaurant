package Team2.youngcha.hellospring;

import Team2.youngcha.hellospring.repository.CustomerRepository;
import Team2.youngcha.hellospring.repository.MemberRepository;
import Team2.youngcha.hellospring.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public CustomerService memberService() {
        return new CustomerService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new CustomerRepository(em);
    }
}