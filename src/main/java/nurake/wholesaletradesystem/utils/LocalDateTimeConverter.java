/**
 * Created By: NurakeBackendDeveloper
 * Date: 20.02.2023 понедельник
 * Time: 23:30:51
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.utils;

import javax.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Converter
public class LocalDateTimeConverter implements AttributeConverter<LocalDate, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDate attribute) {
        return null;
    }

    @Override
    public LocalDate convertToEntityAttribute(Timestamp dbData) {
        return null;
    }
}
