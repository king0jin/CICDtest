package naver.et0709.jpaapp;

import com.google.gson.Gson;
import naver.et0709.jpaapp.controller.MemoController;
import naver.et0709.jpaapp.dto.MemoDTO;
import naver.et0709.jpaapp.service.MemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//Controller를 테스트 할 때는 가짜 요청을 보내서 테스트하므로
//클래스를 만들 때 어노테이션이 다릅니다.
@WebMvcTest(MemoController.class)
public class ControllerTest {
    //실제가 아닌 가짜 객체를 생성해주기 위한 MockMvc를 외부로부터 주입
    //실제가 아니고 가짜로 실제 요청이 성공하는지만 테스트하기 위한 객체를 사용하기 위한 주입
    @Autowired
    private MockMvc mockMvc;

    //MemoController가 MemoService 객체를 주입받아야만 생성되기 때문에 이를 위해서
    //가짜로 인스턴스를 만들어서 주입되는 것처럼 동작시킵니다.
    //실제 Service 메서드를 호출하지는 않습니다.
    @MockitoBean
    MemoService memoService;

    @Test
    public void createMemo() throws Exception {
        //Controller 의 요청에 사용할 파라미터 객체를 생성
        MemoDTO memoDTO = MemoDTO.builder().
                memo("Controller Test").build();

        //웹의 파라미터로 변경
        Gson gson = new Gson();
        String content = gson.toJson(memoDTO);

        //테스트
        //post 방식으로 save 요청을 보내고 파라미터는 content이며
        //기대하는 결과는 Ok - 200
        mockMvc.perform(
                        post("/save")
                                .content(content)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}

