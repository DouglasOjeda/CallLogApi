package com.douglasojeda.calllog.controller;

import com.douglasojeda.calllog.model.call.Call;
import com.douglasojeda.calllog.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CallController {

    private final CallService callService;

    @Autowired
    public CallController(CallService callService) {
        this.callService = callService;
    }

    @GetMapping("/calls")
    public List<Call> getAllCalls() {
        return callService.getAllCalls();
    }

    @GetMapping("/calls/{id}")
    public Call getCallById(@PathVariable int id) {
        return callService.getCallById(id);
    }

    @PostMapping("/calls")
    public Call addCall(@RequestBody Call call) {
        return callService.addCall(call);
    }

    @PutMapping("/calls")
    public Call updateCall(@RequestBody Call call) {
        return callService.updateCall(call);
    }

    @DeleteMapping("/calls/{id}")
    public void deleteCallById(@PathVariable int id) {
        callService.deleteCallById(id);
    }
}
