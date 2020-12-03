package com.codegym.service;

import com.codegym.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> findALl();

    Member findById(Integer id);

}
