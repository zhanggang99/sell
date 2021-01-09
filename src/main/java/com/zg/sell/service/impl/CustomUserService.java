package com.zg.sell.service.impl;

import com.zg.sell.domain.User;
import com.zg.sell.domain.UserRoleRel;
import com.zg.sell.error.BusinessException;
import com.zg.sell.service.RoleService;
import com.zg.sell.service.UserRoleRelService;
import com.zg.sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//public class CustomUserService implements UserDetailsService {

//    @Autowired
//    private UserService userService;
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private UserRoleRelService userRoleRelService;

//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user=userService.findByUserName(s);
//        if (user==null)
//            throw new BusinessException("用户不存在");
//        //获取用户所有关联角色
//        List<UserRoleRel> roleRels =userRoleRelService.findByUserId(user.getId());
//        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
//        if (roleRels!=null&&roleRels.size()>0){
//            roleRels.forEach(role->{
//                //获取用户关联角色名字
//                authorities.add(new SimpleGrantedAuthority(roleService.find(role.getRoleId()).getName()));
//            });
//        }
//        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),authorities);
//    }
//}
