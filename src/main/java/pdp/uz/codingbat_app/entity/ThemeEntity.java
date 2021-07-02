package pdp.uz.codingbat_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "theme")
public class ThemeEntity extends BaseModel{

    private String description;

    @ManyToOne
    private LanguagesEntity languages;
}
