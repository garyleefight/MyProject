package com.lsr.dao;

import com.lsr.entity.Admin;

/**
 * Created by lsr on 16/10/4.
 */
public interface IAdminDao {
    void save(Admin admin);

    Admin findByName(Admin admin);

    boolean userExists(Admin admin);

}
