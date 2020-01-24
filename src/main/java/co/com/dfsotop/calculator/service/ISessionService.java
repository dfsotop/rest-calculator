package co.com.dfsotop.calculator.service;

import java.util.List;
import java.util.UUID;

public interface ISessionService {
    UUID getNewSession();
    List<Number> getOperandsList(UUID sessionId);
    void saveOperandList(UUID sessionId, List<Number> operandsList);
}
