package com.example.demo.services;

import com.example.demo.models.Role;
import com.example.demo.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    //GET ALL
    public List<Role> getAllRoles(){
        List<Role> result = this.roleRepository.getAllRoles();
        return result;
    }

    //GET BY ID
    public Role getRoleById(int id){
        Role result = this.roleRepository.getRoleById(id);
        return result;
    }

    //INSERT
    public int insertRole(Role role){
        int result = this.roleRepository.insertRole(role);
        return result;
    }

    //UPDATE
    public int updateRole(int id, Role role){
        int result = this.roleRepository.updateRole(id, role);
        return result;
    }

    //DELETE
    public int deleteRole(int id){
        int result = this.roleRepository.deleteRole(id);
        return result;
    }
}
