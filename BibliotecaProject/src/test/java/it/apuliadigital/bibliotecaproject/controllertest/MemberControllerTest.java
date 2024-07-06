package it.apuliadigital.bibliotecaproject.controllertest;

import it.apuliadigital.bibliotecaproject.controller.MemberController;
import it.apuliadigital.bibliotecaproject.entity.MemberEntity;
import it.apuliadigital.bibliotecaproject.exception.ErrorResponse;
import it.apuliadigital.bibliotecaproject.exception.MemberException;
import it.apuliadigital.bibliotecaproject.exception.SuccessResponse;
import it.apuliadigital.bibliotecaproject.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MemberControllerTest {

    @MockBean
    private MemberService memberService;

    @Autowired
    private MemberController memberController;

    @Test
    public void testCreateMember() {
        MemberEntity member = new MemberEntity();
        member.setName("John");
        member.setSurname("Doe");

        when(memberService.createMember(member)).thenReturn(1);

        SuccessResponse<Integer> successResponse = memberController.createMember(member);

        assertEquals(HttpStatus.CREATED.value(), successResponse.getStatusCode());
        assertEquals("Member aggiunto con successo", successResponse.getMessage());
        assertEquals(1, successResponse.getObject());

        verify(memberService, times(1)).createMember(member);
    }

    @Test
    public void testDeleteMember_Success() {
        int id = 1;

        when(memberService.deleteMember(id)).thenReturn(true);

        SuccessResponse<String> responseEntity = memberController.deleteMember(id);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Member rimosso con successo", responseEntity.getMessage());

        verify(memberService, times(1)).deleteMember(id);
    }

    @Test
    public void testDeleteMember_NotFound() {
        int id = 2;

        when(memberService.deleteMember(id)).thenReturn(false);

        SuccessResponse<String> responseEntity = memberController.deleteMember(id);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode());
        assertEquals("Member non trovato", responseEntity.getMessage());

        verify(memberService, times(1)).deleteMember(id);
    }

    @Test
    public void testUpdateMember_Success() {
        int id = 1;
        MemberEntity member = new MemberEntity();
        member.setName("Jane");
        member.setSurname("Doe");

        when(memberService.updateMember(id, member)).thenReturn(true);

        SuccessResponse<String> responseEntity = memberController.updateMember(id, member);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Member aggiornato con successo", responseEntity.getMessage());

        verify(memberService, times(1)).updateMember(id, member);
    }

    @Test
    public void testUpdateMember_NotFound() {
        int id = 2;
        MemberEntity member = new MemberEntity();
        member.setName("Anna");
        member.setSurname("Smith");

        when(memberService.updateMember(id, member)).thenReturn(false);

        SuccessResponse<String> responseEntity = memberController.updateMember(id, member);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode());
        assertEquals("Member non trovato", responseEntity.getMessage());

        verify(memberService, times(1)).updateMember(id, member);
    }

    @Test
    public void testFindMember_Success() {
        int id = 1;
        MemberEntity member = new MemberEntity();
        member.setId(id);
        member.setName("Paul");
        member.setSurname("Walker");

        when(memberService.getMemberById(id)).thenReturn(member);

        SuccessResponse<MemberEntity> responseEntity = memberController.findMember(id);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Member trovato con successo", responseEntity.getMessage());
        assertEquals(member, responseEntity.getObject());

        verify(memberService, times(1)).getMemberById(id);
    }

    @Test
    public void testFindMember_NotFound() {
        int id = 2;

        when(memberService.getMemberById(id)).thenReturn(null);

        SuccessResponse<MemberEntity> responseEntity = memberController.findMember(id);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode());
        assertEquals("Member non trovato", responseEntity.getMessage());

        verify(memberService, times(1)).getMemberById(id);
    }

    @Test
    public void testFindAllMembers() {
        MemberEntity member1 = new MemberEntity();
        member1.setId(1);
        member1.setName("Alice");
        member1.setSurname("Brown");

        MemberEntity member2 = new MemberEntity();
        member2.setId(2);
        member2.setName("Bob");
        member2.setSurname("Green");

        List<MemberEntity> members = Arrays.asList(member1, member2);

        when(memberService.getAllMembers()).thenReturn(members);

        SuccessResponse<List<MemberEntity>> responseEntity = memberController.findAllMembers();

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Members trovati con successo", responseEntity.getMessage());
        assertEquals(members, responseEntity.getObject());

        verify(memberService, times(1)).getAllMembers();
    }

    @Test
    public void testSearchMembers() {
        String name = "Alice";
        String surname = "Brown";

        MemberEntity member1 = new MemberEntity();
        member1.setId(1);
        member1.setName(name);
        member1.setSurname(surname);

        List<MemberEntity> members = List.of(member1);

        when(memberService.searchMembers(name, surname, null, null, null)).thenReturn(members);

        SuccessResponse<List<MemberEntity>> responseEntity = memberController.searchMembers(name, surname, null, null, null);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCode());
        assertEquals("Members trovati con successo", responseEntity.getMessage());
        assertEquals(members, responseEntity.getObject());

        verify(memberService, times(1)).searchMembers(name, surname, null, null, null);
    }

    @Test
    public void testHandleMembersNotFound() {
        MemberException exception = new MemberException("Member non trovato");

        ErrorResponse errorResponse = memberController.handleMembersContactsNotFound(exception);

        assertEquals(HttpStatus.NOT_FOUND.value(), errorResponse.getStatusCode());
        assertEquals("Member non trovato", errorResponse.getMessage());
    }
}