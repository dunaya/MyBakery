package com.example.bakery.SERVER.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import com.example.bakery.SERVER.API.DTO.BakerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "teacherMapping",
        classes = @ConstructorResult(
                targetClass = BakerDTO.class,
                columns = {
                        @ColumnResult(name = "id", type=Long.class),
                        @ColumnResult(name = "name", type=String.class),
                        @ColumnResult(name ="surname", type=String.class),
                        @ColumnResult(name ="login", type=String.class),
                        @ColumnResult(name ="password", type=String.class),
                        @ColumnResult(name ="link", type=String.class),
                        @ColumnResult(name ="qualification", type=String.class),

                }
        )
)

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "baker")
public class Baker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty("baker id")
    public Long id;

    @NotNull
    @Column(name = "name", length = 30)
    @ApiModelProperty("baker name")
    public String name;

    @NotNull
    @Column(name = "surname", length = 30)
    @ApiModelProperty("baker surname")
    public String surname;

    @NotNull
    @Column(name = "type", length = 30)
    @ApiModelProperty("baker")
    public String type;


    @NotNull
    @Column(name = "login", length = 30)
    @ApiModelProperty("baker login")
    public String login;


    @NotNull
    @Column(name = "password", length = 30)
    @ApiModelProperty("hash of password")
    @JsonIgnore
    public String password;

    @NotNull
    @Column(name = "link", length = 30)
    @ApiModelProperty("baker link")
    public String link;

    @NotNull
    @Column(name = "qualification", length = 30)
    @ApiModelProperty("qualification")
    public String qualification;
}
