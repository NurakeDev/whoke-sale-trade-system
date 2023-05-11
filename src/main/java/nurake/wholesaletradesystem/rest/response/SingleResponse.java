/**
 * Created By: NurakeBackendDeveloper
 * Date: 02.03.2023 четверг
 * Time: 23:34:50
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SingleResponse {

    private boolean success;
    private String message;
    private Object data;
    private List<Object> dataList;
    private Map<String, Object> meta = new HashMap<>();
    private HttpStatus httpStatus;

    public SingleResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
        if (data instanceof List) {
            this.dataList = (List) data;
        } else if (data instanceof Set) {
            this.dataList = (List<Object>) data;
        }
        if (success)
            httpStatus = HttpStatus.OK;
    }

    public SingleResponse(boolean success, String message, HttpStatus httpStatus) {
        this.success = success;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public SingleResponse(boolean success, String message){
        this.success = success;
        this.message = message;
        if (success)
            httpStatus = HttpStatus.OK;
    }

}
