package com.IFox.shiro.bean;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;
import java.util.List;

/**
 * Created by exphuhong
 * Date 17-11-16.
 * Start
 */
public class ShiroRealm implements Realm {
    public String getName() {
        return null;
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return false;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }

    public boolean isPermitted(PrincipalCollection principalCollection, String s) {
        return false;
    }

    public boolean isPermitted(PrincipalCollection principalCollection, Permission permission) {
        return false;
    }

    public boolean[] isPermitted(PrincipalCollection principalCollection, String... strings) {
        return new boolean[0];
    }

    public boolean[] isPermitted(PrincipalCollection principalCollection, List<Permission> list) {
        return new boolean[0];
    }

    public boolean isPermittedAll(PrincipalCollection principalCollection, String... strings) {
        return false;
    }

    public boolean isPermittedAll(PrincipalCollection principalCollection, Collection<Permission> collection) {
        return false;
    }

    public void checkPermission(PrincipalCollection principalCollection, String s) throws AuthorizationException {

    }

    public void checkPermission(PrincipalCollection principalCollection, Permission permission) throws AuthorizationException {

    }

    public void checkPermissions(PrincipalCollection principalCollection, String... strings) throws AuthorizationException {

    }

    public void checkPermissions(PrincipalCollection principalCollection, Collection<Permission> collection) throws AuthorizationException {

    }

    public boolean hasRole(PrincipalCollection principalCollection, String s) {
        return false;
    }

    public boolean[] hasRoles(PrincipalCollection principalCollection, List<String> list) {
        return new boolean[0];
    }

    public boolean hasAllRoles(PrincipalCollection principalCollection, Collection<String> collection) {
        return false;
    }

    public void checkRole(PrincipalCollection principalCollection, String s) throws AuthorizationException {

    }

    public void checkRoles(PrincipalCollection principalCollection, Collection<String> collection) throws AuthorizationException {

    }

    public void checkRoles(PrincipalCollection principalCollection, String... strings) throws AuthorizationException {

    }
}
