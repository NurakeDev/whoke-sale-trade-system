/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:47:06
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.AgentDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface AgentService {
    SingleResponse getAll();

    SingleResponse save(AgentDto agentDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, AgentDto agentDto);

    SingleResponse delete(Long id);

}
