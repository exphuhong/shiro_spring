package com.IFox.shiro.bean;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.sql.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by exphuhong
 * Date 17-11-16.
 * Start
 * 需要查询数据库并且得到正确的数据
 */
public class ShiroRealm extends AuthenticatingRealm{

    /**
     * 1、 doGetAuthenticationInfo 获取认证消息　如果数据库中没有数据　返回null 如果正确　返回封装的对象
     * 2、 AuthenticationInfo 可以使用SimpleAuthenticationInfo 实现类　封装给你正确的用户名和密码
     * 3、 token参数　就是我们要认证的token
     *
     * */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //将token转换成userNamePasswordToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SimpleAuthenticationInfo info = null;
        //获取用户名即可
        String userName = token.getUsername();

        //查询数据库，是否存在指定用户名和密码的用户
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///ifoxMember";
            Connection connection = DriverManager.getConnection(url,"mysql","mysqladmin");
            String sql = "select * from shiro_User where userName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, token.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Object principal = userName;
                Object credentials = resultSet.getString(3);
                String relamName = this.getName();
                info = new SimpleAuthenticationInfo(principal,credentials,relamName);

            } else {
                throw new AuthenticationException();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        //如果查询到了，封装查询结果，返回给我们的调用

        //如果没有查到抛出一个异常
        return info;
    }

    @Override
    public boolean isPermitted(PrincipalCollection principalCollection, String s) {
        return false;
    }

    @Override
    public boolean isPermitted(PrincipalCollection principalCollection, Permission permission) {
        return false;
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection principalCollection, String... strings) {
        return new boolean[0];
    }

    @Override
    public boolean[] isPermitted(PrincipalCollection principalCollection, List<Permission> list) {
        return new boolean[0];
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection principalCollection, String... strings) {
        return false;
    }

    @Override
    public boolean isPermittedAll(PrincipalCollection principalCollection, Collection<Permission> collection) {
        return false;
    }

    @Override
    public void checkPermission(PrincipalCollection principalCollection, String s) throws AuthorizationException {

    }

    @Override
    public void checkPermission(PrincipalCollection principalCollection, Permission permission) throws AuthorizationException {

    }

    @Override
    public void checkPermissions(PrincipalCollection principalCollection, String... strings) throws AuthorizationException {

    }

    @Override
    public void checkPermissions(PrincipalCollection principalCollection, Collection<Permission> collection) throws AuthorizationException {

    }

    @Override
    public boolean hasRole(PrincipalCollection principalCollection, String s) {
        return false;
    }

    @Override
    public boolean[] hasRoles(PrincipalCollection principalCollection, List<String> list) {
        return new boolean[0];
    }

    @Override
    public boolean hasAllRoles(PrincipalCollection principalCollection, Collection<String> collection) {
        return false;
    }

    @Override
    public void checkRole(PrincipalCollection principalCollection, String s) throws AuthorizationException {

    }

    @Override
    public void checkRoles(PrincipalCollection principalCollection, Collection<String> collection) throws AuthorizationException {

    }

    @Override
    public void checkRoles(PrincipalCollection principalCollection, String... strings) throws AuthorizationException {

    }
}
