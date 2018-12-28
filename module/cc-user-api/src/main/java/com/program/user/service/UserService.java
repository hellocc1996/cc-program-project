package com.program.user.service;


import com.program.user.entity.*;
import com.program.user.req.*;

import java.util.List;


public interface UserService {
    public CcAdminUsers queryAdminUserInfo(AdminUserQueryReq req);
}
