package edu.cs.tcu.chineselearningplatform.controller;

import edu.cs.tcu.chineselearningplatform.entity.util.Result;
import edu.cs.tcu.chineselearningplatform.entity.util.StatusCode;
import edu.cs.tcu.chineselearningplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
