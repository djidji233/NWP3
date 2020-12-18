package rs.edu.raf.nwp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rs.edu.raf.nwp.model.Group;
import rs.edu.raf.nwp.model.User;
import rs.edu.raf.nwp.model.UserType;
import rs.edu.raf.nwp.repositories.GroupRepository;
import rs.edu.raf.nwp.repositories.UserRepository;
import rs.edu.raf.nwp.repositories.UserTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class BootstrapData implements CommandLineRunner {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    public BootstrapData(GroupRepository groupRepository, UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("Loading data...");

        String[] GROUP_LIST = {"Prva","Druga","Treca"};
        String[] USER_TYPE_LIST = {"Smrtnik","Povlascen","Admin"};
        String[] FIRST_NAME_LIST = {"Marko", "Pavle", "Djordje", "Dusan", "Nenad", "Nikola", "Sanja", "Sofija", "Kristina", "Tamara"};
        String[] LAST_NAME_LIST = {"Pavlovic", "Novakovic", "Trajkovic", "Jerinic", "Azerovic", "Sretenovic", "Zivanovic", "Jovanovic", "Mladenovic", "Krtina"};

        Random random = new Random();



        List<UserType> userTypes = new ArrayList<>();
        for(int i=0; i<USER_TYPE_LIST.length; i++){
            UserType userType = new UserType();
            userType.setIme(USER_TYPE_LIST[i]);
            userTypes.add(userType);
        }
        System.out.println(userTypeRepository.saveAll(userTypes));
        //System.out.println(userTypeRepository.findAll());

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setIme(FIRST_NAME_LIST[random.nextInt(FIRST_NAME_LIST.length)]);
            user.setPrezime(LAST_NAME_LIST[random.nextInt(LAST_NAME_LIST.length)]);
            user.setTip(userTypes.get(random.nextInt(USER_TYPE_LIST.length)));
            //user.setTip(userTypeRepository.findById(1l).get());
            users.add(user);
            System.out.println(userRepository.save(user));
        }
        //System.out.println(userRepository.saveAll(users));

        List<Group> groups = new ArrayList<>();
        for(int i=0; i<GROUP_LIST.length; i++){
            Group group = new Group();
            group.setIme(GROUP_LIST[i]);
            groups.add(group);
        }
        System.out.println(groupRepository.saveAll(groups));

        System.out.println("DATA LOADED!");

    }
}
