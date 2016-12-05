package com.amir.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="BLOG_USER")
public class BlogUser implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    @Column(name="BLOGGER_NAME")
    private String name;

    @Column(name="BLOGGER_EMAIL")
    private String email;

    @Column(name = "BLOGGER_PASSWORD")
    private String password;

    @Column(name = "USER_ROLE")
    private String role="ROLE_USER";

    @Transient
    private String passwordConfirm;

    @JsonIgnore
    @OneToMany(mappedBy="author", cascade=CascadeType.PERSIST)
    private List<Topics> topics = new ArrayList<>();

    public BlogUser( String name,String email, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public BlogUser() {
    }

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(this.role);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "BlogUser{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
