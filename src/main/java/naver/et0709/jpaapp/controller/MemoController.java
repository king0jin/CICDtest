package naver.et0709.jpaapp.controller;

import lombok.RequiredArgsConstructor;
import naver.et0709.jpaapp.dto.MemoDTO;
import naver.et0709.jpaapp.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    //"/save"요청 -> 매개변수 -> MemoDTO에 대입
    @PostMapping("/save")
    public ResponseEntity<MemoDTO> save(@RequestBody MemoDTO memoDTO) {
        //필요한 서비스 계층의 메소드 호출
        MemoDTO result = memoService.saveMemo(memoDTO);

        //호출한 서비스 -> Json으로 변환 -> Client에게 전송
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
