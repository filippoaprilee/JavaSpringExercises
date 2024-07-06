package it.apuliadigital.bibliotecaproject.servicetest;

import it.apuliadigital.bibliotecaproject.entity.MemberEntity;
import it.apuliadigital.bibliotecaproject.repository.MemberRepository;
import it.apuliadigital.bibliotecaproject.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @MockBean
    MemberRepository memberRepository;

    @Test
    void testCreateMember() {
        MemberEntity member = new MemberEntity("John", "Doe", "john.doe@example.com", "123 Main St", "555-1234");
        when(memberRepository.save(member)).thenReturn(member);

        int createdMember = memberService.createMember(member);

        assertEquals(0, createdMember);
        verify(memberRepository).save(member);
    }

    @Test
    void testGetMemberById() {
        int memberId = 1;
        MemberEntity member = new MemberEntity("John", "Doe", "john.doe@example.com", "123 Main St", "555-1234");
        member.setId(memberId);
        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));

        MemberEntity foundMember = memberService.getMemberById(memberId);

        assertEquals(member, foundMember);
        verify(memberRepository).findById(memberId);
    }

    @Test
    void testGetAllMembers() {
        List<MemberEntity> members = List.of(
                new MemberEntity("John", "Doe", "john.doe@example.com", "123 Main St", "555-1234"),
                new MemberEntity("Jane", "Smith", "jane.smith@example.com", "456 Oak St", "555-5678")
        );
        when(memberRepository.findAll()).thenReturn(members);

        List<MemberEntity> foundMembers = memberService.getAllMembers();

        assertEquals(members.size(), foundMembers.size());
        for (int i = 0; i < members.size(); i++) {
            assertEquals(members.get(i), foundMembers.get(i));
        }
        verify(memberRepository).findAll();
    }

    @Test
    void testUpdateMember() {
        int memberId = 1;
        MemberEntity member = new MemberEntity("John", "Doe", "john.doe@example.com", "123 Main St", "555-1234");
        member.setId(memberId);
        when(memberRepository.existsById(memberId)).thenReturn(true);
        when(memberRepository.save(member)).thenReturn(member);

        boolean result = memberService.updateMember(memberId, member);

        assertEquals(true, result);
        verify(memberRepository).save(member);
    }

    @Test
    void testDeleteMember() {
        int memberId = 1;
        when(memberRepository.existsById(memberId)).thenReturn(true);

        boolean result = memberService.deleteMember(memberId);

        assertEquals(true, result);
        verify(memberRepository).deleteById(memberId);
    }

    @Test
    void testSearchMembers() {
        String name = "John";
        String surname = "Doe";
        List<MemberEntity> members = List.of(
                new MemberEntity(name, surname, "john.doe@example.com", "123 Main St", "555-1234")
        );
        when(memberRepository.findByNameAndSurname(name, surname)).thenReturn(members);

        List<MemberEntity> foundMembers = memberService.searchMembers(name, surname, null, null, null);

        assertEquals(members.size(), foundMembers.size());
        for (int i = 0; i < members.size(); i++) {
            assertEquals(members.get(i), foundMembers.get(i));
        }
        verify(memberRepository).findByNameAndSurname(name, surname);
    }
}