package com.sxntixgxs.survey.ResponseOption.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sxntixgxs.survey.questions.domain.Question;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "responseOptions")
public class ResponseOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String option_text;
    private String option_number;
    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

}
