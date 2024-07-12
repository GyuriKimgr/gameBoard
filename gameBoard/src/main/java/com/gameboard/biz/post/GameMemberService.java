package com.gameboard.biz.post;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GameMemberService {
	public void insertGameMember(GameMember member);
	public String getGameMemberId(String memberId);
	public String getJoinDate();
	public int checkIdDuplicate(String memberId);
	public String findId_name(String memberName);
	public String findId_phone(String memberPhone);
	public String findId_email(String memberEmail);
	public String findId_NameAndPhone(@Param("memberName") String memberName, @Param("memberPhone") String memberPhone);
}
