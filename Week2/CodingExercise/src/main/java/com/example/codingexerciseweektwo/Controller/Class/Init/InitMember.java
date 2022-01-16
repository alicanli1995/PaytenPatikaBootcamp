package com.example.codingexerciseweektwo.Controller.Class.Init;

import com.example.codingexerciseweektwo.Controller.Class.Member;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Scope("singleton")
@Component


public class InitMember {
    List<Member> memberList = new ArrayList<>();
    public InitMember(){
        memberList.add(new Member(1,"Ali",2000,"alic@gmail.com",null,null));
        memberList.add(new Member(2,"Veli",1980,"alga@gmail.com",null,null));
        memberList.add(new Member(3,"Deli",1700,"ssdic@gmail.com",null,null));
        memberList.add(new Member(4,"Hasan",1980,"ada@gmail.com",null,null));
    }


    public List<Member> getMemberList(){
        return memberList;
    }

}
