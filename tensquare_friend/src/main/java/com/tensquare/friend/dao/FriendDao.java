package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend,String> {


    /**
     * 根据用户ID与被关注用户ID查询记录个数
     * @param userid
     * @param friendid
     * @return
     */
    @Query("select count(f) FROM tb_friend f WHERE f.userid = ?1 AND f.friendid = ?2")
    int selectCount(String userid,String friendid);

    /**
     * 更新为互相喜欢
     * @param userid
     * @param friendid
     * @param islike
     */
    @Modifying
    @Query("update tb_friend f set f.islike =?3 WHERE f.userid = ?1 AND f.friendid = ?2")
    void updateLike(String userid,String friendid,String islike);

}
