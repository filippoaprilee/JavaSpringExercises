package it.apuliadigital.bibliotecaproject.service.impl;

import it.apuliadigital.bibliotecaproject.entity.MemberEntity;
import it.apuliadigital.bibliotecaproject.repository.MemberRepository;
import it.apuliadigital.bibliotecaproject.service.LogService;
import it.apuliadigital.bibliotecaproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private LogService logService;

    @Override
    public int createMember(MemberEntity member) {
        int memberId = memberRepository.save(member).getId();
        logService.saveLog("/member/create", "Creazione membro con ID: " + memberId);
        return memberId;
    }

    @Override
    public MemberEntity getMemberById(int id) {
        logService.saveLog("/member/find/" + id, "Ricerca membro con ID: " + id);
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public List<MemberEntity> getAllMembers() {
        logService.saveLog("/member/all", "Membri trovati");
        return (List<MemberEntity>) memberRepository.findAll();
    }

    @Override
    public boolean updateMember(int id, MemberEntity member) {
        logService.saveLog("/member/update/" + id, "Aggiornamento membro con ID: " + id);
        if (memberRepository.existsById(id)) {
            member.setId(id);
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMember(int id) {
        logService.saveLog("/member/delete/" + id, "Rimozione membro con ID: " + id);
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<MemberEntity> searchMembers(String name, String surname, String email, String address, String phone) {
        logService.saveLog("/member/search", "Ricerca membri con parametri: " +
                (name != null ? "name=" + name + " " : "") +
                (surname != null ? "surname=" + surname + " " : "") +
                (email != null ? "email=" + email + " " : "") +
                (address != null ? "address=" + address + " " : "") +
                (phone != null ? "phone=" + phone : ""));
        if (name != null && surname != null) {
            return memberRepository.findByNameAndSurname(name, surname);
        } else if (name != null) {
            return memberRepository.findByName(name);
        } else if (surname != null) {
            return memberRepository.findBySurname(surname);
        } else if (email != null) {
            return memberRepository.findByEmail(email);
        } else if (address != null) {
            return memberRepository.findByAddress(address);
        } else if (phone != null) {
            return memberRepository.findByPhone(phone);
        } else {
            return null;
        }
    }
}
