/**
 * Created By: NurakeBackendDeveloper
 * Date: 28.02.2023 вторник
 * Time: 15:37:34
 * Project Name: wholesale-trade-system
 */
package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.request.AuthRequest;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface AuthService {
    SingleResponse registerPartially(AuthRequest.RegisterPartially request);
}
