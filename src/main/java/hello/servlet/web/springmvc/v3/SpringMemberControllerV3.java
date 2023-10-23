package hello.servlet.web.springmvc.v3;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
        private MemberRepository memberRepository = MemberRepository.getInstance();

/*
    @RequestMapping(value = "/new-form", method = RequestMethod.GET) //get은 조회하는 메서드
*/
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

/*
    @RequestMapping(method = RequestMethod.GET) //단순 조회니까
*/
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }


/*
    @RequestMapping(value = "/save", method = RequestMethod.POST) //post는 데이터를 변경하는것
*/
    @PostMapping("/save") //위에를 짧게 만든것
    public String save(
            @RequestParam("username") String username, //RequestParam은 매개변수안에 넣기
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

}


