package com.gameboard.biz.post;

import java.util.List;

public interface ModService {
	public void insertMod (Mod vo);
	public int getMID();
	public String getMDate();
	public List<Mod> getModList(Mod vo);
	public List<Mod> searchMod(Mod vo);
	public Mod getModById(int mID);
	public void deleteMod(int mID);
	public void updateMod(Mod vo);
	public Mod getNextMod(int mID);
	public Mod getPrevMod(int mID);
	public void updateModViews(int mID);

}
