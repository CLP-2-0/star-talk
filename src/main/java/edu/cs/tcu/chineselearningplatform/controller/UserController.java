package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.User;
import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Method to find one user.
     * @param username of the user to be sought.
     * @return Result object that contains flag, status code, message, and found user.
     */
    @GetMapping("/{username}")
    @ResponseBody
    public Result findByUserName(@PathVariable String username) {
        return new Result(true, StatusCode.SUCCESS, "Find by user by username success", userService.findByUsername(username));
    }
    @GetMapping("/all/{requestedRole}")
    @ResponseBody
    public Result findByRequestedRole(@PathVariable String requestedRole) {
        return new Result(true, StatusCode.SUCCESS, "Find by user by requested Role success", userService.findByRequestedRole(requestedRole));
    }
    @GetMapping
    @ResponseBody
    public Result findALl(){
        List<User> all = userService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find All users", all);
    }
    @PostMapping
    @ResponseBody
    public Result save(@RequestBody User newUser){
        userService.save(newUser);
        return new Result(true, StatusCode.SUCCESS, "Create user success");
    }

    @PutMapping("/{username}")
    @ResponseBody
    public Result update(@PathVariable String username, @RequestBody User updatedUser){
        userService.update(username,updatedUser);
        return new Result(true, StatusCode.SUCCESS, "Update user success");
    }

//    @PutMapping("/{username}/picture")
//    @ResponseBody
//    public Result updatePicture(@PathVariable String username, @RequestBody String picture){
//        userService.update(username, picture);
//        return new Result(true, StatusCode.SUCCESS, "Update user success");
//    }

    @DeleteMapping("/{username}")
    @ResponseBody
    public Result delete(@PathVariable String username){
        userService.delete(username);
        return new Result(true,StatusCode.SUCCESS,"Delete success");
    }

}