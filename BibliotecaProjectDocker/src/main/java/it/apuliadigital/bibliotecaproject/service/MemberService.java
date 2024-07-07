package it.apuliadigital.bibliotecaproject.service;

import it.apuliadigital.bibliotecaproject.entity.MemberEntity;

import java.util.List;

public interface MemberService {
    int createMember(MemberEntity member);
    MemberEntity getMemberById(int id);
    List<MemberEntity> getAllMembers();
    boolean updateMember(int id, MemberEntity member);
    boolean deleteMember(int id);
    List<MemberEntity> searchMembers(String name, String surname, String email, String address, String phone);
}
