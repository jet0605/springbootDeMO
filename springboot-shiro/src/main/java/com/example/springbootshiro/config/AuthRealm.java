package com.example.springbootshiro.config;

import com.example.springbootshiro.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Configuration;


import java.util.*;

@Configuration
public class AuthRealm extends AuthorizingRealm {
    /**
     * 只有需要验证权限的时候才会调用，授权查询回调函数，进行鉴权但缓存中无用户的授权信息时调用，在配有缓存的情况下，
     * 如果需要动态权限，但是又不想每次去数据库校验，可以存在ehcache中，自行完善
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        //权限信息对象info，用来存放查出的用户的所有角色(role)及权限(permission)
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add(user.getRolename());
        info.setRoles(roles);
        //用户角色对应的所有权限，如果只使用角色定义访问权限，下面可以不要
        //只有角色并没有颗粒度到每一个按钮或是操作选项 PERMISSIONS 是可选项
        final Map<String,Collection<String>> permissionsCache = DBCache.PERMISSIONS_CACHE;
        final Collection<String> permissions = permissionsCache.get(user.getRolename());
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 认证回调函数,登录时调用
     * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
     * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
     * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
     * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
     * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
     * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
     * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        User user = Optional.ofNullable(DBCache.USERS_CACHE.get(principal)).orElseThrow(UnknownAccountException::new);
        if(!user.isLocked()){
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal,user.getPassword(),getName());
        org.apache.shiro.session.Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION",user);
        return authenticationInfo;
    }
}
