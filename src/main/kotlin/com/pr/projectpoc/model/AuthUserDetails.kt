package com.pr.projectpoc.model

import org.springframework.security.core.authority.AuthorityUtils.createAuthorityList
import org.springframework.security.core.userdetails.UserDetails

class AuthUserDetails(var user: User) : UserDetails {
    override fun getAuthorities() = createAuthorityList(*user.authorities.toTypedArray())
    override fun isEnabled() = user.enabled
    override fun getUsername() = user.email
    override fun isCredentialsNonExpired() = user.credentialsNonExpired
    override fun getPassword() = user.password
    override fun isAccountNonExpired() = user.accountNonExpired
    override fun isAccountNonLocked() = user.accountNonLocked
}