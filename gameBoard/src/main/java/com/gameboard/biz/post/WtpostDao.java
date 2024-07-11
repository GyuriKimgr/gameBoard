package com.gameboard.biz.post;

import java.util.List;

public interface WtpostDao {
	public void insertWtpost(Wtpost vo);
	public int getWtID();
	public List<Wtpost> getWtpostList(Wtpost vo);
	public String getWtDate();
	public Wtpost getWtpostById(int wtID);
	public void deleteWtpost(int wtID);
	public void updateWtpost(Wtpost vo);
	public Wtpost getNextWtpost(int wtID);
	public Wtpost getPrevWtpost(int wtID);
	public void updateWtpostViews(int wtID);
	

	
}
