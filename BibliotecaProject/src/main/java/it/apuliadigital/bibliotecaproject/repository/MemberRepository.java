package it.apuliadigital.bibliotecaproject.repository;

import it.apuliadigital.bibliotecaproject.entity.MemberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<MemberEntity, Integer> {
    List<MemberEntity> findByName(String name);
    List<MemberEntity> findBySurname(String surname);
    List<MemberEntity> findByEmail(String email);
    List<MemberEntity> findByAddress(String address);
    List<MemberEntity> findByPhone(String phone);
    List<MemberEntity> findByNameAndSurname(String name, String surname);
}