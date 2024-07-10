package com.gameboard.biz.post.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		int result = gameMemberDao.checkIdDuplicate(memberId);
		return result;
	}
	
}
