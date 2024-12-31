package naver.et0709.jpaapp;

import naver.et0709.jpaapp.dto.MemoDTO;
import naver.et0709.jpaapp.service.MemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    //대비되는 인스턴스는 MemberServiceImpl
    //변수를 선언할 때는 MemberService 인터페이스 타입으로 선언
    //확인하고자 하는 것은 메서드의 수행 여부인데 MemberServiceImpl가 실구현체이다
    //그러나 실제 외부에서 바라볼 때는 MemberService인터페이스를 바라본다

    //주입 받는 방법
    //변수위에 @Autowired 이용 - setter를 이용해서 주입
    //final로 변수를 선언하고 클래스 상단에 @RequiredArgsConstructor를 이용 - 생성자를 이용하여 주입
    @Autowired
    MemoService memoService;

    @Test
    public void testDependency(){
        System.out.println(memoService.getClass().getName());
    }

    @Test
    public void testInsert(){
        MemoDTO memoDTO = MemoDTO.builder().memo("삽입 서비스 테스트").build();
        System.out.println(memoService.saveMemo(memoDTO));
    }
}
