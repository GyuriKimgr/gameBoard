package com.gameboard.biz.post.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int count = mybatis.selectOne("GameMemberDao.checkIdDuplicate", memberId);
        return count;
    }
    
    
    @Override
    public String findId_name(String memberName) {
        String count = mybatis.selectOne("GameMemberDao.findId_name", memberName);
        return count;
    }
    
    @Override
    public String findId_phone(String memberPhone) {
        String count = mybatis.selectOne("GameMemberDao.findId_phone", memberPhone);
        return count;
    }
    
    @Override
    public String findId_NameAndPhone(String memberName, String memberPhone) {
        Map<String, Object> params = new HashMap<>();
        params.put("memberName", memberName);
        params.put("memberPhone", memberPhone);
        String id = mybatis.selectOne("GameMemberDao.findId_NameAndPhone", params);
        return id; 
    }
    
    @Override
    public String findId_email(String memberEmail) {
        String count = mybatis.selectOne("GameMemberDao.findId_email", memberEmail);
        return count;
    }
}
