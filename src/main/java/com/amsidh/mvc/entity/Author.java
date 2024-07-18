package com.amsidh.mvc.entity;

import com.amsidh.mvc.custom.CustomListDeserializer;
import com.amsidh.mvc.custom.CustomListSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "authors")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "authorId")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    //@JsonManagedReference
    @JsonDeserialize(using = CustomListDeserializer.class)
    @JsonSerialize(using = CustomListSerializer.class)
    private List<Book> books;
}
