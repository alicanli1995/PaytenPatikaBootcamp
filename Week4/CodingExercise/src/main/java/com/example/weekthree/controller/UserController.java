package com.example.weekthree.controller;


import com.example.weekthree.controller.request.MemberCreateRequest;
import com.example.weekthree.controller.request.MemberDeleteRequest;
import com.example.weekthree.controller.response.MemberCreateResponse;
import com.example.weekthree.controller.response.MemberDeleteResponse;
import com.example.weekthree.controller.response.MemberResponse;
import com.example.weekthree.models.Member;
import com.example.weekthree.services.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor


public class UserController {

    /*
        Bu api veritabanına kullanıcı eklenilip silinebilmesi için oluşturulmuştur.

        * delete endpointinin çalışabilmesi için geçerli bir memberId girilmesi gerekmektedir.
        * get endpointi için Redis cacheable örneği implemente edilmiştir. İlk çağırmada 2 sn delay vardır,
        metot 2.01 gibi bir sürede çalışmaktadır,  ikinci çağırmada cacheable özelliği datayı cacheden
        döndürerek 5-8 ms aralığına çekmektedir. Her 3 çağırmada bir memory cache clear edilerek yenilenmektedir.
     */


    private final MemberService userService;
    private int counter = 0;

    @PostMapping("/member")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberCreateResponse createMember(@RequestBody @Valid MemberCreateRequest memberCreateRequest){
        Member member = memberCreateRequest.convertToMember();
        Long id = userService.create(member);
        return MemberCreateResponse.convertToMemberResponse(id);
    }

    @GetMapping("/member")
    @ResponseStatus(HttpStatus.OK)
    public List<MemberResponse> allMembers() throws InterruptedException {
        if (counter == 3){
            userService.clearCache();
            counter = 0;
        }
        counter++;
        List<Member> memberList = userService.getAllMembers();
        return MemberResponse.convertFromMember(memberList);
    }


    @DeleteMapping("member")
    @ResponseStatus(HttpStatus.GONE)
    public MemberDeleteResponse delete(@RequestBody @Valid MemberDeleteRequest memberDeleteRequest){
        Long deleteMemberId = userService.delete(memberDeleteRequest.getMemberId());
        return MemberDeleteResponse.convertToMemberDeleteResponse(deleteMemberId);
    }

}
