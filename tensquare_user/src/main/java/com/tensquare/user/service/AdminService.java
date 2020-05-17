package com.tensquare.user.service;

import com.tensquare.user.dao.AdminDao;
import com.tensquare.user.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    private IdWorker idWorker;
    public void add(Admin admin){
        admin.setId(idWorker.nextId()+""); //主键值
        //密码加密
        String encodePwd = encoder.encode(admin.getPassword());
        admin.setPassword(encodePwd);
        adminDao.save(admin);
    }

    /**
     * 根据登录名和密码查询
     * @param loginname
     * @param password
     * @return
     */
    public Admin findByLoginnameAndPassword(String loginname,String password){
        Admin admin = adminDao.findByLoginname(loginname);
        if(admin != null && encoder.matches(password,admin.getPassword())){
            return admin;
        }else{
            return null;
        }
    }


}
