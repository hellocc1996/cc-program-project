package com.program.user.service;


import com.program.user.entity.*;
import com.program.user.req.*;

import java.util.List;


public interface UserService {

    public UserEntity login(LoginReq loginReq);

    public List<UserEntity> findUsers(UserQueryReq userQueryReq);

    UserEntity register(RegisterReq registerReq);

    void batchUpdateUserState(BatchReq<UserStateReq> userStateReqs);

    void createAdminUser(AdminCreateReq adminCreateReq);

    List<RoleEntity> findRoles();

    void deleteRole(String roleId);

    void updateMenuOfRole(RoleMenuReq roleMenuReq);

    void updatePermissionOfRole(RolePermissionReq rolePermissionReq);

    List<PermissionEntity> findPermissions();

    List<MenuEntity> findMenus();

    List<LocationEntity> findLocations(String userId);

    String createLocation(LocationCreateReq locationCreateReq, String userId);

    void deleteLocation(String locationId, String userId);

    void modifyLocation(LocationUpdateReq locationUpdateReq, String userId);
}
