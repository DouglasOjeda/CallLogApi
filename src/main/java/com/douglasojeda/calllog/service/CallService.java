package com.douglasojeda.calllog.service;

import com.douglasojeda.calllog.model.call.Call;
import com.douglasojeda.calllog.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService {
    private final CallRepository callRepository;

    @Autowired
    public CallService(CallRepository callRepository) {
        this.callRepository = callRepository;
    }

    public List<Call> getAllCalls() {
        return callRepository.findAll();
    }

    public Call getCallById(int id) {
        return callRepository.findById(id).orElse(null);
    }

    public Call addCall(Call call) {
        return callRepository.save(call);
    }

    public Call updateCall(Call call) {
        return callRepository.save(call);
    }

    public void deleteCallById(int id) {
        callRepository.deleteById(id);
    }
}
