package com.gameboard.biz.post;

import java.util.List;

public interface SgpostService {
	public void insertSgpost(Sgpost vo);
	public int getSgID();
	public String getSgDate();
	public List<Sgpost> getSgpostList(Sgpost vo);
	public List<Sgpost> searchSgpost(Sgpost vo);
	public Sgpost getSgpostById(int sgID);
	public void deleteSgpost(int sgID);
	public void updateSgpost(Sgpost vo);
	public Sgpost getNextSgpost(int sgID);
	public Sgpost getPrevSgpost(int sgID);
	public void updateSgpostViews(int sgID);
	
}
