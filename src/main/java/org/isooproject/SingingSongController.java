package org.isooproject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingingSongController {

    @CrossOrigin
    @GetMapping("/sing")
    public SingingSong singingSong() {
        SingingSong singingSong = new SingingSong();
        singingSong.setSinger("leesoo");
        singingSong.setSongTitle("10cm - 스토커");
        return singingSong;
    }
}
