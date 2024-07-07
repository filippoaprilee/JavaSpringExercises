package it.apuliadigital.bibliotecaproject.controller;

import it.apuliadigital.bibliotecaproject.entity.MemberEntity;
import it.apuliadigital.bibliotecaproject.exception.ErrorResponse;
import it.apuliadigital.bibliotecaproject.exception.MemberException;
import it.apuliadigital.bibliotecaproject.exception.SuccessResponse;
import it.apuliadigital.bibliotecaproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/create")
    public SuccessResponse<Integer> createMember(@RequestBody MemberEntity member) {
        int id = memberService.createMember(member);
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Member aggiunto con successo", id);
    }

    @DeleteMapping("/delete/{id}")
    public SuccessResponse<Boolean> deleteMember(@PathVariable int id) {
        boolean success = memberService.deleteMember(id);
        if (success) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Member rimosso con successo", true);
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Member non trovato con id: " + id, false);
    }

    @PutMapping("/update/{id}")
    public SuccessResponse<Boolean> updateMember(@PathVariable int id, @RequestBody MemberEntity member) {
        boolean success = memberService.updateMember(id, member);
        if (success) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Member aggiornato con successo", true);
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Member non trovato con id: " + id, false);
    }

    @GetMapping("/find/{id}")
    public SuccessResponse<MemberEntity> findMember(@PathVariable int id) {
        MemberEntity member = memberService.getMemberById(id);
        if (member != null) {
            return new SuccessResponse<>(HttpStatus.OK.value(), "Member trovato con successo", member);
        }
        return new SuccessResponse<>(HttpStatus.NOT_FOUND.value(), "Member non trovato con id: " + id, null);
    }

    @GetMapping("/all")
    public SuccessResponse<List<MemberEntity>> findAllMembers() {
        List<MemberEntity> members = memberService.getAllMembers();
        return new SuccessResponse<>(HttpStatus.OK.value(), "Members trovati con successo", members);
    }

    @GetMapping("/search")
    public SuccessResponse<List<MemberEntity>> searchMembers(@RequestParam(value = "name", required = false) String name,
                                                             @RequestParam(value = "surname", required = false) String surname,
                                                             @RequestParam(value = "email", required = false) String email,
                                                             @RequestParam(value = "address", required = false) String address,
                                                             @RequestParam(value = "phone", required = false) String phone) {
        List<MemberEntity> members = memberService.searchMembers(name, surname, email, address, phone);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Members trovati con successo", members);
    }

    // metodo per gestire le eccezioni
    @ExceptionHandler(value = MemberException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleMembersContactsNotFound(MemberException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
