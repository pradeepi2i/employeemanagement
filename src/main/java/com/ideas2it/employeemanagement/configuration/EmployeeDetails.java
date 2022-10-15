//package com.ideas2it.employeemanagement.configuration;
//
//import com.ideas2it.employeemanagement.dto.EmployeeDTO;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import java.util.Collection;
//import java.util.Collections;
//
//public class EmployeeDetails implements UserDetails {
//
//
//    private EmployeeDTO employeeDTO;
//
//    public EmployeeDetails(EmployeeDTO employeeDTO) {
//        this.employeeDTO = employeeDTO;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("USER"));
//    }
//
//    @Override
//    public String getPassword() {
//        return (employeeDTO.getId() + "");
//    }
//
//    @Override
//    public String getUsername() {
//        return employeeDTO.getFirstName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
