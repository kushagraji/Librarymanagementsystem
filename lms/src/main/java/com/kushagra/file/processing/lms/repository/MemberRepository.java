package com.kushagra.file.processing.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kushagra.file.processing.lms.model.Book;
import com.kushagra.file.processing.lms.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
