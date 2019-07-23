package com.lambdaschool.school;
// Vivek Vishwanath

import com.lambdaschool.school.model.Role;
import com.lambdaschool.school.model.User;
import com.lambdaschool.school.model.UserRoles;
import com.lambdaschool.school.repository.RoleRepository;
import com.lambdaschool.school.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;
    public SeedData(RoleRepository rolerepos, UserRepository userrepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
    }
    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("ADMIN");
        Role r2 = new Role("ZOODATA");
        Role r3 = new Role("ANIMALDATA");
        Role r4 = new Role("MGR");
        rolerepos.save(r1);
        rolerepos.save(r2);
        rolerepos.save(r3);
        rolerepos.save(r4);
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        User u1 = new User("admin", "password", admins);
        userrepos.save(u1);
        ArrayList<UserRoles> zoodata = new ArrayList<>();
        zoodata.add(new UserRoles(new User(), r2));
        User u2 = new User("barnbarn", "ILuvM4th!", zoodata);
        userrepos.save(u2);
        ArrayList<UserRoles> animaldata = new ArrayList<>();
        animaldata.add(new UserRoles(new User(), r3));
        User u3 = new User("jane", "password", animaldata);
        userrepos.save(u3);
        ArrayList<UserRoles> mgrdata = new ArrayList<>();
        mgrdata.add(new UserRoles(new User(), r4));
        User u4 = new User("bob", "password", mgrdata);
        userrepos.save(u4);

        admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        User u5 = new User("hops", "password", admins);
        userrepos.save(u5);
    }
}