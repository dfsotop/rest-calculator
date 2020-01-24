package co.com.dfsotop.calculator.service.impl;

import co.com.dfsotop.calculator.service.ISessionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SessionServiceImpl implements ISessionService {

    private Map<UUID, List<Number>> sessions = new HashMap<>();

    @Override
    public UUID getNewSession() {
        UUID newSessionId = UUID.randomUUID();
        sessions.put(newSessionId, new ArrayList<>());
        return newSessionId;
    }

    @Override
    public List<Number> getOperandsList(UUID sessionID) {
        List<Number> operands = sessions.get(sessionID);
        if (operands == null)
            throw new NullPointerException("Session not found");
        return sessions.get(sessionID);
    }

    @Override
    public void saveOperandList(UUID sessionId, List<Number> operandsList) {
        sessions.put(sessionId, operandsList);
    }
}
