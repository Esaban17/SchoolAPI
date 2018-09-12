package com.saban.school.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "office_assignment")
public class OfficeAssignment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instructor_id")
    private Long instructorId;
    //@Column(name = "instructor_id")
    //private Long instructorId;
    private String location;
    @Column(name = "time_stamp")
    private Date timeStamp;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    //@OneToOne(optional = false)
    //@JoinColumn(name = "person_id", nullable = false, insertable = false, updatable = false)
    @JoinColumn(name = "instructor_id", referencedColumnName = "person_id", nullable = false)
    //@OneToOne(mappedBy = "officeAssignment", optional = false)
    private Person person;
}
