package com.gameboard.biz.post;

import java.util.List;

public interface SgpostService {
	public void insertSgpost(Sgpost vo);
	public int getSgID();
	public String getSgDate();
	public List<Sgpost> getSgpostList(Sgpost vo);
	public List<Sgpost> searchSgpost(Sgpost vo);
}
