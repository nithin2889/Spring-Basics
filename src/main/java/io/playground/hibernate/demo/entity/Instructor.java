package io.playground.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "instructor")
@Data
@ToString
public class Instructor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "instructor_detail_id")
  private InstructorDetail instructorDetail;

  @OneToMany(
      fetch = FetchType.LAZY,
      mappedBy = "instructor",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Course> courses;

  public Instructor() {}

  public Instructor(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  // convenience method to setup a bi-directional relationship
  public void add(Course course) {
    if (courses == null) {
      courses = new ArrayList<>();
    }
    courses.add(course);
    course.setInstructor(this);
  }
}
