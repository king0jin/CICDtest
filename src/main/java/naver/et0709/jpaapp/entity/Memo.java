package naver.et0709.jpaapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "memo")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memo_id;

    @Column(length = 200, nullable=false)
    private String memoText;
}
