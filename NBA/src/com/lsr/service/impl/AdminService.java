package com.lsr.service.impl;

import com.lsr.dao.IAdminDao;
import com.lsr.dao.impl.AdminDao;
import com.lsr.entity.Admin;
import com.lsr.exception.UserExistsException;
import com.lsr.service.IAdminService;

/**
 * Created by lsr on 16/10/4.
 */
public class AdminService implements IAdminService{
    private IAdminDao adminDao=new AdminDao();
    @Override
    public void register(Admin admin) throws UserExistsException {

        try {
            if(!adminDao.userExists(admin)){
                adminDao.save(admin);
            }else{
                //*remind the user exists
                    throw new UserExistsException("username already exists");
                }
        } catch (UserExistsException e) {
            throw e;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public Admin login(Admin admin) {
        try {
            return adminDao.findByName(admin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
