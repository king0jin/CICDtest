package naver.et0709.jpaapp.persistence;

import naver.et0709.jpaapp.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    //memoTest를 이용한 조회
    List<Memo> findByMemoText(String memoText);
}
