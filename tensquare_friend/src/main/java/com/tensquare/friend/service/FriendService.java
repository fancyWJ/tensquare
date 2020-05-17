package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendService {
    @Autowired
    private FriendDao friendDao;
    @Transactional
    public  int addFriend(String userid,String friendid){
        if(!userid.isEmpty() && !friendid.isEmpty()){
            //判断如果用户已经添加了这个好友，则不进行任何操作，返回0
            int friendCount = friendDao.selectCount(userid, friendid);
            if(friendCount>0){
                return 0;
            }
            //向喜欢表中添加记录
            Friend friend = new Friend();
            friend.setUserid(userid);
            friend.setFriendid(friendid);
            friend.setIslike("0");
            friendDao.save(friend);
            //判断对方是否喜欢你，如果喜欢，将islike设置为1
            if(friendDao.selectCount(friendid,userid)>0){
                friendDao.updateLike(userid,friendid,"1");
                friendDao.updateLike(friendid,userid,"1");
            }
        }else {
            return 0;
        }
        return 1;
    }
}
