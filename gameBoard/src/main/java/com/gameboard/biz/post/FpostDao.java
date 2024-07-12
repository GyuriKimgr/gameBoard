package com.gameboard.biz.post;

import java.util.List;

public interface FpostDao {
	public void insertFpost(Fpost vo);
	public int getFID();
	public String getFDate();
	public List<Fpost> getFpostList(Fpost vo);
	public List<Fpost> searchFpost(Fpost vo);
	public Fpost getFpostById(int fID);
	public void deleteFpost(int fID);
	public void updateFpost(Fpost vo);
}
