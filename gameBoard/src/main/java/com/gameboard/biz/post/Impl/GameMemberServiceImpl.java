package com.gameboard.biz.post.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gameboard.biz.post.GameMember;
import com.gameboard.biz.post.GameMemberDao;
import com.gameboard.biz.post.GameMemberService;

@Service("GameMemberService")
public class GameMemberServiceImpl implements GameMemberService{
	@Autowired
	private GameMemberDao gameMemberDao;
	
	@Override
	public void insertGameMember(GameMember member) {
		gameMemberDao.insertGameMember(member);
	}

	@Override
	public String getGameMemberId(String memberId) {
		return gameMemberDao.getGameMemberId(memberId);
	}

	@Override
	public String getJoinDate() {
		return gameMemberDao.getJoinDate();
	}

	@Override
	public int checkIdDuplicate(String memberId) {
		return gameMemberDao.checkIdDuplicate(memberId);
	}
	
    @Override
    public String findId_name(String memberName) {
        String count = gameMemberDao.findId_name(memberName);
        return count;
    }
	
    @Override
    public String findId_phone(String memberPhone) {
        String count = gameMemberDao.findId_phone(memberPhone);
        return count;
    }
	
    @Override
    public String findId_email(String memberEmail) {
        String count = gameMemberDao.findId_email(memberEmail);
        return count;
    }
    
    @Override
    public String findId_NameAndPhone(String memberName, String memberPhone) {
        // 데이터베이스 매퍼를 통해 이름과 전화번호로 아이디 조회
        return gameMemberDao.findId_NameAndPhone(memberName, memberPhone);
    }

    @Override
    public String findId_NameAndEmail(String memberName, String memberEmail) {
        // 데이터베이스 매퍼를 통해 이름과 이메일로 비밀번호 조회
        return gameMemberDao.findId_NameAndEmail(memberName, memberEmail);
    }
    
    @Override
    public String findPw_NameAndPhone(String memberId, String memberName, String memberPhone) {
        // 데이터베이스 매퍼를 통해 아이디와 이름, 전화번호로 비밀번호 조회
        return gameMemberDao.findPw_NameAndPhone(memberId, memberName, memberPhone);
    }

    @Override
    public String findPw_NameAndEmail(String memberId, String memberName, String memberEmail) {
        // 데이터베이스 매퍼를 통해 아이디와 이름, 이메일로로 비밀번호 조회
        return gameMemberDao.findPw_NameAndEmail(memberId, memberName, memberEmail);
    }
    
    @Override
    public String findMemberByIdAndPw(String memberId, String memberPw) {
    	return gameMemberDao.findMemberByIdAndPw(memberId, memberPw);
    }
}
