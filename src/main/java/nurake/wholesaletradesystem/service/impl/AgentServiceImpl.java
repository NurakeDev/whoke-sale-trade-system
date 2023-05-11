/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:52:09
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.user.Agent;
import nurake.wholesaletradesystem.repository.AgentRepository;
import nurake.wholesaletradesystem.rest.dto.AgentDto;
import nurake.wholesaletradesystem.rest.response.AgentResponse;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {


    private final AgentRepository agentRepository;

    @Override
    public SingleResponse getAll() {
        List<Agent> all = agentRepository.findAll();
        ArrayList<AgentResponse> responses = new ArrayList<>();
        for (Agent agent : all) {
            AgentResponse response = new AgentResponse(
                    agent.getId(), agent.getFullName(),
                    agent.getPhoneNumber(),
                    agent.getPassword(),
                    agent.getPasswordConfirmation(),
                    agent.getAddress(),
                    agent.getPermissions(),
                    agent.getOrders()
            );
            responses.add(response);

        }
        return new SingleResponse(true, "Admin List", responses);
    }

    @Override
    public SingleResponse save(AgentDto agentDto) {
        Agent agent = new Agent();
        agent.setFullName(agentDto.getFullName());
        agent.setPassword(agentDto.getPassword());
        agent.setPasswordConfirmation(agentDto.getPasswordConfirmation());
        agent.setPhoneNumber(agentDto.getPhoneNumber());
        agent.setPermissions(agentDto.getPermissions());
        agent.setAddress(agentDto.getAddress());
        agent.setPermissions(agentDto.getPermissions());
        agentRepository.save(agent);
        return new SingleResponse(true, "Agent successfully created", HttpStatus.OK);
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Agent> byId = agentRepository.findById(id);
        if (byId.isPresent()) {
            Agent agent = byId.get();
            AgentResponse adminResponse = new AgentResponse(
                    agent.getId(),
                    agent.getFullName(),
                    agent.getPhoneNumber(),
                    agent.getPassword(),
                    agent.getPasswordConfirmation(),
                    agent.getAddress(),
                    agent.getPermissions(),
                    agent.getOrders()
            );
            return new SingleResponse(true, "Agent by id {" + id + "}", adminResponse);
        }
        return new SingleResponse(false, "Agent not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse update(Long id, AgentDto agentDto) {
        Optional<Agent> byId = agentRepository.findById(id);
        if (byId.isPresent()) {
            Agent agent = byId.get();

            if(agentDto.getFullName() != null && !agent.getFullName().equals(agentDto.getFullName())){
                agent.setFullName(agentDto.getFullName());
            }

            if(agentDto.getPhoneNumber() != null && !agent.getPhoneNumber().equals(agentDto.getPhoneNumber())){
                agent.setPhoneNumber(agentDto.getPhoneNumber());
            }

            if(agentDto.getPassword() != null && !agent.getPassword().equals(agentDto.getPassword()) &&
                    agentDto.getPassword().equals(agentDto.getPasswordConfirmation())){
                agent.setPassword(agentDto.getPassword());
            }

            if (agentDto.getPermissions() != null && !agent.getPermissions().equals(agentDto.getPermissions())){
                agent.setPermissions(agentDto.getPermissions());
            }

            if (agentDto.getAddress() != null && !agent.getAddress().equals(agentDto.getAddress())){
                agent.setAddress(agentDto.getAddress());
            }

            if (agentDto.getOrders() != null && !agent.getOrders().equals(agentDto.getOrders())){
                agent.setOrders(agentDto.getOrders());
            }

            agentRepository.save(agent);
            return new SingleResponse(true, "Agent successfully updated");
        }
        return new SingleResponse(false, "Agent not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        Optional<Agent> byId = agentRepository.findById(id);
        if (byId.isPresent()) {
            Agent agent = byId.get();
            agentRepository.delete(agent);
            return new SingleResponse(true, "Agent successfully deleted");
        }
        return  new SingleResponse(false, "Agent not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }
}
