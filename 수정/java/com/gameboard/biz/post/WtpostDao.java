package com.gameboard.biz.post;

import java.util.List;

public interface WtpostDao {
	public void insertWtpost(Wtpost vo);
	public int getWtID();
	public String getWtDate();
	public List<Wtpost> getWtpostList(Wtpost vo);
	public List<Wtpost> searchWtpost(Wtpost vo);
}
