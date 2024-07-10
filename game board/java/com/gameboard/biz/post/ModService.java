package com.gameboard.biz.post;

import java.util.List;

public interface ModService {
	public void insertMod (Mod vo);
	public int getMID();
	public String getMDate();
	public List<Mod> getModList(Mod vo);
	public List<Mod> searchMod(Mod vo);
}