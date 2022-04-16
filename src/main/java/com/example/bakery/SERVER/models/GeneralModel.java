package com.example.bakery.SERVER.models;

import com.example.bakery.SERVER.API.DTO.GeneralModelDTO;
import io.swagger.annotations.ApiModelProperty;
import com.example.bakery.SERVER.API.DTO.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "roleMapping",
        classes = @ConstructorResult(
                targetClass = GeneralModelDTO.class,
                columns = {
                        @ColumnResult(name ="id", type =String.class),
                        @ColumnResult(name ="type", type =String.class),
                }
        )
)

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "genRole")
public class GeneralModel {

    @NotNull
    @Column(name = "type", length = 30)
    @ApiModelProperty("admin name")
    public String type;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("account id")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
