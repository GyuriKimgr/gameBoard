package com.gameboard.biz.post;

public class GameMember {
	private String memberId;
	private String memberPw;
	private String memberName; 
	private String memberEmail;
	private String memberBirth;
	private String memberGender;
	private String memberNation;
	private String memberPhone;
	private String memberJoinDate;
	private String memberId_check;
	
	public GameMember() {};
	
	public GameMember(String memberId, String memberPw, String memberName, String memberEmail, String memberBirth,
			String memberGender, String memberNation, String memberPhone, String memberJoinDate,
			String memberId_check) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberBirth = memberBirth;
		this.memberGender = memberGender;
		this.memberNation = memberNation;
		this.memberPhone = memberPhone;
		this.memberJoinDate = memberJoinDate;
		this.memberId_check = memberId_check;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberNation() {
		return memberNation;
	}

	public void setMemberNation(String memberNation) {
		this.memberNation = memberNation;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberJoinDate() {
		return memberJoinDate;
	}

	public void setMemberJoinDate(String memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}

	public String getMemberId_check() {
		return memberId_check;
	}

	public void setMemberId_check(String memberId_check) {
		this.memberId_check = memberId_check;
	}
}
