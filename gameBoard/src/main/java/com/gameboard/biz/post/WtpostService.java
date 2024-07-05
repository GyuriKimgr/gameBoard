package com.gameboard.biz.post;

import java.util.List;

public interface WtpostService {
	public void insertWtpost(Wtpost vo);
	public int getWtID();
	public String getWtDate();
	public List<Wtpost> getWtpostList(Wtpost vo);
	public Wtpost getWtpostById(int wtID);
}
