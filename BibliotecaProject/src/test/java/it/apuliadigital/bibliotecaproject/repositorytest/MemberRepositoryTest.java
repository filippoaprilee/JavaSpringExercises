package it.apuliadigital.bibliotecaproject.repositorytest;

import it.apuliadigital.bibliotecaproject.entity.MemberEntity;
import it.apuliadigital.bibliotecaproject.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        // Pulisce il repository prima di ogni test
        memberRepository.deleteAll();

        // Inserisce dei dati di prova
        MemberEntity member1 = new MemberEntity("John", "Doe", "john.doe@example.com", "123 Main St", "555-1234");
        MemberEntity member2 = new MemberEntity("Jane", "Smith", "jane.smith@example.com", "456 Oak St", "555-5678");

        memberRepository.saveAll(List.of(member1, member2));
    }

    @Test
    @Order(1)
    void testFindByName() {
        List<MemberEntity> foundMembers = memberRepository.findByName("John");

        assertEquals(1, foundMembers.size());
        assertEquals("Doe", foundMembers.get(0).getSurname());
    }

    @Test
    @Order(2)
    void testFindBySurname() {
        List<MemberEntity> foundMembers = memberRepository.findBySurname("Smith");

        assertEquals(1, foundMembers.size());
        assertEquals("Jane", foundMembers.get(0).getName());
    }

    @Test
    @Order(3)
    void testFindByEmail() {
        List<MemberEntity> foundMembers = memberRepository.findByEmail("john.doe@example.com");

        assertEquals(1, foundMembers.size());
        assertEquals("John", foundMembers.get(0).getName());
    }

    @Test
    @Order(4)
    void testFindByAddress() {
        List<MemberEntity> foundMembers = memberRepository.findByAddress("123 Main St");

        assertEquals(1, foundMembers.size());
        assertEquals("John", foundMembers.get(0).getName());
    }

    @Test
    @Order(5)
    void testFindByPhone() {
        List<MemberEntity> foundMembers = memberRepository.findByPhone("555-5678");

        assertEquals(1, foundMembers.size());
        assertEquals("Jane", foundMembers.get(0).getName());
    }

    @Test
    void testFindByNameAndSurname() {
        List<MemberEntity> foundMembers = memberRepository.findByNameAndSurname("John", "Doe");

        assertEquals(1, foundMembers.size());
        assertEquals("john.doe@example.com", foundMembers.get(0).getEmail());
    }

    @Test
    void testFindByNameAndSurname_NotFound() {
        List<MemberEntity> foundMembers = memberRepository.findByNameAndSurname("John", "Smith");

        assertEquals(0, foundMembers.size());
    }
}
