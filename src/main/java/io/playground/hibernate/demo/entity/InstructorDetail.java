package io.playground.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "instructor_detail")
@Data
@ToString(exclude = "instructor")
public class InstructorDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "youtube_channel")
  private String youtubeChannel;

  @Column(name = "hobby")
  private String hobby;

  @OneToOne(
      mappedBy = "instructorDetail",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private Instructor instructor;

  public InstructorDetail() {}

  public InstructorDetail(String youtubeChannel, String hobby) {
    this.youtubeChannel = youtubeChannel;
    this.hobby = hobby;
  }
}
