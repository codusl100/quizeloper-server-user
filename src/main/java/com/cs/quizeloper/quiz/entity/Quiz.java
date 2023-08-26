package com.cs.quizeloper.quiz.entity;

import com.cs.quizeloper.global.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@DynamicInsert
@DynamicUpdate
@Entity
@NoArgsConstructor
public class Quiz extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuizType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Stack stackUnit;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private String solving;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "quiz_unit_id")
    private QuizUnit quizUnit;

    @Builder
    public Quiz(String title, String content, QuizType type, Stack stackUnit, String answer, String solving, QuizUnit quizUnit) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.stackUnit = stackUnit;
        this.answer = answer;
        this.solving = solving;
        this.quizUnit = quizUnit;
    }
}
