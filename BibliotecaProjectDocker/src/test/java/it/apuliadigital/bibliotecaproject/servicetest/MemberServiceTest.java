package it.apuliadigital.bibliotecaproject.servicetest;

import it.apuliadigital.bibliotecaproject.entity.MemberEntity;
import it.apuliadigital.bibliotecaproject.repository.MemberRepository;
import it.apuliadigital.bibliotecaproject.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @MockBean
    MemberRepository memberRepository;

    private MemberEntity member1;
    private MemberEntity member2;
    private List<MemberEntity> memberList;

    @BeforeEach
    void setUp() {
        member1 = new MemberEntity("John", "Doe", "john.doe@example.com", "123 Main St", "555-1234");
        member2 = new MemberEntity("Jane", "Smith", "jane.smith@example.com", "456 Oak St", "555-5678");
        memberList = List.of(member1, member2);
    }

    @Test
    void testCreateMember() {
        when(memberRepository.save(member1)).thenReturn(member1);

        int createdMember = memberService.createMember(member1);

        assertEquals(0, createdMember);
        verify(memberRepository).save(member1);
    }

    @Test
    void testGetMemberById() {
        int memberId = 1;
        member1.setId(memberId);
        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member1));

        MemberEntity foundMember = memberService.getMemberById(memberId);

        assertEquals(member1, foundMember);
        verify(memberRepository).findById(memberId);
    }

    @Test
    void testGetAllMembers() {
        when(memberRepository.findAll()).thenReturn(memberList);

        List<MemberEntity> foundMembers = memberService.getAllMembers();

        assertEquals(memberList.size(), foundMembers.size());
        for (int i = 0; i < memberList.size(); i++) {
            assertEquals(memberList.get(i), foundMembers.get(i));
        }
        verify(memberRepository).findAll();
    }

    @Test
    void testUpdateMember() {
        int memberId = 1;
        member1.setId(memberId);
        when(memberRepository.existsById(memberId)).thenReturn(true);
        when(memberRepository.save(member1)).thenReturn(member1);

        boolean result = memberService.updateMember(memberId, member1);

        assertTrue(result);
        verify(memberRepository).save(member1);
    }

    @Test
    void testDeleteMember() {
        int memberId = 1;
        when(memberRepository.existsById(memberId)).thenReturn(true);

        boolean result = memberService.deleteMember(memberId);

        assertTrue(result);
        verify(memberRepository).deleteById(memberId);
    }

    @Test
    void testSearchMembers() {
        String name = "John";
        String surname = "Doe";
        when(memberRepository.findByNameAndSurname(name, surname)).thenReturn(List.of(member1));

        List<MemberEntity> foundMembers = memberService.searchMembers(name, surname, null, null, null);

        assertEquals(List.of(member1).size(), foundMembers.size());
        for (int i = 0; i < List.of(member1).size(); i++) {
            assertEquals(List.of(member1).get(i), foundMembers.get(i));
        }
        verify(memberRepository).findByNameAndSurname(name, surname);
    }
}