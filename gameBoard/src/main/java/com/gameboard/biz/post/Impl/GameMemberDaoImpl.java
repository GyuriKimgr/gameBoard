package com.gameboard.biz.post.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gameboard.biz.post.GameMember;
import com.gameboard.biz.post.GameMemberDao;

@Repository
public class GameMemberDaoImpl implements GameMemberDao {
    @Autowired
    private SqlSessionTemplate mybatis;
    
    @Override
    public void insertGameMember(GameMember member) {
    	member.setMemberJoinDate(getJoinDate());
        mybatis.insert("GameMemberDao.insertMember", member);
    }
    
    @Override
    public String getGameMemberId(String memberId) {
        return mybatis.selectOne("GameMemberDao.getGameMemberId", memberId);
    }
    
    @Override
    public String getJoinDate() {
        return mybatis.selectOne("GameMemberDao.getJoinDate");
    }

    @Override
    public int checkIdDuplicate(String memberId) {
        return mybatis.selectOne("GameMemberDao.checkIdDuplicate", memberId);
    }
}
