package com.codegym.service.impl;

import com.codegym.entity.Member;
import com.codegym.repository.MemberRepository;
import com.codegym.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public List<Member> findALl() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(Integer id) {
        return memberRepository.findById(id).orElse(null);
    }
}
