package com.twin.DigitalWind;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("/wind")
public class processingHTTP {

    @PostMapping("/getnoise")
    public String processnoise(@RequestBody String requestIndex) {
        if(StringUtils.isNumeric(requestIndex)){
            return Arrays.toString(DigitalWindApplication.Noise.get(Integer.parseInt(requestIndex)));
        }
        return "null";
    }

    @PostMapping("/getreference")
    public String processreference(@RequestBody String requestIndex) {
        if(StringUtils.isNumeric(requestIndex)){
            return Arrays.toString(DigitalWindApplication.Reference.get(Integer.parseInt(requestIndex)));
        }
        return "null";
    }

    @PostMapping("/getefficiency")
    public String processefficiency(@RequestBody String requestIndex) {
        if(StringUtils.isNumeric(requestIndex)){
            return Arrays.toString(DigitalWindApplication.Efficiency.get(Integer.parseInt(requestIndex)));
        }
        return "null";
    }
}
