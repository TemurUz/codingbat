package pdp.uz.codingbat_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@Entity
@Table(name = "languages")
public class LanguagesEntity extends BaseModel {
}
