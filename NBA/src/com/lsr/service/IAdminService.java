package com.lsr.service;

import com.lsr.entity.Admin;
import com.lsr.exception.UserExistsException;

/**
 * Created by lsr on 16/10/4.
 */
public interface IAdminService {
    void register(Admin admin) throws UserExistsException;

    Admin login(Admin admin);
}
