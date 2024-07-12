package com.gameboard.biz.post;

public interface GameMemberDao {
	public void insertGameMember(GameMember member);
	public String getGameMemberId(String memberId);
	public String getJoinDate();
	public int checkIdDuplicate(String memberId);
}
