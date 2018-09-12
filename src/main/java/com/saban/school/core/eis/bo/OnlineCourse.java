package com.saban.school.core.eis.bo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue(value = "online_course")
@PrimaryKeyJoinColumn(referencedColumnName = "course_id")
public class OnlineCourse extends Course {
    @Column(name = "url")
    private String url;
}
