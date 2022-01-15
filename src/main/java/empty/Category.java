package empty;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

    private Integer id;
    private String name;
    private boolean active;
}
