package com.saban.school.core.eis.bo;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Data
@Entity
@DiscriminatorValue(value = "onsite_course")
@PrimaryKeyJoinColumn(referencedColumnName = "course_id")
public class OnsiteCourse extends Course {
    private String location;
    private String days;
    private Date time;
}
