package com.example.LandPays.AppUser;

import com.example.LandPays.HouseManager.House;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Entity
public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator( name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long Id;
    private String firstname;

    public AppUser(String firstname, String lastname, String password, String email, AppUserRole appUserRole, Long house_booked) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.appUserRole = appUserRole;
        this.house_booked = house_booked;
    }

    private String lastname;
    private String password;
    private String email;
    @OneToOne
    private House house;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Long house_booked;


//    public AppUser(String firstname,
//                   String lastname,
//                   String password,
//                   String email,
//                   AppUserRole appUserRole
//                  ) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.password = password;
//        this.email = email;
//        this.appUserRole = appUserRole;

//    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());

        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
