/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:53:28
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.PermissionDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    @Override
    public SingleResponse getAll() {
        return null;
    }

    @Override
    public SingleResponse save(PermissionDto permissionDto) {
        return null;
    }

    @Override
    public SingleResponse findById(Long id) {
        return null;
    }

    @Override
    public SingleResponse update(Long id, PermissionDto permissionDto) {
        return null;
    }

    @Override
    public SingleResponse delete(Long id) {
        return null;
    }
}
