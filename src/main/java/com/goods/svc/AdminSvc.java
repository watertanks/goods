package com.goods.svc;

import java.util.List;
import com.goods.vo.*;

public interface AdminSvc {
	
	long getAllMemberCnt () throws Exception;
	
	long getNewMemberCnt() throws Exception;
}
