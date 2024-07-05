package com.gameboard.biz.post;

import java.util.List;

public interface ModDao {
	public void insertMod(Mod vo);
	public int getMID();
	public String getMDate();
	public List<Mod> getModList(Mod vo);
}
