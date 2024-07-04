package com.gameboard.biz.post;

import java.util.List;

public interface WtpostDao {
	public void insertWtpost(Wtpost vo);
	public int getWtID();
	public List<Wtpost> getWtpostList(Wtpost vo);
	public String getWtDate();
}
