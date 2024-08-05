package com.gameboard.biz.post.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
    public String findId_email(String memberEmail) {
        String count = mybatis.selectOne("GameMemberDao.findId_email", memberEmail);
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
    public String findId_NameAndEmail(String memberName, String memberEmail) {
        Map<String, Object> params = new HashMap<>();
        params.put("memberName", memberName);
        params.put("memberEmail", memberEmail);
        String id = mybatis.selectOne("GameMemberDao.findId_NameAndEmail", params);
        return id; 
    }
    
    @Override
    public String findPw_NameAndPhone(String memberId, String memberName, String memberPhone) {
        Map<String, Object> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("memberName", memberName);
        params.put("memberPhone", memberPhone);
        String pw = mybatis.selectOne("GameMemberDao.findPw_NameAndPhone", params);
        return pw; 
    }
    
    @Override
    public String findPw_NameAndEmail(String memberId, String memberName, String memberEmail) {
        Map<String, Object> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("memberName", memberName);
        params.put("memberEmail", memberEmail);
        String pw = mybatis.selectOne("GameMemberDao.findPw_NameAndEmail", params);
        return pw; 
    }
    
    @Override
    public String findMemberByIdAndPw(String memberId, String memberPw) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("memberId", memberId);
    	params.put("memberPw", memberPw);
    	// 디버깅용 로그 추가
        System.out.println("DAO: findMemberByIdAndPw - " + params);
        String gm = mybatis.selectOne("GameMemberDao.findMemberByIdAndPw", params);
        System.out.println("DAO: findMemberByIdAndPw - " + gm);
    	return gm;
    }
}
