package com.sxntixgxs.survey.chapters.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sxntixgxs.survey.questions.domain.Question;
import com.sxntixgxs.survey.surveys.domain.models.Survey;

import java.util.Date;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date created_at;
    private Date updated_at;
    private String chapter_number;
    private String chapter_title;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    @JsonIgnore
    private Survey survey;
    @OneToMany(mappedBy = "chapter",cascade = CascadeType.ALL)
    private List<Question> questions;

}
