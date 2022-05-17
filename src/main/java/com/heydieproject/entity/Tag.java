package com.heydieproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_tag")
public class Tag extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long id;
    @Column(unique = true)
    public String label;
    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    @JsonBackReference
    public Set<Post> posts = new HashSet<>();

    public Tag() {
    }

    public Tag(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
