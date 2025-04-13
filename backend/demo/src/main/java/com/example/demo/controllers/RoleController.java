package com.example.demo.controllers;

import com.example.demo.models.Role;
import com.example.demo.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    //GET ALL
    @GetMapping
    public List<Role> getAllRoles(){
        List<Role> result = this.roleService.getAllRoles();
        return result;
    }

    //GET BY ID
    @GetMapping(value = "/{id}")
    public Role getRoleById(@PathVariable("id") int id){
        Role result = this.roleService.getRoleById(id);
        return result;
    }

    //INSERT
    @PostMapping()
    public int insertProject(@RequestBody Role role){
        int result = this.roleService.insertRole(role);
        return result;
    }

    //UPDATE
    @PutMapping(value = "/{id}")
    public int updateRole(@PathVariable("id") int id, @RequestBody Role role){
        int result = this.roleService.updateRole(id, role);
        return result;
    }

    //DELETE
    @DeleteMapping(value = "/{id}")
    public int deleteRole(@PathVariable("id") int id){
        int result = this.roleService.deleteRole(id);
        return result;
    }
}
