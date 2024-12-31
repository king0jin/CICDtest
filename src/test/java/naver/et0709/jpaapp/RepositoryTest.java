package naver.et0709.jpaapp;

import naver.et0709.jpaapp.entity.Memo;
import naver.et0709.jpaapp.persistence.MemoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    MemoRepository memoRepository;

    //주입 확인 TEST : Bean생성 + 주입
    @Test
    @Disabled
    public void testDependency(){
        System.out.println(memoRepository.getClass().getName());
    }
    //데이터베이스 테이블과 열결 확인 TEST
    @Test
    @Disabled
    public void testInsert(){
        IntStream.range(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Simple.." + 1).build();
            memoRepository.save(memo);
        });
    }

    //CRUD 작업 확인 TEST
    @Test
    public void testFind(){
        System.out.println(memoRepository.findByMemoText("Simple..35"));
    }

    //
    @Test
    public void testSequence(){
        Memo memo = Memo.builder().memoText("Simple..100").build();
        memoRepository.save(memo);
        System.out.println(memoRepository.findByMemoText("Simple..100"));
    }
}
