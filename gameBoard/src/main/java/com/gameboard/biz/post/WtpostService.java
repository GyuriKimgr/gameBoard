package com.gameboard.biz.post;

import java.util.List;

public interface WtpostService {
	public void insertWtpost(Wtpost vo);
	public int getWtID();
	public List<Wtpost> getWtpostList(Wtpost vo);
}
