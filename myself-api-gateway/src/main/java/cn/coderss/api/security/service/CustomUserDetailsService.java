package cn.coderss.api.security.service;

import cn.coderss.api.security.model.MUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/12/4
 * Time: 下午9:42
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    JdbcTemplate jdbcTemplate;
    private final String sqlLoadUser;
    private final String sqlLoadAuthorities;
    private final RowMapper<MUser> myUserDetailsRowMapper;
    private final RowMapper<GrantedAuthority> authorityRowMapper;

    Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    public CustomUserDetailsService() {
        super();
        sqlLoadUser = "SELECT id,username,password,enabled FROM m_user WHERE username=?";
        sqlLoadAuthorities = "SELECT authority FROM view_role WHERE username=?";
        myUserDetailsRowMapper = new RowMapper<MUser>() {
            @Override
            public MUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new MUser(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4));
            }
        };
        authorityRowMapper = new RowMapper<GrantedAuthority>() {
            @Override
            public GrantedAuthority mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                return new SimpleGrantedAuthority(rs.getString(1));
            }
        };
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        try {
            MUser userFromQuery = jdbcTemplate.queryForObject(sqlLoadUser,
                    myUserDetailsRowMapper, username);
            logger.debug("查询得到用户："+userFromQuery.toString());
            List<GrantedAuthority> authorities = jdbcTemplate.query(
                    sqlLoadAuthorities, authorityRowMapper, username);
            logger.info("得到其权限:"+authorities.toString());
            return new MUser(userFromQuery.getId(), userFromQuery.getUsername(),
                    userFromQuery.getPassword(), userFromQuery.getEnabled(),
                    authorities);
        } catch (EmptyResultDataAccessException e) {
            logger.debug("查询结果集为空:{}", username);
            throw new UsernameNotFoundException("用户名或密码不正确");
        }
    }
}