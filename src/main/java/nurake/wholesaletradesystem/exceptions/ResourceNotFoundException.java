/**
 * Created By: NurakeBackendDeveloper
 * Date: 03.03.2023 пятница
 * Time: 16:15:34
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
