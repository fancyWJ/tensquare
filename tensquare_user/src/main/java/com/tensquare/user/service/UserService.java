package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

@Service
@Transactional
public class UserService {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    private UserDao userDao;
    @Autowired
    private IdWorker idWorker;
    public void add(User user){
        user.setId(idWorker.nextId()+""); //主键值
        //密码加密
        String encodePwd = encoder.encode(user.getPassword());
        user.setPassword(encodePwd);
        userDao.save(user);
    }

    /**
     * 根据手机号和密码查询用户
     * @param mobile
     * @param password
     * @return
     */
    public User findByMobileAndPassword(String mobile,String password){
        User user = userDao.findByMobile(mobile);
        if(user != null && encoder.matches(password,user.getPassword())){
            return user;
        }else {
            return null;
        }
    }
    public void deleteById(String id){
        userDao.deleteById(id);
    }
}
