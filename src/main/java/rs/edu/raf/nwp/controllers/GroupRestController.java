package rs.edu.raf.nwp.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.nwp.model.Group;
import rs.edu.raf.nwp.services.GroupService;
import rs.edu.raf.nwp.services.UserService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/groups")
public class GroupRestController {

    private final GroupService groupService;
    private final UserService userService;

    public GroupRestController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Group> getAllGroups(){ return groupService.findAll(); }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGroupById(@RequestParam("groupId") Long id){
        Optional<Group> optionalGroup = groupService.findById(id);
        if(optionalGroup.isPresent()) {
            return ResponseEntity.ok(optionalGroup.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Group createGroup(@RequestBody Group group) {
        return groupService.save(group);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Group updateGroup(@RequestBody Group group){
        return groupService.save(group);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable("id") Long id){
        groupService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{groupId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUserToGroup(@PathVariable Long groupId,
                                                @RequestParam("userId") Long userId){

        Group group = groupService.findById(groupId).get();
        group.addUser(userService.findById(userId).get());
        groupService.save(group);
        return ResponseEntity.ok().build();
    }

}
