package com.gameboard.biz.post;

import org.apache.ibatis.annotations.Param;

public interface GameMemberDao {
	public void insertGameMember(GameMember member);
	public String getGameMemberId(String memberId);
	public String getJoinDate();
	public int checkIdDuplicate(String memberId);
	public String findId_name(String memberName);
	public String findId_phone(String memberPhone);
	public String findId_email(String memberEmail);
	public String getJoinDateById(String memberId);
	String findId_NameAndPhone(@Param("memberName") String memberName, @Param("memberPhone") String memberPhone);
	String findId_NameAndEmail(@Param("memberName") String memberName, @Param("memberEmail") String memberEmail);
	String findPw_NameAndPhone(@Param("memberId") String memberId, @Param("memberName") String memberName, @Param("memberPhone") String memberPhone);
	String findPw_NameAndEmail(@Param("memberId") String memberId, @Param("memberName") String memberName, @Param("memberEmail") String memberEmail);
	String findMemberByIdAndPw(@Param("memberId") String memberId, @Param("memberPw") String memberPw);
}
