package com.connxun.sys.dao;


import com.connxun.common.vo.ComboboxVO;
import com.connxun.sys.model.SysUser;
import com.connxun.sys.vo.SysUserSearchVO;
import com.connxun.util.page.PageUtil;
import com.connxun.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Date;
import java.util.List;

@Repository
public class SysUserDao  {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SysUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int add(SysUser sysUser) {
        String sql = "insert into sys_user(username,password,telephone,randomcode,status,realname,create_date,create_person,role_id) value(?,?,?,?,?,?,?,?,?)";
        Object[] paramSource= new Object[]{sysUser.getUsername(),sysUser.getPassword(),sysUser.getTelephone(),sysUser.getRandomcode(),sysUser.getStatus(),
                                           sysUser.getRealname(),new Date(),sysUser.getCreate_person(),sysUser.getRole_id()};
        int rc = jdbcTemplate.update(sql, paramSource,new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.VARCHAR,Types.DATE,Types.VARCHAR,Types.INTEGER});
        if (rc > 0) {
            return 1;
        } else {
            return 0;
        }
    }
   /* public int add(SysUser sysUser) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into sys_user(username,password,telephone,randomcode,status,realname,create_date,create_person,role_id)";
        sql += "      values(:username,:password,:telephone,:randomcode,1,:realname,:createDate(),:create_person,:role_id,)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysUser);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rc = namedParameterJdbcTemplate.update(sql, paramSource, keyHolder);
        if (rc > 0) {
            return keyHolder.getKey().intValue();
        } else {
            return 0;
        }
    }*/

    public int update(SysUser sysUser) {
        String sql = "UPDATE sys_user SET realname='"+sysUser.getRealname()+"',     role_id= "+sysUser.getRole_id()+" ,  password = '"+sysUser.getPassword()+" '   WHERE id  =   "+sysUser.getId();
        int rc = jdbcTemplate.update(sql);
        if (rc > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 修改密码
     *
     * @return
     */
    public int updatePass(int id, String newPass, String randowmcode) {
        String sql = "UPDATE sys_user SET password=?,randomcode=?  WHERE id=? ";
        Object[] objects = new Object[]{newPass, randowmcode, id};
        return jdbcTemplate.update(sql, objects);
    }

    /**
     * 修改个人信息，用户自己操作
     *
     * @param sysUser
     * @return
     */
    public int updateInfo(SysUser sysUser) {
        String sql = "UPDATE sys_user SET realname=:realname,telephone=:telephone WHERE id=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysUser);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    /**
     * 修改状态
     *
     * @param status
     * @return
     */
    public int updateStatus(int id, int status) {
        String sql = "UPDATE sys_user SET status=?  WHERE id=?";
        Object[] objects = new Object[]{status, id};
        return jdbcTemplate.update(sql, objects);
    }

    public int delete(int id) {
        String sql = "UPDATE sys_user SET status = 101 WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public SysUser get(int id) {
        String sql = "SELECT * FROM sys_user WHERE id=?";
        Object[] params = new Object[]{id};
        List<SysUser> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(SysUser.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    /**
     * 根据username获取sysUser
     *
     * @param username
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public SysUser getByUsername(String username) {
        String sql = "SELECT *,(SELECT name FROM sys_role WHERE id=role_id) role_name FROM sys_user WHERE username=?";
        Object[] params = new Object[]{username};
        List<SysUser> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(SysUser.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    /**
     * 查询该用户名是否已存在,根据email来判断
     *
     * @param username
     * @return
     */
    public int getUsernameCount(String username) {
        String sql = "SELECT count(*) FROM sys_user WHERE username=? ";
        Object[] objects = new Object[]{username};
        return jdbcTemplate.queryForObject(sql, objects, Integer.class);
    }

    /**
     * 查询用户信息
     *
     * @param sysUserSearchVO
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<SysUser> list(SysUserSearchVO sysUserSearchVO, int pageIndex, int pageSize) {
        String sql = "select *, " + "(select name from sys_role where id=role_id) role_name  from sys_user where 1=1 ";
        sql += createSearchSql(sysUserSearchVO);
        sql += " order by id asc";
        sql = PageUtil.createMysqlPageSql(sql, pageIndex, pageSize);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysUserSearchVO);
        List<SysUser> list = namedParameterJdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(SysUser.class));
        return list;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<SysUser> listAll() {
        String sql = "select *,(select name from sys_role where id=role_id) role_name  from sys_user where 1=1  ";
        sql += " order by id asc";
        List<SysUser> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(SysUser.class));
        return list;
    }

    /**
     * 查询用户总数
     *
     * @param sysUserSearchVO
     * @return
     */
    public int listCount(SysUserSearchVO sysUserSearchVO) {
        String sql = "select count(*) from sys_user where 1=1 ";
        sql += createSearchSql(sysUserSearchVO);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(sysUserSearchVO);
        return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Integer.class);
    }

    private String createSearchSql(SysUserSearchVO sysUserSearchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(sysUserSearchVO.getUsername())) {
            sql += " and username=:username";
        }
        if (StringUtil.isNotNullOrEmpty(sysUserSearchVO.getRealname())) {
            sql += " and realname like '%" + StringUtil.filterSpecialCharacter(sysUserSearchVO.getRealname()) + "%'";
        }
        if (sysUserSearchVO.getRole_id() != null) {
            sql += " and role_id=:role_id";
        }
        if (sysUserSearchVO.getStatus() != null) {
            sql += " and status=:status";
        }
        return sql;
    }

    /**
     * 所有人员列表，查询日志使用
     *
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<ComboboxVO> listAllUser() {
        String sql = "SELECT id value,username content,realname name FROM sys_user  ORDER BY id";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(ComboboxVO.class));
    }


    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<SysUser> searchByUsername(String username) {
        String sql = "SELECT id,username FROM sys_user WHERE username LIKE ? ";
        return jdbcTemplate.query(sql, new Object[]{"%" + username + "%"}, new BeanPropertyRowMapper(SysUser.class));
    }
}
